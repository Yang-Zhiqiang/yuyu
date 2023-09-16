package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_YakansyoriLincSousinRn;
import yuyu.def.db.id.PKZT_YakansyoriLincSousinRn;
import yuyu.def.db.meta.GenQZT_YakansyoriLincSousinRn;
import yuyu.def.db.meta.QZT_YakansyoriLincSousinRn;

/**
 * 夜間処理ＬＩＮＣ送信ファイルテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_YakansyoriLincSousinRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_YakansyoriLincSousinRn}</td><td colspan="3">夜間処理ＬＩＮＣ送信ファイルテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrndatakbn zrndatakbn}</td><td>（連携用）データ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrecordsyubetukbn zrnrecordsyubetukbn}</td><td>（連携用）レコード種別区分</td><td align="center">{@link PKZT_YakansyoriLincSousinRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhenkoutype zrnhenkoutype}</td><td>（連携用）変更タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyorikekkacd zrnsyorikekkacd}</td><td>（連携用）処理結果コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyorikekkaerrjiyuu zrnsyorikekkaerrjiyuu}</td><td>（連携用）処理結果エラー事由</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyorikekkaerrno zrnsyorikekkaerrno}</td><td>（連携用）処理結果エラー項番</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnayoserecordsuu zrnnayoserecordsuu}</td><td>（連携用）名寄せレコード数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanyuusyano zrnkanyuusyano}</td><td>（連携用）加入者番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyoukaisiyouknnm zrnkyoukaisiyouknnm}</td><td>（連携用）協会使用カナ氏名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseiymd zrnhhknseiymd}</td><td>（連携用）被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyhhknsydouituhyouji zrnkyksyhhknsydouituhyouji}</td><td>（連携用）契約者被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsousinmotokaisyacd zrnsousinmotokaisyacd}</td><td>（連携用）送信元会社コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknadrkn zrnhhknadrkn}</td><td>（連携用）被保険者住所（カナ）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiginyuintkykntgkstr zrnsiginyuintkykntgkstr}</td><td>（連携用）災害入院特約日額（文字列）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsppinyuintkykntgkstr zrnsppinyuintkykntgkstr}</td><td>（連携用）疾病入院特約日額（文字列）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsijnbyutkykntgkstr zrnsijnbyutkykntgkstr}</td><td>（連携用）成人病特約日額（文字列）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotatokuyakuntgkstr zrnsonotatokuyakuntgkstr}</td><td>（連携用）その他特約日額（文字列）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkmousideymd zrntrkmousideymd}</td><td>（連携用）登録申出年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnlincsyoriymd zrnlincsyoriymd}</td><td>（連携用）ＬＩＮＣ処理年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyuyusiyouknnm zrnyuyusiyouknnm}</td><td>（連携用）住友使用カナ氏名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykkanrino zrnkykkanrino}</td><td>（連携用）契約管理番号</td><td align="center">{@link PKZT_YakansyoriLincSousinRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhozenymd zrnhozenymd}</td><td>（連携用）保全年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykknnm zrnkykknnm}</td><td>（連携用）契約者カナ氏名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhutuusbsstr zrnhutuusbsstr}</td><td>（連携用）普通死亡保険金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsgsbstr zrnsgsbstr}</td><td>（連携用）災害死亡保険金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkakusyasiyouran zrnkakusyasiyouran}</td><td>（連携用）各社使用欄</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmousideflg zrnmousideflg}</td><td>（連携用）申出フラグ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmousideflgsetymd zrnmousideflgsetymd}</td><td>（連携用）申出フラグ設定年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmousideflgkaijyoymd zrnmousideflgkaijyoymd}</td><td>（連携用）申出フラグ解除年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjgyhknflg zrnjgyhknflg}</td><td>（連携用）事業保険フラグ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnknflg zrntnknflg}</td><td>（連携用）転換フラグ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaseikbn zrnkyksyaseikbn}</td><td>（連携用）契約者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaseiymd zrnkyksyaseiymd}</td><td>（連携用）契約者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykadrkn zrnkykadrkn}</td><td>（連携用）契約者住所（カナ）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv17 zrnyobiv17}</td><td>（連携用）予備項目Ｖ１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknjhhknmei30 zrnknjhhknmei30}</td><td>（連携用）漢字被保険者名（３０桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkyknm30 zrnkjkyknm30}</td><td>（連携用）漢字契約者名（３０桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrn15sai1000manflg zrn15sai1000manflg}</td><td>（連携用）１５歳未満１０００万超フラグ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjhngflg zrnkjhngflg}</td><td>（連携用）漢字範囲外フラグ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykytymd zrnkykytymd}</td><td>（連携用）契約予定年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhozenytymd zrnhozenytymd}</td><td>（連携用）保全予定年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrn15mimantkhukaymd zrn15mimantkhukaymd}</td><td>（連携用）１５歳未満特約中途付加年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrn15mimantkhukayoteiymd zrn15mimantkhukayoteiymd}</td><td>（連携用）１５歳未満特約中途付加予定日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv46 zrnyobiv46}</td><td>（連携用）予備項目Ｖ４６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_YakansyoriLincSousinRn
 * @see     PKZT_YakansyoriLincSousinRn
 * @see     QZT_YakansyoriLincSousinRn
 * @see     GenQZT_YakansyoriLincSousinRn
 */
