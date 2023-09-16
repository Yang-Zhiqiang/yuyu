package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_YakansyoriLincSousinTy;
import yuyu.def.db.id.PKZT_YakansyoriLincSousinTy;
import yuyu.def.db.meta.GenQZT_YakansyoriLincSousinTy;
import yuyu.def.db.meta.QZT_YakansyoriLincSousinTy;

/**
 * 夜間処理ＬＩＮＣ送信ファイルテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_YakansyoriLincSousinTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_YakansyoriLincSousinTy}</td><td colspan="3">夜間処理ＬＩＮＣ送信ファイルテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtydatakbn ztydatakbn}</td><td>（中継用）データ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrecordsyubetukbn ztyrecordsyubetukbn}</td><td>（中継用）レコード種別区分</td><td align="center">{@link PKZT_YakansyoriLincSousinTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhenkoutype ztyhenkoutype}</td><td>（中継用）変更タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyorikekkacd ztysyorikekkacd}</td><td>（中継用）処理結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyorikekkaerrjiyuu ztysyorikekkaerrjiyuu}</td><td>（中継用）処理結果エラー事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyorikekkaerrno ztysyorikekkaerrno}</td><td>（中継用）処理結果エラー項番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynayoserecordsuu ztynayoserecordsuu}</td><td>（中継用）名寄せレコード数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanyuusyano ztykanyuusyano}</td><td>（中継用）加入者番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyoukaisiyouknnm ztykyoukaisiyouknnm}</td><td>（中継用）協会使用カナ氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseiymd ztyhhknseiymd}</td><td>（中継用）被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyhhknsydouituhyouji ztykyksyhhknsydouituhyouji}</td><td>（中継用）契約者被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysousinmotokaisyacd ztysousinmotokaisyacd}</td><td>（中継用）送信元会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknadrkn ztyhhknadrkn}</td><td>（中継用）被保険者住所（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiginyuintkykntgkstr ztysiginyuintkykntgkstr}</td><td>（中継用）災害入院特約日額（文字列）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysppinyuintkykntgkstr ztysppinyuintkykntgkstr}</td><td>（中継用）疾病入院特約日額（文字列）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysijnbyutkykntgkstr ztysijnbyutkykntgkstr}</td><td>（中継用）成人病特約日額（文字列）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotatokuyakuntgkstr ztysonotatokuyakuntgkstr}</td><td>（中継用）その他特約日額（文字列）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkmousideymd ztytrkmousideymd}</td><td>（中継用）登録申出年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtylincsyoriymd ztylincsyoriymd}</td><td>（中継用）ＬＩＮＣ処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyuyusiyouknnm ztyyuyusiyouknnm}</td><td>（中継用）住友使用カナ氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykkanrino ztykykkanrino}</td><td>（中継用）契約管理番号</td><td align="center">{@link PKZT_YakansyoriLincSousinTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhozenymd ztyhozenymd}</td><td>（中継用）保全年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykknnm ztykykknnm}</td><td>（中継用）契約者カナ氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhutuusbsstr ztyhutuusbsstr}</td><td>（中継用）普通死亡保険金額（文字列）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysgsbstr ztysgsbstr}</td><td>（中継用）災害死亡保険金額（文字列）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykakusyasiyouran ztykakusyasiyouran}</td><td>（中継用）各社使用欄</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymousideflg ztymousideflg}</td><td>（中継用）申出フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymousideflgsetymd ztymousideflgsetymd}</td><td>（中継用）申出フラグ設定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymousideflgkaijyoymd ztymousideflgkaijyoymd}</td><td>（中継用）申出フラグ解除年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjgyhknflg ztyjgyhknflg}</td><td>（中継用）事業保険フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnknflg ztytnknflg}</td><td>（中継用）転換フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaseikbn ztykyksyaseikbn}</td><td>（中継用）契約者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaseiymd ztykyksyaseiymd}</td><td>（中継用）契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykadrkn ztykykadrkn}</td><td>（中継用）契約者住所（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv17 ztyyobiv17}</td><td>（中継用）予備項目Ｖ１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknjhhknmei30 ztyknjhhknmei30}</td><td>（中継用）漢字被保険者名（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkyknm30 ztykjkyknm30}</td><td>（中継用）漢字契約者名（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZty15sai1000manflg zty15sai1000manflg}</td><td>（中継用）１５歳未満１０００万超フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjhngflg ztykjhngflg}</td><td>（中継用）漢字範囲外フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykytymd ztykykytymd}</td><td>（中継用）契約予定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhozenytymd ztyhozenytymd}</td><td>（中継用）保全予定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZty15mimantkhukaymd zty15mimantkhukaymd}</td><td>（中継用）１５歳未満特約中途付加年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZty15mimantkhukayoteiymd zty15mimantkhukayoteiymd}</td><td>（中継用）１５歳未満特約中途付加予定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv46 ztyyobiv46}</td><td>（中継用）予備項目Ｖ４６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_YakansyoriLincSousinTy
 * @see     PKZT_YakansyoriLincSousinTy
 * @see     QZT_YakansyoriLincSousinTy
 * @see     GenQZT_YakansyoriLincSousinTy
 */
