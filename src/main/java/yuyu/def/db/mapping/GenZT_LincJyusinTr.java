package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_LincJyusinTr;
import yuyu.def.db.id.PKZT_LincJyusinTr;
import yuyu.def.db.meta.GenQZT_LincJyusinTr;
import yuyu.def.db.meta.QZT_LincJyusinTr;

/**
 * ＬＩＮＣ受信内容反映テーブル（取） テーブルのマッピング情報クラスで、 {@link ZT_LincJyusinTr} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_LincJyusinTr}</td><td colspan="3">ＬＩＮＣ受信内容反映テーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtrheadergyoumusyubetu ztrheadergyoumusyubetu}</td><td>（取込用）ヘッダ業務種別</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrheaderrecordkbn ztrheaderrecordkbn}</td><td>（取込用）ヘッダレコード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrheaderkaisyacd ztrheaderkaisyacd}</td><td>（取込用）ヘッダ会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrheadersousinymd ztrheadersousinymd}</td><td>（取込用）ヘッダ送信日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrheaderdatasyubetu ztrheaderdatasyubetu}</td><td>（取込用）ヘッダデータ種別</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrheaderkaitoukurikosi ztrheaderkaitoukurikosi}</td><td>（取込用）ヘッダ回答繰越</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrheadersyusindatasyubetu ztrheadersyusindatasyubetu}</td><td>（取込用）ヘッダ集信データ種別</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrheadersyusincircleno ztrheadersyusincircleno}</td><td>（取込用）ヘッダ集信サイクル番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyoriymd ztrsyoriymd}</td><td>（取込用）処理年月日</td><td align="center">{@link PKZT_LincJyusinTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrrenno10 ztrrenno10}</td><td>（取込用）連番１０桁</td><td align="center">{@link PKZT_LincJyusinTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv54 ztryobiv54}</td><td>（取込用）予備項目Ｖ５４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdatakbn ztrdatakbn}</td><td>（取込用）データ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrrecordsyubetukbn ztrrecordsyubetukbn}</td><td>（取込用）レコード種別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhenkoutype ztrhenkoutype}</td><td>（取込用）変更タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyorikekkacd ztrsyorikekkacd}</td><td>（取込用）処理結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyorikekkaerrjiyuu ztrsyorikekkaerrjiyuu}</td><td>（取込用）処理結果エラー事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyorikekkaerrno ztrsyorikekkaerrno}</td><td>（取込用）処理結果エラー項番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrnayoserecordsuu ztrnayoserecordsuu}</td><td>（取込用）名寄せレコード数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkanyuusyano ztrkanyuusyano}</td><td>（取込用）加入者番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkyoukaisiyouknnm ztrkyoukaisiyouknnm}</td><td>（取込用）協会使用カナ氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhhknseikbn ztrhhknseikbn}</td><td>（取込用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhhknseiymd ztrhhknseiymd}</td><td>（取込用）被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkykymd ztrkykymd}</td><td>（取込用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkyksyhhknsydouituhyouji ztrkyksyhhknsydouituhyouji}</td><td>（取込用）契約者被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsousinmotokaisyacd ztrsousinmotokaisyacd}</td><td>（取込用）送信元会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhhknadrkn ztrhhknadrkn}</td><td>（取込用）被保険者住所（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsiginyuintkykntgkstr ztrsiginyuintkykntgkstr}</td><td>（取込用）災害入院特約日額（文字列）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsppinyuintkykntgkstr ztrsppinyuintkykntgkstr}</td><td>（取込用）疾病入院特約日額（文字列）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsijnbyutkykntgkstr ztrsijnbyutkykntgkstr}</td><td>（取込用）成人病特約日額（文字列）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsonotatokuyakuntgkstr ztrsonotatokuyakuntgkstr}</td><td>（取込用）その他特約日額（文字列）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtrkmousideymd ztrtrkmousideymd}</td><td>（取込用）登録申出年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrlincsyoriymd ztrlincsyoriymd}</td><td>（取込用）ＬＩＮＣ処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryuyusiyouknnm ztryuyusiyouknnm}</td><td>（取込用）住友使用カナ氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkykkanrino ztrkykkanrino}</td><td>（取込用）契約管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhozenymd ztrhozenymd}</td><td>（取込用）保全年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkykknnm ztrkykknnm}</td><td>（取込用）契約者カナ氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhutuusbsstr ztrhutuusbsstr}</td><td>（取込用）普通死亡保険金額（文字列）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsgsbstr ztrsgsbstr}</td><td>（取込用）災害死亡保険金額（文字列）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkakusyasiyouran ztrkakusyasiyouran}</td><td>（取込用）各社使用欄</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrmousideflg ztrmousideflg}</td><td>（取込用）申出フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrmousideflgsetymd ztrmousideflgsetymd}</td><td>（取込用）申出フラグ設定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrmousideflgkaijyoymd ztrmousideflgkaijyoymd}</td><td>（取込用）申出フラグ解除年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrjgyhknflg ztrjgyhknflg}</td><td>（取込用）事業保険フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtnknflg ztrtnknflg}</td><td>（取込用）転換フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkyksyaseikbn ztrkyksyaseikbn}</td><td>（取込用）契約者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkyksyaseiymd ztrkyksyaseiymd}</td><td>（取込用）契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkykadrkn ztrkykadrkn}</td><td>（取込用）契約者住所（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv17 ztryobiv17}</td><td>（取込用）予備項目Ｖ１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrknjhhknmei30 ztrknjhhknmei30}</td><td>（取込用）漢字被保険者名（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkjkyknm30 ztrkjkyknm30}</td><td>（取込用）漢字契約者名（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtr15sai1000manflg ztr15sai1000manflg}</td><td>（取込用）１５歳未満１０００万超フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkjhngflg ztrkjhngflg}</td><td>（取込用）漢字範囲外フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkykytymd ztrkykytymd}</td><td>（取込用）契約予定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhozenytymd ztrhozenytymd}</td><td>（取込用）保全予定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtr15mimantkhukaymd ztr15mimantkhukaymd}</td><td>（取込用）１５歳未満特約中途付加年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtr15mimantkhukayoteiymd ztr15mimantkhukayoteiymd}</td><td>（取込用）１５歳未満特約中途付加予定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv46 ztryobiv46}</td><td>（取込用）予備項目Ｖ４６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_LincJyusinTr
 * @see     PKZT_LincJyusinTr
 * @see     QZT_LincJyusinTr
 * @see     GenQZT_LincJyusinTr
 */