@MappedSuperclass
@Table(name=GenZT_YakansyoriLincSousinRn.TABLE_NAME)
@IdClass(value=PKZT_YakansyoriLincSousinRn.class)
public abstract class GenZT_YakansyoriLincSousinRn extends AbstractExDBEntityForZDB<ZT_YakansyoriLincSousinRn, PKZT_YakansyoriLincSousinRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_YakansyoriLincSousinRn";
    public static final String ZRNDATAKBN               = "zrndatakbn";
    public static final String ZRNRECORDSYUBETUKBN      = "zrnrecordsyubetukbn";
    public static final String ZRNHENKOUTYPE            = "zrnhenkoutype";
    public static final String ZRNSYORIKEKKACD          = "zrnsyorikekkacd";
    public static final String ZRNSYORIKEKKAERRJIYUU    = "zrnsyorikekkaerrjiyuu";
    public static final String ZRNSYORIKEKKAERRNO       = "zrnsyorikekkaerrno";
    public static final String ZRNNAYOSERECORDSUU       = "zrnnayoserecordsuu";
    public static final String ZRNKANYUUSYANO           = "zrnkanyuusyano";
    public static final String ZRNKYOUKAISIYOUKNNM      = "zrnkyoukaisiyouknnm";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNHHKNSEIYMD            = "zrnhhknseiymd";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNKYKSYHHKNSYDOUITUHYOUJI = "zrnkyksyhhknsydouituhyouji";
    public static final String ZRNSOUSINMOTOKAISYACD    = "zrnsousinmotokaisyacd";
    public static final String ZRNHHKNADRKN             = "zrnhhknadrkn";
    public static final String ZRNSIGINYUINTKYKNTGKSTR  = "zrnsiginyuintkykntgkstr";
    public static final String ZRNSPPINYUINTKYKNTGKSTR  = "zrnsppinyuintkykntgkstr";
    public static final String ZRNSIJNBYUTKYKNTGKSTR    = "zrnsijnbyutkykntgkstr";
    public static final String ZRNSONOTATOKUYAKUNTGKSTR = "zrnsonotatokuyakuntgkstr";
    public static final String ZRNTRKMOUSIDEYMD         = "zrntrkmousideymd";
    public static final String ZRNLINCSYORIYMD          = "zrnlincsyoriymd";
    public static final String ZRNYUYUSIYOUKNNM         = "zrnyuyusiyouknnm";
    public static final String ZRNKYKKANRINO            = "zrnkykkanrino";
    public static final String ZRNHOZENYMD              = "zrnhozenymd";
    public static final String ZRNKYKKNNM               = "zrnkykknnm";
    public static final String ZRNHUTUUSBSSTR           = "zrnhutuusbsstr";
    public static final String ZRNSGSBSTR               = "zrnsgsbstr";
    public static final String ZRNKAKUSYASIYOURAN       = "zrnkakusyasiyouran";
    public static final String ZRNMOUSIDEFLG            = "zrnmousideflg";
    public static final String ZRNMOUSIDEFLGSETYMD      = "zrnmousideflgsetymd";
    public static final String ZRNMOUSIDEFLGKAIJYOYMD   = "zrnmousideflgkaijyoymd";
    public static final String ZRNJGYHKNFLG             = "zrnjgyhknflg";
    public static final String ZRNTNKNFLG               = "zrntnknflg";
    public static final String ZRNKYKSYASEIKBN          = "zrnkyksyaseikbn";
    public static final String ZRNKYKSYASEIYMD          = "zrnkyksyaseiymd";
    public static final String ZRNKYKADRKN              = "zrnkykadrkn";
    public static final String ZRNYOBIV17               = "zrnyobiv17";
    public static final String ZRNKNJHHKNMEI30          = "zrnknjhhknmei30";
    public static final String ZRNKJKYKNM30             = "zrnkjkyknm30";
    public static final String ZRN15SAI1000MANFLG       = "zrn15sai1000manflg";
    public static final String ZRNKJHNGFLG              = "zrnkjhngflg";
    public static final String ZRNKYKYTYMD              = "zrnkykytymd";
    public static final String ZRNHOZENYTYMD            = "zrnhozenytymd";
    public static final String ZRN15MIMANTKHUKAYMD      = "zrn15mimantkhukaymd";
    public static final String ZRN15MIMANTKHUKAYOTEIYMD = "zrn15mimantkhukayoteiymd";
    public static final String ZRNYOBIV46               = "zrnyobiv46";

    private final PKZT_YakansyoriLincSousinRn primaryKey;

    public GenZT_YakansyoriLincSousinRn() {
        primaryKey = new PKZT_YakansyoriLincSousinRn();
    }

    public GenZT_YakansyoriLincSousinRn(String pZrnrecordsyubetukbn, String pZrnkykkanrino) {
        primaryKey = new PKZT_YakansyoriLincSousinRn(pZrnrecordsyubetukbn, pZrnkykkanrino);
    }

    @Transient
    @Override
    public PKZT_YakansyoriLincSousinRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_YakansyoriLincSousinRn> getMetaClass() {
        return QZT_YakansyoriLincSousinRn.class;
    }

    private String zrndatakbn;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNDATAKBN)
    public String getZrndatakbn() {
        return zrndatakbn;
    }

    public void setZrndatakbn(String pZrndatakbn) {
        zrndatakbn = pZrndatakbn;
    }

    @Id
    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNRECORDSYUBETUKBN)
    public String getZrnrecordsyubetukbn() {
        return getPrimaryKey().getZrnrecordsyubetukbn();
    }

    public void setZrnrecordsyubetukbn(String pZrnrecordsyubetukbn) {
        getPrimaryKey().setZrnrecordsyubetukbn(pZrnrecordsyubetukbn);
    }

    private String zrnhenkoutype;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNHENKOUTYPE)
    public String getZrnhenkoutype() {
        return zrnhenkoutype;
    }

    public void setZrnhenkoutype(String pZrnhenkoutype) {
        zrnhenkoutype = pZrnhenkoutype;
    }

    private String zrnsyorikekkacd;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNSYORIKEKKACD)
    public String getZrnsyorikekkacd() {
        return zrnsyorikekkacd;
    }

    public void setZrnsyorikekkacd(String pZrnsyorikekkacd) {
        zrnsyorikekkacd = pZrnsyorikekkacd;
    }

    private String zrnsyorikekkaerrjiyuu;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNSYORIKEKKAERRJIYUU)
    public String getZrnsyorikekkaerrjiyuu() {
        return zrnsyorikekkaerrjiyuu;
    }

    public void setZrnsyorikekkaerrjiyuu(String pZrnsyorikekkaerrjiyuu) {
        zrnsyorikekkaerrjiyuu = pZrnsyorikekkaerrjiyuu;
    }

    private String zrnsyorikekkaerrno;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNSYORIKEKKAERRNO)
    public String getZrnsyorikekkaerrno() {
        return zrnsyorikekkaerrno;
    }

    public void setZrnsyorikekkaerrno(String pZrnsyorikekkaerrno) {
        zrnsyorikekkaerrno = pZrnsyorikekkaerrno;
    }

    private String zrnnayoserecordsuu;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNNAYOSERECORDSUU)
    public String getZrnnayoserecordsuu() {
        return zrnnayoserecordsuu;
    }

    public void setZrnnayoserecordsuu(String pZrnnayoserecordsuu) {
        zrnnayoserecordsuu = pZrnnayoserecordsuu;
    }

    private String zrnkanyuusyano;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNKANYUUSYANO)
    public String getZrnkanyuusyano() {
        return zrnkanyuusyano;
    }

    public void setZrnkanyuusyano(String pZrnkanyuusyano) {
        zrnkanyuusyano = pZrnkanyuusyano;
    }

    private String zrnkyoukaisiyouknnm;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNKYOUKAISIYOUKNNM)
    public String getZrnkyoukaisiyouknnm() {
        return zrnkyoukaisiyouknnm;
    }

    public void setZrnkyoukaisiyouknnm(String pZrnkyoukaisiyouknnm) {
        zrnkyoukaisiyouknnm = pZrnkyoukaisiyouknnm;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnhhknseiymd;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNHHKNSEIYMD)
    public String getZrnhhknseiymd() {
        return zrnhhknseiymd;
    }

    public void setZrnhhknseiymd(String pZrnhhknseiymd) {
        zrnhhknseiymd = pZrnhhknseiymd;
    }

    private String zrnkykymd;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnkyksyhhknsydouituhyouji;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNKYKSYHHKNSYDOUITUHYOUJI)
    public String getZrnkyksyhhknsydouituhyouji() {
        return zrnkyksyhhknsydouituhyouji;
    }

    public void setZrnkyksyhhknsydouituhyouji(String pZrnkyksyhhknsydouituhyouji) {
        zrnkyksyhhknsydouituhyouji = pZrnkyksyhhknsydouituhyouji;
    }

    private String zrnsousinmotokaisyacd;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNSOUSINMOTOKAISYACD)
    public String getZrnsousinmotokaisyacd() {
        return zrnsousinmotokaisyacd;
    }

    public void setZrnsousinmotokaisyacd(String pZrnsousinmotokaisyacd) {
        zrnsousinmotokaisyacd = pZrnsousinmotokaisyacd;
    }

    private String zrnhhknadrkn;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNHHKNADRKN)
    public String getZrnhhknadrkn() {
        return zrnhhknadrkn;
    }

    public void setZrnhhknadrkn(String pZrnhhknadrkn) {
        zrnhhknadrkn = pZrnhhknadrkn;
    }

    private String zrnsiginyuintkykntgkstr;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNSIGINYUINTKYKNTGKSTR)
    public String getZrnsiginyuintkykntgkstr() {
        return zrnsiginyuintkykntgkstr;
    }

    public void setZrnsiginyuintkykntgkstr(String pZrnsiginyuintkykntgkstr) {
        zrnsiginyuintkykntgkstr = pZrnsiginyuintkykntgkstr;
    }

    private String zrnsppinyuintkykntgkstr;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNSPPINYUINTKYKNTGKSTR)
    public String getZrnsppinyuintkykntgkstr() {
        return zrnsppinyuintkykntgkstr;
    }

    public void setZrnsppinyuintkykntgkstr(String pZrnsppinyuintkykntgkstr) {
        zrnsppinyuintkykntgkstr = pZrnsppinyuintkykntgkstr;
    }

    private String zrnsijnbyutkykntgkstr;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNSIJNBYUTKYKNTGKSTR)
    public String getZrnsijnbyutkykntgkstr() {
        return zrnsijnbyutkykntgkstr;
    }

    public void setZrnsijnbyutkykntgkstr(String pZrnsijnbyutkykntgkstr) {
        zrnsijnbyutkykntgkstr = pZrnsijnbyutkykntgkstr;
    }

    private String zrnsonotatokuyakuntgkstr;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNSONOTATOKUYAKUNTGKSTR)
    public String getZrnsonotatokuyakuntgkstr() {
        return zrnsonotatokuyakuntgkstr;
    }

    public void setZrnsonotatokuyakuntgkstr(String pZrnsonotatokuyakuntgkstr) {
        zrnsonotatokuyakuntgkstr = pZrnsonotatokuyakuntgkstr;
    }

    private String zrntrkmousideymd;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNTRKMOUSIDEYMD)
    public String getZrntrkmousideymd() {
        return zrntrkmousideymd;
    }

    public void setZrntrkmousideymd(String pZrntrkmousideymd) {
        zrntrkmousideymd = pZrntrkmousideymd;
    }

    private String zrnlincsyoriymd;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNLINCSYORIYMD)
    public String getZrnlincsyoriymd() {
        return zrnlincsyoriymd;
    }

    public void setZrnlincsyoriymd(String pZrnlincsyoriymd) {
        zrnlincsyoriymd = pZrnlincsyoriymd;
    }

    private String zrnyuyusiyouknnm;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNYUYUSIYOUKNNM)
    public String getZrnyuyusiyouknnm() {
        return zrnyuyusiyouknnm;
    }

    public void setZrnyuyusiyouknnm(String pZrnyuyusiyouknnm) {
        zrnyuyusiyouknnm = pZrnyuyusiyouknnm;
    }

    @Id
    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNKYKKANRINO)
    public String getZrnkykkanrino() {
        return getPrimaryKey().getZrnkykkanrino();
    }

    public void setZrnkykkanrino(String pZrnkykkanrino) {
        getPrimaryKey().setZrnkykkanrino(pZrnkykkanrino);
    }

    private String zrnhozenymd;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNHOZENYMD)
    public String getZrnhozenymd() {
        return zrnhozenymd;
    }

    public void setZrnhozenymd(String pZrnhozenymd) {
        zrnhozenymd = pZrnhozenymd;
    }

    private String zrnkykknnm;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNKYKKNNM)
    public String getZrnkykknnm() {
        return zrnkykknnm;
    }

    public void setZrnkykknnm(String pZrnkykknnm) {
        zrnkykknnm = pZrnkykknnm;
    }

    private String zrnhutuusbsstr;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNHUTUUSBSSTR)
    public String getZrnhutuusbsstr() {
        return zrnhutuusbsstr;
    }

    public void setZrnhutuusbsstr(String pZrnhutuusbsstr) {
        zrnhutuusbsstr = pZrnhutuusbsstr;
    }

    private String zrnsgsbstr;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNSGSBSTR)
    public String getZrnsgsbstr() {
        return zrnsgsbstr;
    }

    public void setZrnsgsbstr(String pZrnsgsbstr) {
        zrnsgsbstr = pZrnsgsbstr;
    }

    private String zrnkakusyasiyouran;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNKAKUSYASIYOURAN)
    public String getZrnkakusyasiyouran() {
        return zrnkakusyasiyouran;
    }

    public void setZrnkakusyasiyouran(String pZrnkakusyasiyouran) {
        zrnkakusyasiyouran = pZrnkakusyasiyouran;
    }

    private String zrnmousideflg;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNMOUSIDEFLG)
    public String getZrnmousideflg() {
        return zrnmousideflg;
    }

    public void setZrnmousideflg(String pZrnmousideflg) {
        zrnmousideflg = pZrnmousideflg;
    }

    private String zrnmousideflgsetymd;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNMOUSIDEFLGSETYMD)
    public String getZrnmousideflgsetymd() {
        return zrnmousideflgsetymd;
    }

    public void setZrnmousideflgsetymd(String pZrnmousideflgsetymd) {
        zrnmousideflgsetymd = pZrnmousideflgsetymd;
    }

    private String zrnmousideflgkaijyoymd;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNMOUSIDEFLGKAIJYOYMD)
    public String getZrnmousideflgkaijyoymd() {
        return zrnmousideflgkaijyoymd;
    }

    public void setZrnmousideflgkaijyoymd(String pZrnmousideflgkaijyoymd) {
        zrnmousideflgkaijyoymd = pZrnmousideflgkaijyoymd;
    }

    private String zrnjgyhknflg;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNJGYHKNFLG)
    public String getZrnjgyhknflg() {
        return zrnjgyhknflg;
    }

    public void setZrnjgyhknflg(String pZrnjgyhknflg) {
        zrnjgyhknflg = pZrnjgyhknflg;
    }

    private String zrntnknflg;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNTNKNFLG)
    public String getZrntnknflg() {
        return zrntnknflg;
    }

    public void setZrntnknflg(String pZrntnknflg) {
        zrntnknflg = pZrntnknflg;
    }

    private String zrnkyksyaseikbn;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNKYKSYASEIKBN)
    public String getZrnkyksyaseikbn() {
        return zrnkyksyaseikbn;
    }

    public void setZrnkyksyaseikbn(String pZrnkyksyaseikbn) {
        zrnkyksyaseikbn = pZrnkyksyaseikbn;
    }

    private String zrnkyksyaseiymd;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNKYKSYASEIYMD)
    public String getZrnkyksyaseiymd() {
        return zrnkyksyaseiymd;
    }

    public void setZrnkyksyaseiymd(String pZrnkyksyaseiymd) {
        zrnkyksyaseiymd = pZrnkyksyaseiymd;
    }

    private String zrnkykadrkn;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNKYKADRKN)
    public String getZrnkykadrkn() {
        return zrnkykadrkn;
    }

    public void setZrnkykadrkn(String pZrnkykadrkn) {
        zrnkykadrkn = pZrnkykadrkn;
    }

    private String zrnyobiv17;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNYOBIV17)
    public String getZrnyobiv17() {
        return zrnyobiv17;
    }

    public void setZrnyobiv17(String pZrnyobiv17) {
        zrnyobiv17 = pZrnyobiv17;
    }

    private String zrnknjhhknmei30;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNKNJHHKNMEI30)
    public String getZrnknjhhknmei30() {
        return zrnknjhhknmei30;
    }

    @DataConvert("toMultiByte")
    public void setZrnknjhhknmei30(String pZrnknjhhknmei30) {
        zrnknjhhknmei30 = pZrnknjhhknmei30;
    }

    private String zrnkjkyknm30;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNKJKYKNM30)
    public String getZrnkjkyknm30() {
        return zrnkjkyknm30;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkyknm30(String pZrnkjkyknm30) {
        zrnkjkyknm30 = pZrnkjkyknm30;
    }

    private String zrn15sai1000manflg;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRN15SAI1000MANFLG)
    public String getZrn15sai1000manflg() {
        return zrn15sai1000manflg;
    }

    public void setZrn15sai1000manflg(String pZrn15sai1000manflg) {
        zrn15sai1000manflg = pZrn15sai1000manflg;
    }

    private String zrnkjhngflg;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNKJHNGFLG)
    public String getZrnkjhngflg() {
        return zrnkjhngflg;
    }

    public void setZrnkjhngflg(String pZrnkjhngflg) {
        zrnkjhngflg = pZrnkjhngflg;
    }

    private String zrnkykytymd;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNKYKYTYMD)
    public String getZrnkykytymd() {
        return zrnkykytymd;
    }

    public void setZrnkykytymd(String pZrnkykytymd) {
        zrnkykytymd = pZrnkykytymd;
    }

    private String zrnhozenytymd;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNHOZENYTYMD)
    public String getZrnhozenytymd() {
        return zrnhozenytymd;
    }

    public void setZrnhozenytymd(String pZrnhozenytymd) {
        zrnhozenytymd = pZrnhozenytymd;
    }

    private String zrn15mimantkhukaymd;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRN15MIMANTKHUKAYMD)
    public String getZrn15mimantkhukaymd() {
        return zrn15mimantkhukaymd;
    }

    public void setZrn15mimantkhukaymd(String pZrn15mimantkhukaymd) {
        zrn15mimantkhukaymd = pZrn15mimantkhukaymd;
    }

    private String zrn15mimantkhukayoteiymd;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRN15MIMANTKHUKAYOTEIYMD)
    public String getZrn15mimantkhukayoteiymd() {
        return zrn15mimantkhukayoteiymd;
    }

    public void setZrn15mimantkhukayoteiymd(String pZrn15mimantkhukayoteiymd) {
        zrn15mimantkhukayoteiymd = pZrn15mimantkhukayoteiymd;
    }

    private String zrnyobiv46;

    @Column(name=GenZT_YakansyoriLincSousinRn.ZRNYOBIV46)
    public String getZrnyobiv46() {
        return zrnyobiv46;
    }

    public void setZrnyobiv46(String pZrnyobiv46) {
        zrnyobiv46 = pZrnyobiv46;
    }
}