@MappedSuperclass
@Table(name=GenZT_YakansyoriLincSousinTy.TABLE_NAME)
@IdClass(value=PKZT_YakansyoriLincSousinTy.class)
public abstract class GenZT_YakansyoriLincSousinTy extends AbstractExDBEntity<ZT_YakansyoriLincSousinTy, PKZT_YakansyoriLincSousinTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_YakansyoriLincSousinTy";
    public static final String ZTYDATAKBN               = "ztydatakbn";
    public static final String ZTYRECORDSYUBETUKBN      = "ztyrecordsyubetukbn";
    public static final String ZTYHENKOUTYPE            = "ztyhenkoutype";
    public static final String ZTYSYORIKEKKACD          = "ztysyorikekkacd";
    public static final String ZTYSYORIKEKKAERRJIYUU    = "ztysyorikekkaerrjiyuu";
    public static final String ZTYSYORIKEKKAERRNO       = "ztysyorikekkaerrno";
    public static final String ZTYNAYOSERECORDSUU       = "ztynayoserecordsuu";
    public static final String ZTYKANYUUSYANO           = "ztykanyuusyano";
    public static final String ZTYKYOUKAISIYOUKNNM      = "ztykyoukaisiyouknnm";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYHHKNSEIYMD            = "ztyhhknseiymd";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYKYKSYHHKNSYDOUITUHYOUJI = "ztykyksyhhknsydouituhyouji";
    public static final String ZTYSOUSINMOTOKAISYACD    = "ztysousinmotokaisyacd";
    public static final String ZTYHHKNADRKN             = "ztyhhknadrkn";
    public static final String ZTYSIGINYUINTKYKNTGKSTR  = "ztysiginyuintkykntgkstr";
    public static final String ZTYSPPINYUINTKYKNTGKSTR  = "ztysppinyuintkykntgkstr";
    public static final String ZTYSIJNBYUTKYKNTGKSTR    = "ztysijnbyutkykntgkstr";
    public static final String ZTYSONOTATOKUYAKUNTGKSTR = "ztysonotatokuyakuntgkstr";
    public static final String ZTYTRKMOUSIDEYMD         = "ztytrkmousideymd";
    public static final String ZTYLINCSYORIYMD          = "ztylincsyoriymd";
    public static final String ZTYYUYUSIYOUKNNM         = "ztyyuyusiyouknnm";
    public static final String ZTYKYKKANRINO            = "ztykykkanrino";
    public static final String ZTYHOZENYMD              = "ztyhozenymd";
    public static final String ZTYKYKKNNM               = "ztykykknnm";
    public static final String ZTYHUTUUSBSSTR           = "ztyhutuusbsstr";
    public static final String ZTYSGSBSTR               = "ztysgsbstr";
    public static final String ZTYKAKUSYASIYOURAN       = "ztykakusyasiyouran";
    public static final String ZTYMOUSIDEFLG            = "ztymousideflg";
    public static final String ZTYMOUSIDEFLGSETYMD      = "ztymousideflgsetymd";
    public static final String ZTYMOUSIDEFLGKAIJYOYMD   = "ztymousideflgkaijyoymd";
    public static final String ZTYJGYHKNFLG             = "ztyjgyhknflg";
    public static final String ZTYTNKNFLG               = "ztytnknflg";
    public static final String ZTYKYKSYASEIKBN          = "ztykyksyaseikbn";
    public static final String ZTYKYKSYASEIYMD          = "ztykyksyaseiymd";
    public static final String ZTYKYKADRKN              = "ztykykadrkn";
    public static final String ZTYYOBIV17               = "ztyyobiv17";
    public static final String ZTYKNJHHKNMEI30          = "ztyknjhhknmei30";
    public static final String ZTYKJKYKNM30             = "ztykjkyknm30";
    public static final String ZTY15SAI1000MANFLG       = "zty15sai1000manflg";
    public static final String ZTYKJHNGFLG              = "ztykjhngflg";
    public static final String ZTYKYKYTYMD              = "ztykykytymd";
    public static final String ZTYHOZENYTYMD            = "ztyhozenytymd";
    public static final String ZTY15MIMANTKHUKAYMD      = "zty15mimantkhukaymd";
    public static final String ZTY15MIMANTKHUKAYOTEIYMD = "zty15mimantkhukayoteiymd";
    public static final String ZTYYOBIV46               = "ztyyobiv46";

    private final PKZT_YakansyoriLincSousinTy primaryKey;

    public GenZT_YakansyoriLincSousinTy() {
        primaryKey = new PKZT_YakansyoriLincSousinTy();
    }

    public GenZT_YakansyoriLincSousinTy(String pZtyrecordsyubetukbn, String pZtykykkanrino) {
        primaryKey = new PKZT_YakansyoriLincSousinTy(pZtyrecordsyubetukbn, pZtykykkanrino);
    }

    @Transient
    @Override
    public PKZT_YakansyoriLincSousinTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_YakansyoriLincSousinTy> getMetaClass() {
        return QZT_YakansyoriLincSousinTy.class;
    }

    private String ztydatakbn;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYDATAKBN)
    public String getZtydatakbn() {
        return ztydatakbn;
    }

    public void setZtydatakbn(String pZtydatakbn) {
        ztydatakbn = pZtydatakbn;
    }

    @Id
    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYRECORDSYUBETUKBN)
    public String getZtyrecordsyubetukbn() {
        return getPrimaryKey().getZtyrecordsyubetukbn();
    }

    public void setZtyrecordsyubetukbn(String pZtyrecordsyubetukbn) {
        getPrimaryKey().setZtyrecordsyubetukbn(pZtyrecordsyubetukbn);
    }

    private String ztyhenkoutype;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYHENKOUTYPE)
    public String getZtyhenkoutype() {
        return ztyhenkoutype;
    }

    public void setZtyhenkoutype(String pZtyhenkoutype) {
        ztyhenkoutype = pZtyhenkoutype;
    }

    private String ztysyorikekkacd;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYSYORIKEKKACD)
    public String getZtysyorikekkacd() {
        return ztysyorikekkacd;
    }

    public void setZtysyorikekkacd(String pZtysyorikekkacd) {
        ztysyorikekkacd = pZtysyorikekkacd;
    }

    private String ztysyorikekkaerrjiyuu;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYSYORIKEKKAERRJIYUU)
    public String getZtysyorikekkaerrjiyuu() {
        return ztysyorikekkaerrjiyuu;
    }

    public void setZtysyorikekkaerrjiyuu(String pZtysyorikekkaerrjiyuu) {
        ztysyorikekkaerrjiyuu = pZtysyorikekkaerrjiyuu;
    }

    private String ztysyorikekkaerrno;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYSYORIKEKKAERRNO)
    public String getZtysyorikekkaerrno() {
        return ztysyorikekkaerrno;
    }

    public void setZtysyorikekkaerrno(String pZtysyorikekkaerrno) {
        ztysyorikekkaerrno = pZtysyorikekkaerrno;
    }

    private String ztynayoserecordsuu;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYNAYOSERECORDSUU)
    public String getZtynayoserecordsuu() {
        return ztynayoserecordsuu;
    }

    public void setZtynayoserecordsuu(String pZtynayoserecordsuu) {
        ztynayoserecordsuu = pZtynayoserecordsuu;
    }

    private String ztykanyuusyano;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYKANYUUSYANO)
    public String getZtykanyuusyano() {
        return ztykanyuusyano;
    }

    public void setZtykanyuusyano(String pZtykanyuusyano) {
        ztykanyuusyano = pZtykanyuusyano;
    }

    private String ztykyoukaisiyouknnm;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYKYOUKAISIYOUKNNM)
    public String getZtykyoukaisiyouknnm() {
        return ztykyoukaisiyouknnm;
    }

    public void setZtykyoukaisiyouknnm(String pZtykyoukaisiyouknnm) {
        ztykyoukaisiyouknnm = pZtykyoukaisiyouknnm;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyhhknseiymd;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYHHKNSEIYMD)
    public String getZtyhhknseiymd() {
        return ztyhhknseiymd;
    }

    public void setZtyhhknseiymd(String pZtyhhknseiymd) {
        ztyhhknseiymd = pZtyhhknseiymd;
    }

    private String ztykykymd;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztykyksyhhknsydouituhyouji;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYKYKSYHHKNSYDOUITUHYOUJI)
    public String getZtykyksyhhknsydouituhyouji() {
        return ztykyksyhhknsydouituhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykyksyhhknsydouituhyouji(String pZtykyksyhhknsydouituhyouji) {
        ztykyksyhhknsydouituhyouji = pZtykyksyhhknsydouituhyouji;
    }

    private String ztysousinmotokaisyacd;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYSOUSINMOTOKAISYACD)
    public String getZtysousinmotokaisyacd() {
        return ztysousinmotokaisyacd;
    }

    public void setZtysousinmotokaisyacd(String pZtysousinmotokaisyacd) {
        ztysousinmotokaisyacd = pZtysousinmotokaisyacd;
    }

    private String ztyhhknadrkn;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYHHKNADRKN)
    public String getZtyhhknadrkn() {
        return ztyhhknadrkn;
    }

    public void setZtyhhknadrkn(String pZtyhhknadrkn) {
        ztyhhknadrkn = pZtyhhknadrkn;
    }

    private String ztysiginyuintkykntgkstr;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYSIGINYUINTKYKNTGKSTR)
    public String getZtysiginyuintkykntgkstr() {
        return ztysiginyuintkykntgkstr;
    }

    public void setZtysiginyuintkykntgkstr(String pZtysiginyuintkykntgkstr) {
        ztysiginyuintkykntgkstr = pZtysiginyuintkykntgkstr;
    }

    private String ztysppinyuintkykntgkstr;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYSPPINYUINTKYKNTGKSTR)
    public String getZtysppinyuintkykntgkstr() {
        return ztysppinyuintkykntgkstr;
    }

    public void setZtysppinyuintkykntgkstr(String pZtysppinyuintkykntgkstr) {
        ztysppinyuintkykntgkstr = pZtysppinyuintkykntgkstr;
    }

    private String ztysijnbyutkykntgkstr;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYSIJNBYUTKYKNTGKSTR)
    public String getZtysijnbyutkykntgkstr() {
        return ztysijnbyutkykntgkstr;
    }

    public void setZtysijnbyutkykntgkstr(String pZtysijnbyutkykntgkstr) {
        ztysijnbyutkykntgkstr = pZtysijnbyutkykntgkstr;
    }

    private String ztysonotatokuyakuntgkstr;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYSONOTATOKUYAKUNTGKSTR)
    public String getZtysonotatokuyakuntgkstr() {
        return ztysonotatokuyakuntgkstr;
    }

    public void setZtysonotatokuyakuntgkstr(String pZtysonotatokuyakuntgkstr) {
        ztysonotatokuyakuntgkstr = pZtysonotatokuyakuntgkstr;
    }

    private String ztytrkmousideymd;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYTRKMOUSIDEYMD)
    public String getZtytrkmousideymd() {
        return ztytrkmousideymd;
    }

    public void setZtytrkmousideymd(String pZtytrkmousideymd) {
        ztytrkmousideymd = pZtytrkmousideymd;
    }

    private String ztylincsyoriymd;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYLINCSYORIYMD)
    public String getZtylincsyoriymd() {
        return ztylincsyoriymd;
    }

    public void setZtylincsyoriymd(String pZtylincsyoriymd) {
        ztylincsyoriymd = pZtylincsyoriymd;
    }

    private String ztyyuyusiyouknnm;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYYUYUSIYOUKNNM)
    public String getZtyyuyusiyouknnm() {
        return ztyyuyusiyouknnm;
    }

    public void setZtyyuyusiyouknnm(String pZtyyuyusiyouknnm) {
        ztyyuyusiyouknnm = pZtyyuyusiyouknnm;
    }

    @Id
    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYKYKKANRINO)
    public String getZtykykkanrino() {
        return getPrimaryKey().getZtykykkanrino();
    }

    public void setZtykykkanrino(String pZtykykkanrino) {
        getPrimaryKey().setZtykykkanrino(pZtykykkanrino);
    }

    private String ztyhozenymd;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYHOZENYMD)
    public String getZtyhozenymd() {
        return ztyhozenymd;
    }

    public void setZtyhozenymd(String pZtyhozenymd) {
        ztyhozenymd = pZtyhozenymd;
    }

    private String ztykykknnm;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYKYKKNNM)
    public String getZtykykknnm() {
        return ztykykknnm;
    }

    public void setZtykykknnm(String pZtykykknnm) {
        ztykykknnm = pZtykykknnm;
    }

    private String ztyhutuusbsstr;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYHUTUUSBSSTR)
    public String getZtyhutuusbsstr() {
        return ztyhutuusbsstr;
    }

    public void setZtyhutuusbsstr(String pZtyhutuusbsstr) {
        ztyhutuusbsstr = pZtyhutuusbsstr;
    }

    private String ztysgsbstr;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYSGSBSTR)
    public String getZtysgsbstr() {
        return ztysgsbstr;
    }

    public void setZtysgsbstr(String pZtysgsbstr) {
        ztysgsbstr = pZtysgsbstr;
    }

    private String ztykakusyasiyouran;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYKAKUSYASIYOURAN)
    public String getZtykakusyasiyouran() {
        return ztykakusyasiyouran;
    }

    public void setZtykakusyasiyouran(String pZtykakusyasiyouran) {
        ztykakusyasiyouran = pZtykakusyasiyouran;
    }

    private String ztymousideflg;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYMOUSIDEFLG)
    public String getZtymousideflg() {
        return ztymousideflg;
    }

    public void setZtymousideflg(String pZtymousideflg) {
        ztymousideflg = pZtymousideflg;
    }

    private String ztymousideflgsetymd;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYMOUSIDEFLGSETYMD)
    public String getZtymousideflgsetymd() {
        return ztymousideflgsetymd;
    }

    public void setZtymousideflgsetymd(String pZtymousideflgsetymd) {
        ztymousideflgsetymd = pZtymousideflgsetymd;
    }

    private String ztymousideflgkaijyoymd;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYMOUSIDEFLGKAIJYOYMD)
    public String getZtymousideflgkaijyoymd() {
        return ztymousideflgkaijyoymd;
    }

    public void setZtymousideflgkaijyoymd(String pZtymousideflgkaijyoymd) {
        ztymousideflgkaijyoymd = pZtymousideflgkaijyoymd;
    }

    private String ztyjgyhknflg;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYJGYHKNFLG)
    public String getZtyjgyhknflg() {
        return ztyjgyhknflg;
    }

    public void setZtyjgyhknflg(String pZtyjgyhknflg) {
        ztyjgyhknflg = pZtyjgyhknflg;
    }

    private String ztytnknflg;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYTNKNFLG)
    public String getZtytnknflg() {
        return ztytnknflg;
    }

    public void setZtytnknflg(String pZtytnknflg) {
        ztytnknflg = pZtytnknflg;
    }

    private String ztykyksyaseikbn;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYKYKSYASEIKBN)
    public String getZtykyksyaseikbn() {
        return ztykyksyaseikbn;
    }

    public void setZtykyksyaseikbn(String pZtykyksyaseikbn) {
        ztykyksyaseikbn = pZtykyksyaseikbn;
    }

    private String ztykyksyaseiymd;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYKYKSYASEIYMD)
    public String getZtykyksyaseiymd() {
        return ztykyksyaseiymd;
    }

    public void setZtykyksyaseiymd(String pZtykyksyaseiymd) {
        ztykyksyaseiymd = pZtykyksyaseiymd;
    }

    private String ztykykadrkn;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYKYKADRKN)
    public String getZtykykadrkn() {
        return ztykykadrkn;
    }

    public void setZtykykadrkn(String pZtykykadrkn) {
        ztykykadrkn = pZtykykadrkn;
    }

    private String ztyyobiv17;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYYOBIV17)
    public String getZtyyobiv17() {
        return ztyyobiv17;
    }

    public void setZtyyobiv17(String pZtyyobiv17) {
        ztyyobiv17 = pZtyyobiv17;
    }

    private String ztyknjhhknmei30;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYKNJHHKNMEI30)
    public String getZtyknjhhknmei30() {
        return ztyknjhhknmei30;
    }

    public void setZtyknjhhknmei30(String pZtyknjhhknmei30) {
        ztyknjhhknmei30 = pZtyknjhhknmei30;
    }

    private String ztykjkyknm30;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYKJKYKNM30)
    public String getZtykjkyknm30() {
        return ztykjkyknm30;
    }

    public void setZtykjkyknm30(String pZtykjkyknm30) {
        ztykjkyknm30 = pZtykjkyknm30;
    }

    private String zty15sai1000manflg;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTY15SAI1000MANFLG)
    public String getZty15sai1000manflg() {
        return zty15sai1000manflg;
    }

    public void setZty15sai1000manflg(String pZty15sai1000manflg) {
        zty15sai1000manflg = pZty15sai1000manflg;
    }

    private String ztykjhngflg;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYKJHNGFLG)
    public String getZtykjhngflg() {
        return ztykjhngflg;
    }

    public void setZtykjhngflg(String pZtykjhngflg) {
        ztykjhngflg = pZtykjhngflg;
    }

    private String ztykykytymd;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYKYKYTYMD)
    public String getZtykykytymd() {
        return ztykykytymd;
    }

    public void setZtykykytymd(String pZtykykytymd) {
        ztykykytymd = pZtykykytymd;
    }

    private String ztyhozenytymd;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYHOZENYTYMD)
    public String getZtyhozenytymd() {
        return ztyhozenytymd;
    }

    public void setZtyhozenytymd(String pZtyhozenytymd) {
        ztyhozenytymd = pZtyhozenytymd;
    }

    private String zty15mimantkhukaymd;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTY15MIMANTKHUKAYMD)
    public String getZty15mimantkhukaymd() {
        return zty15mimantkhukaymd;
    }

    public void setZty15mimantkhukaymd(String pZty15mimantkhukaymd) {
        zty15mimantkhukaymd = pZty15mimantkhukaymd;
    }

    private String zty15mimantkhukayoteiymd;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTY15MIMANTKHUKAYOTEIYMD)
    public String getZty15mimantkhukayoteiymd() {
        return zty15mimantkhukayoteiymd;
    }

    public void setZty15mimantkhukayoteiymd(String pZty15mimantkhukayoteiymd) {
        zty15mimantkhukayoteiymd = pZty15mimantkhukayoteiymd;
    }

    private String ztyyobiv46;

    @Column(name=GenZT_YakansyoriLincSousinTy.ZTYYOBIV46)
    public String getZtyyobiv46() {
        return ztyyobiv46;
    }

    public void setZtyyobiv46(String pZtyyobiv46) {
        ztyyobiv46 = pZtyyobiv46;
    }
}