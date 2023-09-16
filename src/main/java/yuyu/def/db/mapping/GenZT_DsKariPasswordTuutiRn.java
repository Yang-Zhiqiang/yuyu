package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_DsKariPasswordTuutiRn;
import yuyu.def.db.id.PKZT_DsKariPasswordTuutiRn;
import yuyu.def.db.meta.GenQZT_DsKariPasswordTuutiRn;
import yuyu.def.db.meta.QZT_DsKariPasswordTuutiRn;

/**
 * 仮パスワード通知テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_DsKariPasswordTuutiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DsKariPasswordTuutiRn}</td><td colspan="3">仮パスワード通知テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnkrpasswordtuutikey zrnkrpasswordtuutikey}</td><td>（連携用）仮パスワード通知キー</td><td align="center">{@link PKZT_DsKariPasswordTuutiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndskokno zrndskokno}</td><td>（連携用）ＤＳ顧客番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatesakiyno zrnatesakiyno}</td><td>（連携用）宛先郵便番号</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatesakiynobarcode zrnatesakiynobarcode}</td><td>（連携用）宛先郵便番号バーコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakuseimd zrnsakuseimd}</td><td>（連携用）作成月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsclakadskokno zrnsclakadskokno}</td><td>（連携用）スクランブル化ＤＳ顧客番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnreigaisyorihyj zrnreigaisyorihyj}</td><td>（連携用）例外処理表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyuubinbutukanpusakiyno zrnyuubinbutukanpusakiyno}</td><td>（連携用）郵便物還付先郵便番号</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyuubinbutukanpusakiadr zrnyuubinbutukanpusakiadr}</td><td>（連携用）郵便物還付先住所</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatesakiadr1 zrnatesakiadr1}</td><td>（連携用）宛先住所１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatesakiadr2 zrnatesakiadr2}</td><td>（連携用）宛先住所２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatesakiadr3 zrnatesakiadr3}</td><td>（連携用）宛先住所３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatena1 zrnatena1}</td><td>（連携用）宛名１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatena2 zrnatena2}</td><td>（連携用）宛名２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syoukaisakifreearea1 zrndai1syoukaisakifreearea1}</td><td>（連携用）第１照会先フリーエリア１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syoukaisakifreearea2 zrndai1syoukaisakifreearea2}</td><td>（連携用）第１照会先フリーエリア２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syoukaisakifreearea3 zrndai1syoukaisakifreearea3}</td><td>（連携用）第１照会先フリーエリア３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syoukaisakifreearea4 zrndai1syoukaisakifreearea4}</td><td>（連携用）第１照会先フリーエリア４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syoukaisakifreearea5 zrndai1syoukaisakifreearea5}</td><td>（連携用）第１照会先フリーエリア５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakuseino zrnsakuseino}</td><td>（連携用）作成No</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnokyakusamanm zrnokyakusamanm}</td><td>（連携用）お客様氏名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhkymd zrnhkymd}</td><td>（連携用）発行日</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndskrhnnkakcdyoken zrndskrhnnkakcdyoken}</td><td>（連携用）ＤＳ仮本人確認コード与件</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkrpasswordyuukouymd zrnkrpasswordyuukouymd}</td><td>（連携用）仮パスワード有効年月日</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea1 zrnfreearea1}</td><td>（連携用）フリーエリア１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea2 zrnfreearea2}</td><td>（連携用）フリーエリア２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea3 zrnfreearea3}</td><td>（連携用）フリーエリア３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea4 zrnfreearea4}</td><td>（連携用）フリーエリア４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea5 zrnfreearea5}</td><td>（連携用）フリーエリア５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyuuijikou1 zrntyuuijikou1}</td><td>（連携用）注意事項欄１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyuuijikou2 zrntyuuijikou2}</td><td>（連携用）注意事項欄２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyuuijikou3 zrntyuuijikou3}</td><td>（連携用）注意事項欄３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyuuijikou4 zrntyuuijikou4}</td><td>（連携用）注意事項欄４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyuuijikou5 zrntyuuijikou5}</td><td>（連携用）注意事項欄５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyuuijikou6 zrntyuuijikou6}</td><td>（連携用）注意事項欄６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyuuijikou7 zrntyuuijikou7}</td><td>（連携用）注意事項欄７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 * </table>
 * @see     ZT_DsKariPasswordTuutiRn
 * @see     PKZT_DsKariPasswordTuutiRn
 * @see     QZT_DsKariPasswordTuutiRn
 * @see     GenQZT_DsKariPasswordTuutiRn
 */
