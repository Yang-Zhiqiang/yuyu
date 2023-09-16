package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_LincJyusinRn;
import yuyu.def.db.id.PKZT_LincJyusinRn;
import yuyu.def.db.meta.GenQZT_LincJyusinRn;
import yuyu.def.db.meta.QZT_LincJyusinRn;

/**
 * ＬＩＮＣ受信内容反映テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_LincJyusinRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_LincJyusinRn}</td><td colspan="3">ＬＩＮＣ受信内容反映テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnheadergyoumusyubetu zrnheadergyoumusyubetu}</td><td>（連携用）ヘッダ業務種別</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnheaderrecordkbn zrnheaderrecordkbn}</td><td>（連携用）ヘッダレコード区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnheaderkaisyacd zrnheaderkaisyacd}</td><td>（連携用）ヘッダ会社コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnheadersousinymd zrnheadersousinymd}</td><td>（連携用）ヘッダ送信日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnheaderdatasyubetu zrnheaderdatasyubetu}</td><td>（連携用）ヘッダデータ種別</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnheaderkaitoukurikosi zrnheaderkaitoukurikosi}</td><td>（連携用）ヘッダ回答繰越</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnheadersyusindatasyubetu zrnheadersyusindatasyubetu}</td><td>（連携用）ヘッダ集信データ種別</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnheadersyusincircleno zrnheadersyusincircleno}</td><td>（連携用）ヘッダ集信サイクル番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoriymd zrnsyoriymd}</td><td>（連携用）処理年月日</td><td align="center">{@link PKZT_LincJyusinRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrenno10 zrnrenno10}</td><td>（連携用）連番１０桁</td><td align="center">{@link PKZT_LincJyusinRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv54 zrnyobiv54}</td><td>（連携用）予備項目Ｖ５４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakbn zrndatakbn}</td><td>（連携用）データ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrecordsyubetukbn zrnrecordsyubetukbn}</td><td>（連携用）レコード種別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
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
 *  <tr><td>{@link #getZrnkykkanrino zrnkykkanrino}</td><td>（連携用）契約管理番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
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
 * @see     ZT_LincJyusinRn
 * @see     PKZT_LincJyusinRn
 * @see     QZT_LincJyusinRn
 * @see     GenQZT_LincJyusinRn
 */