@MappedSuperclass
@Table(name=GenZT_LincJyusinTr.TABLE_NAME)
@IdClass(value=PKZT_LincJyusinTr.class)
public abstract class GenZT_LincJyusinTr extends AbstractExDBEntity<ZT_LincJyusinTr, PKZT_LincJyusinTr> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_LincJyusinTr";
    public static final String ZTRHEADERGYOUMUSYUBETU   = "ztrheadergyoumusyubetu";
    public static final String ZTRHEADERRECORDKBN       = "ztrheaderrecordkbn";
    public static final String ZTRHEADERKAISYACD        = "ztrheaderkaisyacd";
    public static final String ZTRHEADERSOUSINYMD       = "ztrheadersousinymd";
    public static final String ZTRHEADERDATASYUBETU     = "ztrheaderdatasyubetu";
    public static final String ZTRHEADERKAITOUKURIKOSI  = "ztrheaderkaitoukurikosi";
    public static final String ZTRHEADERSYUSINDATASYUBETU = "ztrheadersyusindatasyubetu";
    public static final String ZTRHEADERSYUSINCIRCLENO  = "ztrheadersyusincircleno";
    public static final String ZTRSYORIYMD              = "ztrsyoriymd";
    public static final String ZTRRENNO10               = "ztrrenno10";
    public static final String ZTRYOBIV54               = "ztryobiv54";
    public static final String ZTRDATAKBN               = "ztrdatakbn";
    public static final String ZTRRECORDSYUBETUKBN      = "ztrrecordsyubetukbn";
    public static final String ZTRHENKOUTYPE            = "ztrhenkoutype";
    public static final String ZTRSYORIKEKKACD          = "ztrsyorikekkacd";
    public static final String ZTRSYORIKEKKAERRJIYUU    = "ztrsyorikekkaerrjiyuu";
    public static final String ZTRSYORIKEKKAERRNO       = "ztrsyorikekkaerrno";
    public static final String ZTRNAYOSERECORDSUU       = "ztrnayoserecordsuu";
    public static final String ZTRKANYUUSYANO           = "ztrkanyuusyano";
    public static final String ZTRKYOUKAISIYOUKNNM      = "ztrkyoukaisiyouknnm";
    public static final String ZTRHHKNSEIKBN            = "ztrhhknseikbn";
    public static final String ZTRHHKNSEIYMD            = "ztrhhknseiymd";
    public static final String ZTRKYKYMD                = "ztrkykymd";
    public static final String ZTRKYKSYHHKNSYDOUITUHYOUJI = "ztrkyksyhhknsydouituhyouji";
    public static final String ZTRSOUSINMOTOKAISYACD    = "ztrsousinmotokaisyacd";
    public static final String ZTRHHKNADRKN             = "ztrhhknadrkn";
    public static final String ZTRSIGINYUINTKYKNTGKSTR  = "ztrsiginyuintkykntgkstr";
    public static final String ZTRSPPINYUINTKYKNTGKSTR  = "ztrsppinyuintkykntgkstr";
    public static final String ZTRSIJNBYUTKYKNTGKSTR    = "ztrsijnbyutkykntgkstr";
    public static final String ZTRSONOTATOKUYAKUNTGKSTR = "ztrsonotatokuyakuntgkstr";
    public static final String ZTRTRKMOUSIDEYMD         = "ztrtrkmousideymd";
    public static final String ZTRLINCSYORIYMD          = "ztrlincsyoriymd";
    public static final String ZTRYUYUSIYOUKNNM         = "ztryuyusiyouknnm";
    public static final String ZTRKYKKANRINO            = "ztrkykkanrino";
    public static final String ZTRHOZENYMD              = "ztrhozenymd";
    public static final String ZTRKYKKNNM               = "ztrkykknnm";
    public static final String ZTRHUTUUSBSSTR           = "ztrhutuusbsstr";
    public static final String ZTRSGSBSTR               = "ztrsgsbstr";
    public static final String ZTRKAKUSYASIYOURAN       = "ztrkakusyasiyouran";
    public static final String ZTRMOUSIDEFLG            = "ztrmousideflg";
    public static final String ZTRMOUSIDEFLGSETYMD      = "ztrmousideflgsetymd";
    public static final String ZTRMOUSIDEFLGKAIJYOYMD   = "ztrmousideflgkaijyoymd";
    public static final String ZTRJGYHKNFLG             = "ztrjgyhknflg";
    public static final String ZTRTNKNFLG               = "ztrtnknflg";
    public static final String ZTRKYKSYASEIKBN          = "ztrkyksyaseikbn";
    public static final String ZTRKYKSYASEIYMD          = "ztrkyksyaseiymd";
    public static final String ZTRKYKADRKN              = "ztrkykadrkn";
    public static final String ZTRYOBIV17               = "ztryobiv17";
    public static final String ZTRKNJHHKNMEI30          = "ztrknjhhknmei30";
    public static final String ZTRKJKYKNM30             = "ztrkjkyknm30";
    public static final String ZTR15SAI1000MANFLG       = "ztr15sai1000manflg";
    public static final String ZTRKJHNGFLG              = "ztrkjhngflg";
    public static final String ZTRKYKYTYMD              = "ztrkykytymd";
    public static final String ZTRHOZENYTYMD            = "ztrhozenytymd";
    public static final String ZTR15MIMANTKHUKAYMD      = "ztr15mimantkhukaymd";
    public static final String ZTR15MIMANTKHUKAYOTEIYMD = "ztr15mimantkhukayoteiymd";
    public static final String ZTRYOBIV46               = "ztryobiv46";

    private final PKZT_LincJyusinTr primaryKey;

    public GenZT_LincJyusinTr() {
        primaryKey = new PKZT_LincJyusinTr();
    }

    public GenZT_LincJyusinTr(String pZtrsyoriymd, String pZtrrenno10) {
        primaryKey = new PKZT_LincJyusinTr(pZtrsyoriymd, pZtrrenno10);
    }

    @Transient
    @Override
    public PKZT_LincJyusinTr getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_LincJyusinTr> getMetaClass() {
        return QZT_LincJyusinTr.class;
    }

    private String ztrheadergyoumusyubetu;

    @Column(name=GenZT_LincJyusinTr.ZTRHEADERGYOUMUSYUBETU)
    public String getZtrheadergyoumusyubetu() {
        return ztrheadergyoumusyubetu;
    }

    public void setZtrheadergyoumusyubetu(String pZtrheadergyoumusyubetu) {
        ztrheadergyoumusyubetu = pZtrheadergyoumusyubetu;
    }

    private String ztrheaderrecordkbn;

    @Column(name=GenZT_LincJyusinTr.ZTRHEADERRECORDKBN)
    public String getZtrheaderrecordkbn() {
        return ztrheaderrecordkbn;
    }

    public void setZtrheaderrecordkbn(String pZtrheaderrecordkbn) {
        ztrheaderrecordkbn = pZtrheaderrecordkbn;
    }

    private String ztrheaderkaisyacd;

    @Column(name=GenZT_LincJyusinTr.ZTRHEADERKAISYACD)
    public String getZtrheaderkaisyacd() {
        return ztrheaderkaisyacd;
    }

    public void setZtrheaderkaisyacd(String pZtrheaderkaisyacd) {
        ztrheaderkaisyacd = pZtrheaderkaisyacd;
    }

    private String ztrheadersousinymd;

    @Column(name=GenZT_LincJyusinTr.ZTRHEADERSOUSINYMD)
    public String getZtrheadersousinymd() {
        return ztrheadersousinymd;
    }

    public void setZtrheadersousinymd(String pZtrheadersousinymd) {
        ztrheadersousinymd = pZtrheadersousinymd;
    }

    private String ztrheaderdatasyubetu;

    @Column(name=GenZT_LincJyusinTr.ZTRHEADERDATASYUBETU)
    public String getZtrheaderdatasyubetu() {
        return ztrheaderdatasyubetu;
    }

    public void setZtrheaderdatasyubetu(String pZtrheaderdatasyubetu) {
        ztrheaderdatasyubetu = pZtrheaderdatasyubetu;
    }

    private String ztrheaderkaitoukurikosi;

    @Column(name=GenZT_LincJyusinTr.ZTRHEADERKAITOUKURIKOSI)
    public String getZtrheaderkaitoukurikosi() {
        return ztrheaderkaitoukurikosi;
    }

    public void setZtrheaderkaitoukurikosi(String pZtrheaderkaitoukurikosi) {
        ztrheaderkaitoukurikosi = pZtrheaderkaitoukurikosi;
    }

    private String ztrheadersyusindatasyubetu;

    @Column(name=GenZT_LincJyusinTr.ZTRHEADERSYUSINDATASYUBETU)
    public String getZtrheadersyusindatasyubetu() {
        return ztrheadersyusindatasyubetu;
    }

    public void setZtrheadersyusindatasyubetu(String pZtrheadersyusindatasyubetu) {
        ztrheadersyusindatasyubetu = pZtrheadersyusindatasyubetu;
    }

    private String ztrheadersyusincircleno;

    @Column(name=GenZT_LincJyusinTr.ZTRHEADERSYUSINCIRCLENO)
    public String getZtrheadersyusincircleno() {
        return ztrheadersyusincircleno;
    }

    public void setZtrheadersyusincircleno(String pZtrheadersyusincircleno) {
        ztrheadersyusincircleno = pZtrheadersyusincircleno;
    }

    @Id
    @Column(name=GenZT_LincJyusinTr.ZTRSYORIYMD)
    public String getZtrsyoriymd() {
        return getPrimaryKey().getZtrsyoriymd();
    }

    public void setZtrsyoriymd(String pZtrsyoriymd) {
        getPrimaryKey().setZtrsyoriymd(pZtrsyoriymd);
    }

    @Id
    @Column(name=GenZT_LincJyusinTr.ZTRRENNO10)
    public String getZtrrenno10() {
        return getPrimaryKey().getZtrrenno10();
    }

    public void setZtrrenno10(String pZtrrenno10) {
        getPrimaryKey().setZtrrenno10(pZtrrenno10);
    }

    private String ztryobiv54;

    @Column(name=GenZT_LincJyusinTr.ZTRYOBIV54)
    public String getZtryobiv54() {
        return ztryobiv54;
    }

    public void setZtryobiv54(String pZtryobiv54) {
        ztryobiv54 = pZtryobiv54;
    }

    private String ztrdatakbn;

    @Column(name=GenZT_LincJyusinTr.ZTRDATAKBN)
    public String getZtrdatakbn() {
        return ztrdatakbn;
    }

    public void setZtrdatakbn(String pZtrdatakbn) {
        ztrdatakbn = pZtrdatakbn;
    }

    private String ztrrecordsyubetukbn;

    @Column(name=GenZT_LincJyusinTr.ZTRRECORDSYUBETUKBN)
    public String getZtrrecordsyubetukbn() {
        return ztrrecordsyubetukbn;
    }

    public void setZtrrecordsyubetukbn(String pZtrrecordsyubetukbn) {
        ztrrecordsyubetukbn = pZtrrecordsyubetukbn;
    }

    private String ztrhenkoutype;

    @Column(name=GenZT_LincJyusinTr.ZTRHENKOUTYPE)
    public String getZtrhenkoutype() {
        return ztrhenkoutype;
    }

    public void setZtrhenkoutype(String pZtrhenkoutype) {
        ztrhenkoutype = pZtrhenkoutype;
    }

    private String ztrsyorikekkacd;

    @Column(name=GenZT_LincJyusinTr.ZTRSYORIKEKKACD)
    public String getZtrsyorikekkacd() {
        return ztrsyorikekkacd;
    }

    public void setZtrsyorikekkacd(String pZtrsyorikekkacd) {
        ztrsyorikekkacd = pZtrsyorikekkacd;
    }

    private String ztrsyorikekkaerrjiyuu;

    @Column(name=GenZT_LincJyusinTr.ZTRSYORIKEKKAERRJIYUU)
    public String getZtrsyorikekkaerrjiyuu() {
        return ztrsyorikekkaerrjiyuu;
    }

    public void setZtrsyorikekkaerrjiyuu(String pZtrsyorikekkaerrjiyuu) {
        ztrsyorikekkaerrjiyuu = pZtrsyorikekkaerrjiyuu;
    }

    private String ztrsyorikekkaerrno;

    @Column(name=GenZT_LincJyusinTr.ZTRSYORIKEKKAERRNO)
    public String getZtrsyorikekkaerrno() {
        return ztrsyorikekkaerrno;
    }

    public void setZtrsyorikekkaerrno(String pZtrsyorikekkaerrno) {
        ztrsyorikekkaerrno = pZtrsyorikekkaerrno;
    }

    private String ztrnayoserecordsuu;

    @Column(name=GenZT_LincJyusinTr.ZTRNAYOSERECORDSUU)
    public String getZtrnayoserecordsuu() {
        return ztrnayoserecordsuu;
    }

    public void setZtrnayoserecordsuu(String pZtrnayoserecordsuu) {
        ztrnayoserecordsuu = pZtrnayoserecordsuu;
    }

    private String ztrkanyuusyano;

    @Column(name=GenZT_LincJyusinTr.ZTRKANYUUSYANO)
    public String getZtrkanyuusyano() {
        return ztrkanyuusyano;
    }

    public void setZtrkanyuusyano(String pZtrkanyuusyano) {
        ztrkanyuusyano = pZtrkanyuusyano;
    }

    private String ztrkyoukaisiyouknnm;

    @Column(name=GenZT_LincJyusinTr.ZTRKYOUKAISIYOUKNNM)
    public String getZtrkyoukaisiyouknnm() {
        return ztrkyoukaisiyouknnm;
    }

    public void setZtrkyoukaisiyouknnm(String pZtrkyoukaisiyouknnm) {
        ztrkyoukaisiyouknnm = pZtrkyoukaisiyouknnm;
    }

    private String ztrhhknseikbn;

    @Column(name=GenZT_LincJyusinTr.ZTRHHKNSEIKBN)
    public String getZtrhhknseikbn() {
        return ztrhhknseikbn;
    }

    public void setZtrhhknseikbn(String pZtrhhknseikbn) {
        ztrhhknseikbn = pZtrhhknseikbn;
    }

    private String ztrhhknseiymd;

    @Column(name=GenZT_LincJyusinTr.ZTRHHKNSEIYMD)
    public String getZtrhhknseiymd() {
        return ztrhhknseiymd;
    }

    public void setZtrhhknseiymd(String pZtrhhknseiymd) {
        ztrhhknseiymd = pZtrhhknseiymd;
    }

    private String ztrkykymd;

    @Column(name=GenZT_LincJyusinTr.ZTRKYKYMD)
    public String getZtrkykymd() {
        return ztrkykymd;
    }

    public void setZtrkykymd(String pZtrkykymd) {
        ztrkykymd = pZtrkykymd;
    }

    private String ztrkyksyhhknsydouituhyouji;

    @Column(name=GenZT_LincJyusinTr.ZTRKYKSYHHKNSYDOUITUHYOUJI)
    public String getZtrkyksyhhknsydouituhyouji() {
        return ztrkyksyhhknsydouituhyouji;
    }

    public void setZtrkyksyhhknsydouituhyouji(String pZtrkyksyhhknsydouituhyouji) {
        ztrkyksyhhknsydouituhyouji = pZtrkyksyhhknsydouituhyouji;
    }

    private String ztrsousinmotokaisyacd;

    @Column(name=GenZT_LincJyusinTr.ZTRSOUSINMOTOKAISYACD)
    public String getZtrsousinmotokaisyacd() {
        return ztrsousinmotokaisyacd;
    }

    public void setZtrsousinmotokaisyacd(String pZtrsousinmotokaisyacd) {
        ztrsousinmotokaisyacd = pZtrsousinmotokaisyacd;
    }

    private String ztrhhknadrkn;

    @Column(name=GenZT_LincJyusinTr.ZTRHHKNADRKN)
    public String getZtrhhknadrkn() {
        return ztrhhknadrkn;
    }

    public void setZtrhhknadrkn(String pZtrhhknadrkn) {
        ztrhhknadrkn = pZtrhhknadrkn;
    }

    private String ztrsiginyuintkykntgkstr;

    @Column(name=GenZT_LincJyusinTr.ZTRSIGINYUINTKYKNTGKSTR)
    public String getZtrsiginyuintkykntgkstr() {
        return ztrsiginyuintkykntgkstr;
    }

    public void setZtrsiginyuintkykntgkstr(String pZtrsiginyuintkykntgkstr) {
        ztrsiginyuintkykntgkstr = pZtrsiginyuintkykntgkstr;
    }

    private String ztrsppinyuintkykntgkstr;

    @Column(name=GenZT_LincJyusinTr.ZTRSPPINYUINTKYKNTGKSTR)
    public String getZtrsppinyuintkykntgkstr() {
        return ztrsppinyuintkykntgkstr;
    }

    public void setZtrsppinyuintkykntgkstr(String pZtrsppinyuintkykntgkstr) {
        ztrsppinyuintkykntgkstr = pZtrsppinyuintkykntgkstr;
    }

    private String ztrsijnbyutkykntgkstr;

    @Column(name=GenZT_LincJyusinTr.ZTRSIJNBYUTKYKNTGKSTR)
    public String getZtrsijnbyutkykntgkstr() {
        return ztrsijnbyutkykntgkstr;
    }

    public void setZtrsijnbyutkykntgkstr(String pZtrsijnbyutkykntgkstr) {
        ztrsijnbyutkykntgkstr = pZtrsijnbyutkykntgkstr;
    }

    private String ztrsonotatokuyakuntgkstr;

    @Column(name=GenZT_LincJyusinTr.ZTRSONOTATOKUYAKUNTGKSTR)
    public String getZtrsonotatokuyakuntgkstr() {
        return ztrsonotatokuyakuntgkstr;
    }

    public void setZtrsonotatokuyakuntgkstr(String pZtrsonotatokuyakuntgkstr) {
        ztrsonotatokuyakuntgkstr = pZtrsonotatokuyakuntgkstr;
    }

    private String ztrtrkmousideymd;

    @Column(name=GenZT_LincJyusinTr.ZTRTRKMOUSIDEYMD)
    public String getZtrtrkmousideymd() {
        return ztrtrkmousideymd;
    }

    public void setZtrtrkmousideymd(String pZtrtrkmousideymd) {
        ztrtrkmousideymd = pZtrtrkmousideymd;
    }

    private String ztrlincsyoriymd;

    @Column(name=GenZT_LincJyusinTr.ZTRLINCSYORIYMD)
    public String getZtrlincsyoriymd() {
        return ztrlincsyoriymd;
    }

    public void setZtrlincsyoriymd(String pZtrlincsyoriymd) {
        ztrlincsyoriymd = pZtrlincsyoriymd;
    }

    private String ztryuyusiyouknnm;

    @Column(name=GenZT_LincJyusinTr.ZTRYUYUSIYOUKNNM)
    public String getZtryuyusiyouknnm() {
        return ztryuyusiyouknnm;
    }

    public void setZtryuyusiyouknnm(String pZtryuyusiyouknnm) {
        ztryuyusiyouknnm = pZtryuyusiyouknnm;
    }

    private String ztrkykkanrino;

    @Column(name=GenZT_LincJyusinTr.ZTRKYKKANRINO)
    public String getZtrkykkanrino() {
        return ztrkykkanrino;
    }

    public void setZtrkykkanrino(String pZtrkykkanrino) {
        ztrkykkanrino = pZtrkykkanrino;
    }

    private String ztrhozenymd;

    @Column(name=GenZT_LincJyusinTr.ZTRHOZENYMD)
    public String getZtrhozenymd() {
        return ztrhozenymd;
    }

    public void setZtrhozenymd(String pZtrhozenymd) {
        ztrhozenymd = pZtrhozenymd;
    }

    private String ztrkykknnm;

    @Column(name=GenZT_LincJyusinTr.ZTRKYKKNNM)
    public String getZtrkykknnm() {
        return ztrkykknnm;
    }

    public void setZtrkykknnm(String pZtrkykknnm) {
        ztrkykknnm = pZtrkykknnm;
    }

    private String ztrhutuusbsstr;

    @Column(name=GenZT_LincJyusinTr.ZTRHUTUUSBSSTR)
    public String getZtrhutuusbsstr() {
        return ztrhutuusbsstr;
    }

    public void setZtrhutuusbsstr(String pZtrhutuusbsstr) {
        ztrhutuusbsstr = pZtrhutuusbsstr;
    }

    private String ztrsgsbstr;

    @Column(name=GenZT_LincJyusinTr.ZTRSGSBSTR)
    public String getZtrsgsbstr() {
        return ztrsgsbstr;
    }

    public void setZtrsgsbstr(String pZtrsgsbstr) {
        ztrsgsbstr = pZtrsgsbstr;
    }

    private String ztrkakusyasiyouran;

    @Column(name=GenZT_LincJyusinTr.ZTRKAKUSYASIYOURAN)
    public String getZtrkakusyasiyouran() {
        return ztrkakusyasiyouran;
    }

    public void setZtrkakusyasiyouran(String pZtrkakusyasiyouran) {
        ztrkakusyasiyouran = pZtrkakusyasiyouran;
    }

    private String ztrmousideflg;

    @Column(name=GenZT_LincJyusinTr.ZTRMOUSIDEFLG)
    public String getZtrmousideflg() {
        return ztrmousideflg;
    }

    public void setZtrmousideflg(String pZtrmousideflg) {
        ztrmousideflg = pZtrmousideflg;
    }

    private String ztrmousideflgsetymd;

    @Column(name=GenZT_LincJyusinTr.ZTRMOUSIDEFLGSETYMD)
    public String getZtrmousideflgsetymd() {
        return ztrmousideflgsetymd;
    }

    public void setZtrmousideflgsetymd(String pZtrmousideflgsetymd) {
        ztrmousideflgsetymd = pZtrmousideflgsetymd;
    }

    private String ztrmousideflgkaijyoymd;

    @Column(name=GenZT_LincJyusinTr.ZTRMOUSIDEFLGKAIJYOYMD)
    public String getZtrmousideflgkaijyoymd() {
        return ztrmousideflgkaijyoymd;
    }

    public void setZtrmousideflgkaijyoymd(String pZtrmousideflgkaijyoymd) {
        ztrmousideflgkaijyoymd = pZtrmousideflgkaijyoymd;
    }

    private String ztrjgyhknflg;

    @Column(name=GenZT_LincJyusinTr.ZTRJGYHKNFLG)
    public String getZtrjgyhknflg() {
        return ztrjgyhknflg;
    }

    public void setZtrjgyhknflg(String pZtrjgyhknflg) {
        ztrjgyhknflg = pZtrjgyhknflg;
    }

    private String ztrtnknflg;

    @Column(name=GenZT_LincJyusinTr.ZTRTNKNFLG)
    public String getZtrtnknflg() {
        return ztrtnknflg;
    }

    public void setZtrtnknflg(String pZtrtnknflg) {
        ztrtnknflg = pZtrtnknflg;
    }

    private String ztrkyksyaseikbn;

    @Column(name=GenZT_LincJyusinTr.ZTRKYKSYASEIKBN)
    public String getZtrkyksyaseikbn() {
        return ztrkyksyaseikbn;
    }

    public void setZtrkyksyaseikbn(String pZtrkyksyaseikbn) {
        ztrkyksyaseikbn = pZtrkyksyaseikbn;
    }

    private String ztrkyksyaseiymd;

    @Column(name=GenZT_LincJyusinTr.ZTRKYKSYASEIYMD)
    public String getZtrkyksyaseiymd() {
        return ztrkyksyaseiymd;
    }

    public void setZtrkyksyaseiymd(String pZtrkyksyaseiymd) {
        ztrkyksyaseiymd = pZtrkyksyaseiymd;
    }

    private String ztrkykadrkn;

    @Column(name=GenZT_LincJyusinTr.ZTRKYKADRKN)
    public String getZtrkykadrkn() {
        return ztrkykadrkn;
    }

    public void setZtrkykadrkn(String pZtrkykadrkn) {
        ztrkykadrkn = pZtrkykadrkn;
    }

    private String ztryobiv17;

    @Column(name=GenZT_LincJyusinTr.ZTRYOBIV17)
    public String getZtryobiv17() {
        return ztryobiv17;
    }

    public void setZtryobiv17(String pZtryobiv17) {
        ztryobiv17 = pZtryobiv17;
    }

    private String ztrknjhhknmei30;

    @Column(name=GenZT_LincJyusinTr.ZTRKNJHHKNMEI30)
    public String getZtrknjhhknmei30() {
        return ztrknjhhknmei30;
    }

    public void setZtrknjhhknmei30(String pZtrknjhhknmei30) {
        ztrknjhhknmei30 = pZtrknjhhknmei30;
    }

    private String ztrkjkyknm30;

    @Column(name=GenZT_LincJyusinTr.ZTRKJKYKNM30)
    public String getZtrkjkyknm30() {
        return ztrkjkyknm30;
    }

    public void setZtrkjkyknm30(String pZtrkjkyknm30) {
        ztrkjkyknm30 = pZtrkjkyknm30;
    }

    private String ztr15sai1000manflg;

    @Column(name=GenZT_LincJyusinTr.ZTR15SAI1000MANFLG)
    public String getZtr15sai1000manflg() {
        return ztr15sai1000manflg;
    }

    public void setZtr15sai1000manflg(String pZtr15sai1000manflg) {
        ztr15sai1000manflg = pZtr15sai1000manflg;
    }

    private String ztrkjhngflg;

    @Column(name=GenZT_LincJyusinTr.ZTRKJHNGFLG)
    public String getZtrkjhngflg() {
        return ztrkjhngflg;
    }

    public void setZtrkjhngflg(String pZtrkjhngflg) {
        ztrkjhngflg = pZtrkjhngflg;
    }

    private String ztrkykytymd;

    @Column(name=GenZT_LincJyusinTr.ZTRKYKYTYMD)
    public String getZtrkykytymd() {
        return ztrkykytymd;
    }

    public void setZtrkykytymd(String pZtrkykytymd) {
        ztrkykytymd = pZtrkykytymd;
    }

    private String ztrhozenytymd;

    @Column(name=GenZT_LincJyusinTr.ZTRHOZENYTYMD)
    public String getZtrhozenytymd() {
        return ztrhozenytymd;
    }

    public void setZtrhozenytymd(String pZtrhozenytymd) {
        ztrhozenytymd = pZtrhozenytymd;
    }

    private String ztr15mimantkhukaymd;

    @Column(name=GenZT_LincJyusinTr.ZTR15MIMANTKHUKAYMD)
    public String getZtr15mimantkhukaymd() {
        return ztr15mimantkhukaymd;
    }

    public void setZtr15mimantkhukaymd(String pZtr15mimantkhukaymd) {
        ztr15mimantkhukaymd = pZtr15mimantkhukaymd;
    }

    private String ztr15mimantkhukayoteiymd;

    @Column(name=GenZT_LincJyusinTr.ZTR15MIMANTKHUKAYOTEIYMD)
    public String getZtr15mimantkhukayoteiymd() {
        return ztr15mimantkhukayoteiymd;
    }

    public void setZtr15mimantkhukayoteiymd(String pZtr15mimantkhukayoteiymd) {
        ztr15mimantkhukayoteiymd = pZtr15mimantkhukayoteiymd;
    }

    private String ztryobiv46;

    @Column(name=GenZT_LincJyusinTr.ZTRYOBIV46)
    public String getZtryobiv46() {
        return ztryobiv46;
    }

    public void setZtryobiv46(String pZtryobiv46) {
        ztryobiv46 = pZtryobiv46;
    }
}