@MappedSuperclass
@Table(name=GenZT_DsKariPasswordTuutiRn.TABLE_NAME)
@IdClass(value=PKZT_DsKariPasswordTuutiRn.class)
public abstract class GenZT_DsKariPasswordTuutiRn extends AbstractExDBEntityForZDB<ZT_DsKariPasswordTuutiRn, PKZT_DsKariPasswordTuutiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DsKariPasswordTuutiRn";
    public static final String ZRNKRPASSWORDTUUTIKEY    = "zrnkrpasswordtuutikey";
    public static final String ZRNDSKOKNO               = "zrndskokno";
    public static final String ZRNATESAKIYNO            = "zrnatesakiyno";
    public static final String ZRNATESAKIYNOBARCODE     = "zrnatesakiynobarcode";
    public static final String ZRNSAKUSEIMD             = "zrnsakuseimd";
    public static final String ZRNSCLAKADSKOKNO         = "zrnsclakadskokno";
    public static final String ZRNREIGAISYORIHYJ        = "zrnreigaisyorihyj";
    public static final String ZRNYUUBINBUTUKANPUSAKIYNO = "zrnyuubinbutukanpusakiyno";
    public static final String ZRNYUUBINBUTUKANPUSAKIADR = "zrnyuubinbutukanpusakiadr";
    public static final String ZRNATESAKIADR1           = "zrnatesakiadr1";
    public static final String ZRNATESAKIADR2           = "zrnatesakiadr2";
    public static final String ZRNATESAKIADR3           = "zrnatesakiadr3";
    public static final String ZRNATENA1                = "zrnatena1";
    public static final String ZRNATENA2                = "zrnatena2";
    public static final String ZRNDAI1SYOUKAISAKIFREEAREA1 = "zrndai1syoukaisakifreearea1";
    public static final String ZRNDAI1SYOUKAISAKIFREEAREA2 = "zrndai1syoukaisakifreearea2";
    public static final String ZRNDAI1SYOUKAISAKIFREEAREA3 = "zrndai1syoukaisakifreearea3";
    public static final String ZRNDAI1SYOUKAISAKIFREEAREA4 = "zrndai1syoukaisakifreearea4";
    public static final String ZRNDAI1SYOUKAISAKIFREEAREA5 = "zrndai1syoukaisakifreearea5";
    public static final String ZRNSAKUSEINO             = "zrnsakuseino";
    public static final String ZRNOKYAKUSAMANM          = "zrnokyakusamanm";
    public static final String ZRNHKYMD                 = "zrnhkymd";
    public static final String ZRNDSKRHNNKAKCDYOKEN     = "zrndskrhnnkakcdyoken";
    public static final String ZRNKRPASSWORDYUUKOUYMD   = "zrnkrpasswordyuukouymd";
    public static final String ZRNFREEAREA1             = "zrnfreearea1";
    public static final String ZRNFREEAREA2             = "zrnfreearea2";
    public static final String ZRNFREEAREA3             = "zrnfreearea3";
    public static final String ZRNFREEAREA4             = "zrnfreearea4";
    public static final String ZRNFREEAREA5             = "zrnfreearea5";
    public static final String ZRNTYUUIJIKOU1           = "zrntyuuijikou1";
    public static final String ZRNTYUUIJIKOU2           = "zrntyuuijikou2";
    public static final String ZRNTYUUIJIKOU3           = "zrntyuuijikou3";
    public static final String ZRNTYUUIJIKOU4           = "zrntyuuijikou4";
    public static final String ZRNTYUUIJIKOU5           = "zrntyuuijikou5";
    public static final String ZRNTYUUIJIKOU6           = "zrntyuuijikou6";
    public static final String ZRNTYUUIJIKOU7           = "zrntyuuijikou7";

    private final PKZT_DsKariPasswordTuutiRn primaryKey;

    public GenZT_DsKariPasswordTuutiRn() {
        primaryKey = new PKZT_DsKariPasswordTuutiRn();
    }

    public GenZT_DsKariPasswordTuutiRn(String pZrnkrpasswordtuutikey) {
        primaryKey = new PKZT_DsKariPasswordTuutiRn(pZrnkrpasswordtuutikey);
    }

    @Transient
    @Override
    public PKZT_DsKariPasswordTuutiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DsKariPasswordTuutiRn> getMetaClass() {
        return QZT_DsKariPasswordTuutiRn.class;
    }

    @Id
    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNKRPASSWORDTUUTIKEY)
    public String getZrnkrpasswordtuutikey() {
        return getPrimaryKey().getZrnkrpasswordtuutikey();
    }

    public void setZrnkrpasswordtuutikey(String pZrnkrpasswordtuutikey) {
        getPrimaryKey().setZrnkrpasswordtuutikey(pZrnkrpasswordtuutikey);
    }

    private String zrndskokno;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNDSKOKNO)
    public String getZrndskokno() {
        return zrndskokno;
    }

    public void setZrndskokno(String pZrndskokno) {
        zrndskokno = pZrndskokno;
    }

    private String zrnatesakiyno;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNATESAKIYNO)
    public String getZrnatesakiyno() {
        return zrnatesakiyno;
    }

    @DataConvert("toMultiByte")
    public void setZrnatesakiyno(String pZrnatesakiyno) {
        zrnatesakiyno = pZrnatesakiyno;
    }

    private String zrnatesakiynobarcode;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNATESAKIYNOBARCODE)
    public String getZrnatesakiynobarcode() {
        return zrnatesakiynobarcode;
    }

    public void setZrnatesakiynobarcode(String pZrnatesakiynobarcode) {
        zrnatesakiynobarcode = pZrnatesakiynobarcode;
    }

    private String zrnsakuseimd;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNSAKUSEIMD)
    public String getZrnsakuseimd() {
        return zrnsakuseimd;
    }

    public void setZrnsakuseimd(String pZrnsakuseimd) {
        zrnsakuseimd = pZrnsakuseimd;
    }

    private String zrnsclakadskokno;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNSCLAKADSKOKNO)
    public String getZrnsclakadskokno() {
        return zrnsclakadskokno;
    }

    public void setZrnsclakadskokno(String pZrnsclakadskokno) {
        zrnsclakadskokno = pZrnsclakadskokno;
    }

    private String zrnreigaisyorihyj;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNREIGAISYORIHYJ)
    public String getZrnreigaisyorihyj() {
        return zrnreigaisyorihyj;
    }

    public void setZrnreigaisyorihyj(String pZrnreigaisyorihyj) {
        zrnreigaisyorihyj = pZrnreigaisyorihyj;
    }

    private String zrnyuubinbutukanpusakiyno;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNYUUBINBUTUKANPUSAKIYNO)
    public String getZrnyuubinbutukanpusakiyno() {
        return zrnyuubinbutukanpusakiyno;
    }

    @DataConvert("toMultiByte")
    public void setZrnyuubinbutukanpusakiyno(String pZrnyuubinbutukanpusakiyno) {
        zrnyuubinbutukanpusakiyno = pZrnyuubinbutukanpusakiyno;
    }

    private String zrnyuubinbutukanpusakiadr;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNYUUBINBUTUKANPUSAKIADR)
    public String getZrnyuubinbutukanpusakiadr() {
        return zrnyuubinbutukanpusakiadr;
    }

    @DataConvert("toMultiByte")
    public void setZrnyuubinbutukanpusakiadr(String pZrnyuubinbutukanpusakiadr) {
        zrnyuubinbutukanpusakiadr = pZrnyuubinbutukanpusakiadr;
    }

    private String zrnatesakiadr1;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNATESAKIADR1)
    public String getZrnatesakiadr1() {
        return zrnatesakiadr1;
    }

    @DataConvert("toMultiByte")
    public void setZrnatesakiadr1(String pZrnatesakiadr1) {
        zrnatesakiadr1 = pZrnatesakiadr1;
    }

    private String zrnatesakiadr2;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNATESAKIADR2)
    public String getZrnatesakiadr2() {
        return zrnatesakiadr2;
    }

    @DataConvert("toMultiByte")
    public void setZrnatesakiadr2(String pZrnatesakiadr2) {
        zrnatesakiadr2 = pZrnatesakiadr2;
    }

    private String zrnatesakiadr3;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNATESAKIADR3)
    public String getZrnatesakiadr3() {
        return zrnatesakiadr3;
    }

    @DataConvert("toMultiByte")
    public void setZrnatesakiadr3(String pZrnatesakiadr3) {
        zrnatesakiadr3 = pZrnatesakiadr3;
    }

    private String zrnatena1;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNATENA1)
    public String getZrnatena1() {
        return zrnatena1;
    }

    @DataConvert("toMultiByte")
    public void setZrnatena1(String pZrnatena1) {
        zrnatena1 = pZrnatena1;
    }

    private String zrnatena2;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNATENA2)
    public String getZrnatena2() {
        return zrnatena2;
    }

    @DataConvert("toMultiByte")
    public void setZrnatena2(String pZrnatena2) {
        zrnatena2 = pZrnatena2;
    }

    private String zrndai1syoukaisakifreearea1;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNDAI1SYOUKAISAKIFREEAREA1)
    public String getZrndai1syoukaisakifreearea1() {
        return zrndai1syoukaisakifreearea1;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1syoukaisakifreearea1(String pZrndai1syoukaisakifreearea1) {
        zrndai1syoukaisakifreearea1 = pZrndai1syoukaisakifreearea1;
    }

    private String zrndai1syoukaisakifreearea2;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNDAI1SYOUKAISAKIFREEAREA2)
    public String getZrndai1syoukaisakifreearea2() {
        return zrndai1syoukaisakifreearea2;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1syoukaisakifreearea2(String pZrndai1syoukaisakifreearea2) {
        zrndai1syoukaisakifreearea2 = pZrndai1syoukaisakifreearea2;
    }

    private String zrndai1syoukaisakifreearea3;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNDAI1SYOUKAISAKIFREEAREA3)
    public String getZrndai1syoukaisakifreearea3() {
        return zrndai1syoukaisakifreearea3;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1syoukaisakifreearea3(String pZrndai1syoukaisakifreearea3) {
        zrndai1syoukaisakifreearea3 = pZrndai1syoukaisakifreearea3;
    }

    private String zrndai1syoukaisakifreearea4;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNDAI1SYOUKAISAKIFREEAREA4)
    public String getZrndai1syoukaisakifreearea4() {
        return zrndai1syoukaisakifreearea4;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1syoukaisakifreearea4(String pZrndai1syoukaisakifreearea4) {
        zrndai1syoukaisakifreearea4 = pZrndai1syoukaisakifreearea4;
    }

    private String zrndai1syoukaisakifreearea5;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNDAI1SYOUKAISAKIFREEAREA5)
    public String getZrndai1syoukaisakifreearea5() {
        return zrndai1syoukaisakifreearea5;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1syoukaisakifreearea5(String pZrndai1syoukaisakifreearea5) {
        zrndai1syoukaisakifreearea5 = pZrndai1syoukaisakifreearea5;
    }

    private String zrnsakuseino;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNSAKUSEINO)
    public String getZrnsakuseino() {
        return zrnsakuseino;
    }

    public void setZrnsakuseino(String pZrnsakuseino) {
        zrnsakuseino = pZrnsakuseino;
    }

    private String zrnokyakusamanm;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNOKYAKUSAMANM)
    public String getZrnokyakusamanm() {
        return zrnokyakusamanm;
    }

    @DataConvert("toMultiByte")
    public void setZrnokyakusamanm(String pZrnokyakusamanm) {
        zrnokyakusamanm = pZrnokyakusamanm;
    }

    private String zrnhkymd;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNHKYMD)
    public String getZrnhkymd() {
        return zrnhkymd;
    }

    @DataConvert("toMultiByte")
    public void setZrnhkymd(String pZrnhkymd) {
        zrnhkymd = pZrnhkymd;
    }

    private String zrndskrhnnkakcdyoken;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNDSKRHNNKAKCDYOKEN)
    public String getZrndskrhnnkakcdyoken() {
        return zrndskrhnnkakcdyoken;
    }

    public void setZrndskrhnnkakcdyoken(String pZrndskrhnnkakcdyoken) {
        zrndskrhnnkakcdyoken = pZrndskrhnnkakcdyoken;
    }

    private String zrnkrpasswordyuukouymd;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNKRPASSWORDYUUKOUYMD)
    public String getZrnkrpasswordyuukouymd() {
        return zrnkrpasswordyuukouymd;
    }

    @DataConvert("toMultiByte")
    public void setZrnkrpasswordyuukouymd(String pZrnkrpasswordyuukouymd) {
        zrnkrpasswordyuukouymd = pZrnkrpasswordyuukouymd;
    }

    private String zrnfreearea1;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNFREEAREA1)
    public String getZrnfreearea1() {
        return zrnfreearea1;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea1(String pZrnfreearea1) {
        zrnfreearea1 = pZrnfreearea1;
    }

    private String zrnfreearea2;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNFREEAREA2)
    public String getZrnfreearea2() {
        return zrnfreearea2;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea2(String pZrnfreearea2) {
        zrnfreearea2 = pZrnfreearea2;
    }

    private String zrnfreearea3;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNFREEAREA3)
    public String getZrnfreearea3() {
        return zrnfreearea3;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea3(String pZrnfreearea3) {
        zrnfreearea3 = pZrnfreearea3;
    }

    private String zrnfreearea4;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNFREEAREA4)
    public String getZrnfreearea4() {
        return zrnfreearea4;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea4(String pZrnfreearea4) {
        zrnfreearea4 = pZrnfreearea4;
    }

    private String zrnfreearea5;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNFREEAREA5)
    public String getZrnfreearea5() {
        return zrnfreearea5;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea5(String pZrnfreearea5) {
        zrnfreearea5 = pZrnfreearea5;
    }

    private String zrntyuuijikou1;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNTYUUIJIKOU1)
    public String getZrntyuuijikou1() {
        return zrntyuuijikou1;
    }

    @DataConvert("toMultiByte")
    public void setZrntyuuijikou1(String pZrntyuuijikou1) {
        zrntyuuijikou1 = pZrntyuuijikou1;
    }

    private String zrntyuuijikou2;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNTYUUIJIKOU2)
    public String getZrntyuuijikou2() {
        return zrntyuuijikou2;
    }

    @DataConvert("toMultiByte")
    public void setZrntyuuijikou2(String pZrntyuuijikou2) {
        zrntyuuijikou2 = pZrntyuuijikou2;
    }

    private String zrntyuuijikou3;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNTYUUIJIKOU3)
    public String getZrntyuuijikou3() {
        return zrntyuuijikou3;
    }

    @DataConvert("toMultiByte")
    public void setZrntyuuijikou3(String pZrntyuuijikou3) {
        zrntyuuijikou3 = pZrntyuuijikou3;
    }

    private String zrntyuuijikou4;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNTYUUIJIKOU4)
    public String getZrntyuuijikou4() {
        return zrntyuuijikou4;
    }

    @DataConvert("toMultiByte")
    public void setZrntyuuijikou4(String pZrntyuuijikou4) {
        zrntyuuijikou4 = pZrntyuuijikou4;
    }

    private String zrntyuuijikou5;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNTYUUIJIKOU5)
    public String getZrntyuuijikou5() {
        return zrntyuuijikou5;
    }

    @DataConvert("toMultiByte")
    public void setZrntyuuijikou5(String pZrntyuuijikou5) {
        zrntyuuijikou5 = pZrntyuuijikou5;
    }

    private String zrntyuuijikou6;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNTYUUIJIKOU6)
    public String getZrntyuuijikou6() {
        return zrntyuuijikou6;
    }

    @DataConvert("toMultiByte")
    public void setZrntyuuijikou6(String pZrntyuuijikou6) {
        zrntyuuijikou6 = pZrntyuuijikou6;
    }

    private String zrntyuuijikou7;

    @Column(name=GenZT_DsKariPasswordTuutiRn.ZRNTYUUIJIKOU7)
    public String getZrntyuuijikou7() {
        return zrntyuuijikou7;
    }

    @DataConvert("toMultiByte")
    public void setZrntyuuijikou7(String pZrntyuuijikou7) {
        zrntyuuijikou7 = pZrntyuuijikou7;
    }
}