@MappedSuperclass
@Table(name=GenZT_LincJyusinRn.TABLE_NAME)
@IdClass(value=PKZT_LincJyusinRn.class)
public abstract class GenZT_LincJyusinRn extends AbstractExDBEntityForZDB<ZT_LincJyusinRn, PKZT_LincJyusinRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_LincJyusinRn";
    public static final String ZRNHEADERGYOUMUSYUBETU   = "zrnheadergyoumusyubetu";
    public static final String ZRNHEADERRECORDKBN       = "zrnheaderrecordkbn";
    public static final String ZRNHEADERKAISYACD        = "zrnheaderkaisyacd";
    public static final String ZRNHEADERSOUSINYMD       = "zrnheadersousinymd";
    public static final String ZRNHEADERDATASYUBETU     = "zrnheaderdatasyubetu";
    public static final String ZRNHEADERKAITOUKURIKOSI  = "zrnheaderkaitoukurikosi";
    public static final String ZRNHEADERSYUSINDATASYUBETU = "zrnheadersyusindatasyubetu";
    public static final String ZRNHEADERSYUSINCIRCLENO  = "zrnheadersyusincircleno";
    public static final String ZRNSYORIYMD              = "zrnsyoriymd";
    public static final String ZRNRENNO10               = "zrnrenno10";
    public static final String ZRNYOBIV54               = "zrnyobiv54";
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

    private final PKZT_LincJyusinRn primaryKey;

    public GenZT_LincJyusinRn() {
        primaryKey = new PKZT_LincJyusinRn();
    }

    public GenZT_LincJyusinRn(String pZrnsyoriymd, String pZrnrenno10) {
        primaryKey = new PKZT_LincJyusinRn(pZrnsyoriymd, pZrnrenno10);
    }

    @Transient
    @Override
    public PKZT_LincJyusinRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_LincJyusinRn> getMetaClass() {
        return QZT_LincJyusinRn.class;
    }

    private String zrnheadergyoumusyubetu;

    @Column(name=GenZT_LincJyusinRn.ZRNHEADERGYOUMUSYUBETU)
    public String getZrnheadergyoumusyubetu() {
        return zrnheadergyoumusyubetu;
    }

    public void setZrnheadergyoumusyubetu(String pZrnheadergyoumusyubetu) {
        zrnheadergyoumusyubetu = pZrnheadergyoumusyubetu;
    }

    private String zrnheaderrecordkbn;

    @Column(name=GenZT_LincJyusinRn.ZRNHEADERRECORDKBN)
    public String getZrnheaderrecordkbn() {
        return zrnheaderrecordkbn;
    }

    public void setZrnheaderrecordkbn(String pZrnheaderrecordkbn) {
        zrnheaderrecordkbn = pZrnheaderrecordkbn;
    }

    private String zrnheaderkaisyacd;

    @Column(name=GenZT_LincJyusinRn.ZRNHEADERKAISYACD)
    public String getZrnheaderkaisyacd() {
        return zrnheaderkaisyacd;
    }

    public void setZrnheaderkaisyacd(String pZrnheaderkaisyacd) {
        zrnheaderkaisyacd = pZrnheaderkaisyacd;
    }

    private String zrnheadersousinymd;

    @Column(name=GenZT_LincJyusinRn.ZRNHEADERSOUSINYMD)
    public String getZrnheadersousinymd() {
        return zrnheadersousinymd;
    }

    public void setZrnheadersousinymd(String pZrnheadersousinymd) {
        zrnheadersousinymd = pZrnheadersousinymd;
    }

    private String zrnheaderdatasyubetu;

    @Column(name=GenZT_LincJyusinRn.ZRNHEADERDATASYUBETU)
    public String getZrnheaderdatasyubetu() {
        return zrnheaderdatasyubetu;
    }

    public void setZrnheaderdatasyubetu(String pZrnheaderdatasyubetu) {
        zrnheaderdatasyubetu = pZrnheaderdatasyubetu;
    }

    private String zrnheaderkaitoukurikosi;

    @Column(name=GenZT_LincJyusinRn.ZRNHEADERKAITOUKURIKOSI)
    public String getZrnheaderkaitoukurikosi() {
        return zrnheaderkaitoukurikosi;
    }

    public void setZrnheaderkaitoukurikosi(String pZrnheaderkaitoukurikosi) {
        zrnheaderkaitoukurikosi = pZrnheaderkaitoukurikosi;
    }

    private String zrnheadersyusindatasyubetu;

    @Column(name=GenZT_LincJyusinRn.ZRNHEADERSYUSINDATASYUBETU)
    public String getZrnheadersyusindatasyubetu() {
        return zrnheadersyusindatasyubetu;
    }

    public void setZrnheadersyusindatasyubetu(String pZrnheadersyusindatasyubetu) {
        zrnheadersyusindatasyubetu = pZrnheadersyusindatasyubetu;
    }

    private String zrnheadersyusincircleno;

    @Column(name=GenZT_LincJyusinRn.ZRNHEADERSYUSINCIRCLENO)
    public String getZrnheadersyusincircleno() {
        return zrnheadersyusincircleno;
    }

    public void setZrnheadersyusincircleno(String pZrnheadersyusincircleno) {
        zrnheadersyusincircleno = pZrnheadersyusincircleno;
    }

    @Id
    @Column(name=GenZT_LincJyusinRn.ZRNSYORIYMD)
    public String getZrnsyoriymd() {
        return getPrimaryKey().getZrnsyoriymd();
    }

    public void setZrnsyoriymd(String pZrnsyoriymd) {
        getPrimaryKey().setZrnsyoriymd(pZrnsyoriymd);
    }

    @Id
    @Column(name=GenZT_LincJyusinRn.ZRNRENNO10)
    public String getZrnrenno10() {
        return getPrimaryKey().getZrnrenno10();
    }

    public void setZrnrenno10(String pZrnrenno10) {
        getPrimaryKey().setZrnrenno10(pZrnrenno10);
    }

    private String zrnyobiv54;

    @Column(name=GenZT_LincJyusinRn.ZRNYOBIV54)
    public String getZrnyobiv54() {
        return zrnyobiv54;
    }

    public void setZrnyobiv54(String pZrnyobiv54) {
        zrnyobiv54 = pZrnyobiv54;
    }

    private String zrndatakbn;

    @Column(name=GenZT_LincJyusinRn.ZRNDATAKBN)
    public String getZrndatakbn() {
        return zrndatakbn;
    }

    public void setZrndatakbn(String pZrndatakbn) {
        zrndatakbn = pZrndatakbn;
    }

    private String zrnrecordsyubetukbn;

    @Column(name=GenZT_LincJyusinRn.ZRNRECORDSYUBETUKBN)
    public String getZrnrecordsyubetukbn() {
        return zrnrecordsyubetukbn;
    }

    public void setZrnrecordsyubetukbn(String pZrnrecordsyubetukbn) {
        zrnrecordsyubetukbn = pZrnrecordsyubetukbn;
    }

    private String zrnhenkoutype;

    @Column(name=GenZT_LincJyusinRn.ZRNHENKOUTYPE)
    public String getZrnhenkoutype() {
        return zrnhenkoutype;
    }

    public void setZrnhenkoutype(String pZrnhenkoutype) {
        zrnhenkoutype = pZrnhenkoutype;
    }

    private String zrnsyorikekkacd;

    @Column(name=GenZT_LincJyusinRn.ZRNSYORIKEKKACD)
    public String getZrnsyorikekkacd() {
        return zrnsyorikekkacd;
    }

    public void setZrnsyorikekkacd(String pZrnsyorikekkacd) {
        zrnsyorikekkacd = pZrnsyorikekkacd;
    }

    private String zrnsyorikekkaerrjiyuu;

    @Column(name=GenZT_LincJyusinRn.ZRNSYORIKEKKAERRJIYUU)
    public String getZrnsyorikekkaerrjiyuu() {
        return zrnsyorikekkaerrjiyuu;
    }

    public void setZrnsyorikekkaerrjiyuu(String pZrnsyorikekkaerrjiyuu) {
        zrnsyorikekkaerrjiyuu = pZrnsyorikekkaerrjiyuu;
    }

    private String zrnsyorikekkaerrno;

    @Column(name=GenZT_LincJyusinRn.ZRNSYORIKEKKAERRNO)
    public String getZrnsyorikekkaerrno() {
        return zrnsyorikekkaerrno;
    }

    public void setZrnsyorikekkaerrno(String pZrnsyorikekkaerrno) {
        zrnsyorikekkaerrno = pZrnsyorikekkaerrno;
    }

    private String zrnnayoserecordsuu;

    @Column(name=GenZT_LincJyusinRn.ZRNNAYOSERECORDSUU)
    public String getZrnnayoserecordsuu() {
        return zrnnayoserecordsuu;
    }

    public void setZrnnayoserecordsuu(String pZrnnayoserecordsuu) {
        zrnnayoserecordsuu = pZrnnayoserecordsuu;
    }

    private String zrnkanyuusyano;

    @Column(name=GenZT_LincJyusinRn.ZRNKANYUUSYANO)
    public String getZrnkanyuusyano() {
        return zrnkanyuusyano;
    }

    public void setZrnkanyuusyano(String pZrnkanyuusyano) {
        zrnkanyuusyano = pZrnkanyuusyano;
    }

    private String zrnkyoukaisiyouknnm;

    @Column(name=GenZT_LincJyusinRn.ZRNKYOUKAISIYOUKNNM)
    public String getZrnkyoukaisiyouknnm() {
        return zrnkyoukaisiyouknnm;
    }

    public void setZrnkyoukaisiyouknnm(String pZrnkyoukaisiyouknnm) {
        zrnkyoukaisiyouknnm = pZrnkyoukaisiyouknnm;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_LincJyusinRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnhhknseiymd;

    @Column(name=GenZT_LincJyusinRn.ZRNHHKNSEIYMD)
    public String getZrnhhknseiymd() {
        return zrnhhknseiymd;
    }

    public void setZrnhhknseiymd(String pZrnhhknseiymd) {
        zrnhhknseiymd = pZrnhhknseiymd;
    }

    private String zrnkykymd;

    @Column(name=GenZT_LincJyusinRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnkyksyhhknsydouituhyouji;

    @Column(name=GenZT_LincJyusinRn.ZRNKYKSYHHKNSYDOUITUHYOUJI)
    public String getZrnkyksyhhknsydouituhyouji() {
        return zrnkyksyhhknsydouituhyouji;
    }

    public void setZrnkyksyhhknsydouituhyouji(String pZrnkyksyhhknsydouituhyouji) {
        zrnkyksyhhknsydouituhyouji = pZrnkyksyhhknsydouituhyouji;
    }

    private String zrnsousinmotokaisyacd;

    @Column(name=GenZT_LincJyusinRn.ZRNSOUSINMOTOKAISYACD)
    public String getZrnsousinmotokaisyacd() {
        return zrnsousinmotokaisyacd;
    }

    public void setZrnsousinmotokaisyacd(String pZrnsousinmotokaisyacd) {
        zrnsousinmotokaisyacd = pZrnsousinmotokaisyacd;
    }

    private String zrnhhknadrkn;

    @Column(name=GenZT_LincJyusinRn.ZRNHHKNADRKN)
    public String getZrnhhknadrkn() {
        return zrnhhknadrkn;
    }

    public void setZrnhhknadrkn(String pZrnhhknadrkn) {
        zrnhhknadrkn = pZrnhhknadrkn;
    }

    private String zrnsiginyuintkykntgkstr;

    @Column(name=GenZT_LincJyusinRn.ZRNSIGINYUINTKYKNTGKSTR)
    public String getZrnsiginyuintkykntgkstr() {
        return zrnsiginyuintkykntgkstr;
    }

    public void setZrnsiginyuintkykntgkstr(String pZrnsiginyuintkykntgkstr) {
        zrnsiginyuintkykntgkstr = pZrnsiginyuintkykntgkstr;
    }

    private String zrnsppinyuintkykntgkstr;

    @Column(name=GenZT_LincJyusinRn.ZRNSPPINYUINTKYKNTGKSTR)
    public String getZrnsppinyuintkykntgkstr() {
        return zrnsppinyuintkykntgkstr;
    }

    public void setZrnsppinyuintkykntgkstr(String pZrnsppinyuintkykntgkstr) {
        zrnsppinyuintkykntgkstr = pZrnsppinyuintkykntgkstr;
    }

    private String zrnsijnbyutkykntgkstr;

    @Column(name=GenZT_LincJyusinRn.ZRNSIJNBYUTKYKNTGKSTR)
    public String getZrnsijnbyutkykntgkstr() {
        return zrnsijnbyutkykntgkstr;
    }

    public void setZrnsijnbyutkykntgkstr(String pZrnsijnbyutkykntgkstr) {
        zrnsijnbyutkykntgkstr = pZrnsijnbyutkykntgkstr;
    }

    private String zrnsonotatokuyakuntgkstr;

    @Column(name=GenZT_LincJyusinRn.ZRNSONOTATOKUYAKUNTGKSTR)
    public String getZrnsonotatokuyakuntgkstr() {
        return zrnsonotatokuyakuntgkstr;
    }

    public void setZrnsonotatokuyakuntgkstr(String pZrnsonotatokuyakuntgkstr) {
        zrnsonotatokuyakuntgkstr = pZrnsonotatokuyakuntgkstr;
    }

    private String zrntrkmousideymd;

    @Column(name=GenZT_LincJyusinRn.ZRNTRKMOUSIDEYMD)
    public String getZrntrkmousideymd() {
        return zrntrkmousideymd;
    }

    public void setZrntrkmousideymd(String pZrntrkmousideymd) {
        zrntrkmousideymd = pZrntrkmousideymd;
    }

    private String zrnlincsyoriymd;

    @Column(name=GenZT_LincJyusinRn.ZRNLINCSYORIYMD)
    public String getZrnlincsyoriymd() {
        return zrnlincsyoriymd;
    }

    public void setZrnlincsyoriymd(String pZrnlincsyoriymd) {
        zrnlincsyoriymd = pZrnlincsyoriymd;
    }

    private String zrnyuyusiyouknnm;

    @Column(name=GenZT_LincJyusinRn.ZRNYUYUSIYOUKNNM)
    public String getZrnyuyusiyouknnm() {
        return zrnyuyusiyouknnm;
    }

    public void setZrnyuyusiyouknnm(String pZrnyuyusiyouknnm) {
        zrnyuyusiyouknnm = pZrnyuyusiyouknnm;
    }

    private String zrnkykkanrino;

    @Column(name=GenZT_LincJyusinRn.ZRNKYKKANRINO)
    public String getZrnkykkanrino() {
        return zrnkykkanrino;
    }

    public void setZrnkykkanrino(String pZrnkykkanrino) {
        zrnkykkanrino = pZrnkykkanrino;
    }

    private String zrnhozenymd;

    @Column(name=GenZT_LincJyusinRn.ZRNHOZENYMD)
    public String getZrnhozenymd() {
        return zrnhozenymd;
    }

    public void setZrnhozenymd(String pZrnhozenymd) {
        zrnhozenymd = pZrnhozenymd;
    }

    private String zrnkykknnm;

    @Column(name=GenZT_LincJyusinRn.ZRNKYKKNNM)
    public String getZrnkykknnm() {
        return zrnkykknnm;
    }

    public void setZrnkykknnm(String pZrnkykknnm) {
        zrnkykknnm = pZrnkykknnm;
    }

    private String zrnhutuusbsstr;

    @Column(name=GenZT_LincJyusinRn.ZRNHUTUUSBSSTR)
    public String getZrnhutuusbsstr() {
        return zrnhutuusbsstr;
    }

    public void setZrnhutuusbsstr(String pZrnhutuusbsstr) {
        zrnhutuusbsstr = pZrnhutuusbsstr;
    }

    private String zrnsgsbstr;

    @Column(name=GenZT_LincJyusinRn.ZRNSGSBSTR)
    public String getZrnsgsbstr() {
        return zrnsgsbstr;
    }

    public void setZrnsgsbstr(String pZrnsgsbstr) {
        zrnsgsbstr = pZrnsgsbstr;
    }

    private String zrnkakusyasiyouran;

    @Column(name=GenZT_LincJyusinRn.ZRNKAKUSYASIYOURAN)
    public String getZrnkakusyasiyouran() {
        return zrnkakusyasiyouran;
    }

    public void setZrnkakusyasiyouran(String pZrnkakusyasiyouran) {
        zrnkakusyasiyouran = pZrnkakusyasiyouran;
    }

    private String zrnmousideflg;

    @Column(name=GenZT_LincJyusinRn.ZRNMOUSIDEFLG)
    public String getZrnmousideflg() {
        return zrnmousideflg;
    }

    public void setZrnmousideflg(String pZrnmousideflg) {
        zrnmousideflg = pZrnmousideflg;
    }

    private String zrnmousideflgsetymd;

    @Column(name=GenZT_LincJyusinRn.ZRNMOUSIDEFLGSETYMD)
    public String getZrnmousideflgsetymd() {
        return zrnmousideflgsetymd;
    }

    public void setZrnmousideflgsetymd(String pZrnmousideflgsetymd) {
        zrnmousideflgsetymd = pZrnmousideflgsetymd;
    }

    private String zrnmousideflgkaijyoymd;

    @Column(name=GenZT_LincJyusinRn.ZRNMOUSIDEFLGKAIJYOYMD)
    public String getZrnmousideflgkaijyoymd() {
        return zrnmousideflgkaijyoymd;
    }

    public void setZrnmousideflgkaijyoymd(String pZrnmousideflgkaijyoymd) {
        zrnmousideflgkaijyoymd = pZrnmousideflgkaijyoymd;
    }

    private String zrnjgyhknflg;

    @Column(name=GenZT_LincJyusinRn.ZRNJGYHKNFLG)
    public String getZrnjgyhknflg() {
        return zrnjgyhknflg;
    }

    public void setZrnjgyhknflg(String pZrnjgyhknflg) {
        zrnjgyhknflg = pZrnjgyhknflg;
    }

    private String zrntnknflg;

    @Column(name=GenZT_LincJyusinRn.ZRNTNKNFLG)
    public String getZrntnknflg() {
        return zrntnknflg;
    }

    public void setZrntnknflg(String pZrntnknflg) {
        zrntnknflg = pZrntnknflg;
    }

    private String zrnkyksyaseikbn;

    @Column(name=GenZT_LincJyusinRn.ZRNKYKSYASEIKBN)
    public String getZrnkyksyaseikbn() {
        return zrnkyksyaseikbn;
    }

    public void setZrnkyksyaseikbn(String pZrnkyksyaseikbn) {
        zrnkyksyaseikbn = pZrnkyksyaseikbn;
    }

    private String zrnkyksyaseiymd;

    @Column(name=GenZT_LincJyusinRn.ZRNKYKSYASEIYMD)
    public String getZrnkyksyaseiymd() {
        return zrnkyksyaseiymd;
    }

    public void setZrnkyksyaseiymd(String pZrnkyksyaseiymd) {
        zrnkyksyaseiymd = pZrnkyksyaseiymd;
    }

    private String zrnkykadrkn;

    @Column(name=GenZT_LincJyusinRn.ZRNKYKADRKN)
    public String getZrnkykadrkn() {
        return zrnkykadrkn;
    }

    public void setZrnkykadrkn(String pZrnkykadrkn) {
        zrnkykadrkn = pZrnkykadrkn;
    }

    private String zrnyobiv17;

    @Column(name=GenZT_LincJyusinRn.ZRNYOBIV17)
    public String getZrnyobiv17() {
        return zrnyobiv17;
    }

    public void setZrnyobiv17(String pZrnyobiv17) {
        zrnyobiv17 = pZrnyobiv17;
    }

    private String zrnknjhhknmei30;

    @Column(name=GenZT_LincJyusinRn.ZRNKNJHHKNMEI30)
    public String getZrnknjhhknmei30() {
        return zrnknjhhknmei30;
    }

    @DataConvert("toMultiByte")
    public void setZrnknjhhknmei30(String pZrnknjhhknmei30) {
        zrnknjhhknmei30 = pZrnknjhhknmei30;
    }

    private String zrnkjkyknm30;

    @Column(name=GenZT_LincJyusinRn.ZRNKJKYKNM30)
    public String getZrnkjkyknm30() {
        return zrnkjkyknm30;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkyknm30(String pZrnkjkyknm30) {
        zrnkjkyknm30 = pZrnkjkyknm30;
    }

    private String zrn15sai1000manflg;

    @Column(name=GenZT_LincJyusinRn.ZRN15SAI1000MANFLG)
    public String getZrn15sai1000manflg() {
        return zrn15sai1000manflg;
    }

    public void setZrn15sai1000manflg(String pZrn15sai1000manflg) {
        zrn15sai1000manflg = pZrn15sai1000manflg;
    }

    private String zrnkjhngflg;

    @Column(name=GenZT_LincJyusinRn.ZRNKJHNGFLG)
    public String getZrnkjhngflg() {
        return zrnkjhngflg;
    }

    public void setZrnkjhngflg(String pZrnkjhngflg) {
        zrnkjhngflg = pZrnkjhngflg;
    }

    private String zrnkykytymd;

    @Column(name=GenZT_LincJyusinRn.ZRNKYKYTYMD)
    public String getZrnkykytymd() {
        return zrnkykytymd;
    }

    public void setZrnkykytymd(String pZrnkykytymd) {
        zrnkykytymd = pZrnkykytymd;
    }

    private String zrnhozenytymd;

    @Column(name=GenZT_LincJyusinRn.ZRNHOZENYTYMD)
    public String getZrnhozenytymd() {
        return zrnhozenytymd;
    }

    public void setZrnhozenytymd(String pZrnhozenytymd) {
        zrnhozenytymd = pZrnhozenytymd;
    }

    private String zrn15mimantkhukaymd;

    @Column(name=GenZT_LincJyusinRn.ZRN15MIMANTKHUKAYMD)
    public String getZrn15mimantkhukaymd() {
        return zrn15mimantkhukaymd;
    }

    public void setZrn15mimantkhukaymd(String pZrn15mimantkhukaymd) {
        zrn15mimantkhukaymd = pZrn15mimantkhukaymd;
    }

    private String zrn15mimantkhukayoteiymd;

    @Column(name=GenZT_LincJyusinRn.ZRN15MIMANTKHUKAYOTEIYMD)
    public String getZrn15mimantkhukayoteiymd() {
        return zrn15mimantkhukayoteiymd;
    }

    public void setZrn15mimantkhukayoteiymd(String pZrn15mimantkhukayoteiymd) {
        zrn15mimantkhukayoteiymd = pZrn15mimantkhukayoteiymd;
    }

    private String zrnyobiv46;

    @Column(name=GenZT_LincJyusinRn.ZRNYOBIV46)
    public String getZrnyobiv46() {
        return zrnyobiv46;
    }

    public void setZrnyobiv46(String pZrnyobiv46) {
        zrnyobiv46 = pZrnyobiv46;
    }
}