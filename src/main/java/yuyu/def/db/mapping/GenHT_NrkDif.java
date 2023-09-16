package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.HT_NrkDif;
import yuyu.def.db.id.PKHT_NrkDif;
import yuyu.def.db.meta.GenQHT_NrkDif;
import yuyu.def.db.meta.QHT_NrkDif;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 入力差異テーブル テーブルのマッピング情報クラスで、 {@link HT_NrkDif} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_NrkDif}</td><td colspan="3">入力差異テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_NrkDif ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getVrfkinouid vrfkinouid}</td><td>ベリファイ機能ID</td><td align="center">{@link PKHT_NrkDif ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKHT_NrkDif ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNrksouikm nrksouikm}</td><td>入力相違項目</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getItijinyuuroku itijinyuuroku}</td><td>１次入力</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNijinyrk nijinyrk}</td><td>２次入力</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_NrkDif
 * @see     PKHT_NrkDif
 * @see     QHT_NrkDif
 * @see     GenQHT_NrkDif
 */
@MappedSuperclass
@Table(name=GenHT_NrkDif.TABLE_NAME)
@IdClass(value=PKHT_NrkDif.class)
public abstract class GenHT_NrkDif extends AbstractExDBEntity<HT_NrkDif, PKHT_NrkDif> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_NrkDif";
    public static final String MOSNO                    = "mosno";
    public static final String VRFKINOUID               = "vrfkinouid";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String NRKSOUIKM                = "nrksouikm";
    public static final String ITIJINYUUROKU            = "itijinyuuroku";
    public static final String NIJINYRK                 = "nijinyrk";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_NrkDif primaryKey;

    public GenHT_NrkDif() {
        primaryKey = new PKHT_NrkDif();
    }

    public GenHT_NrkDif(
        String pMosno,
        String pVrfkinouid,
        Integer pRenno3keta
    ) {
        primaryKey = new PKHT_NrkDif(
            pMosno,
            pVrfkinouid,
            pRenno3keta
        );
    }

    @Transient
    @Override
    public PKHT_NrkDif getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_NrkDif> getMetaClass() {
        return QHT_NrkDif.class;
    }

    @Id
    @Column(name=GenHT_NrkDif.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    @Id
    @Column(name=GenHT_NrkDif.VRFKINOUID)
    public String getVrfkinouid() {
        return getPrimaryKey().getVrfkinouid();
    }

    public void setVrfkinouid(String pVrfkinouid) {
        getPrimaryKey().setVrfkinouid(pVrfkinouid);
    }

    @Id
    @Column(name=GenHT_NrkDif.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private String nrksouikm;

    @Column(name=GenHT_NrkDif.NRKSOUIKM)
    public String getNrksouikm() {
        return nrksouikm;
    }

    public void setNrksouikm(String pNrksouikm) {
        nrksouikm = pNrksouikm;
    }

    private String itijinyuuroku;

    @Column(name=GenHT_NrkDif.ITIJINYUUROKU)
    public String getItijinyuuroku() {
        return itijinyuuroku;
    }

    public void setItijinyuuroku(String pItijinyuuroku) {
        itijinyuuroku = pItijinyuuroku;
    }

    private String nijinyrk;

    @Column(name=GenHT_NrkDif.NIJINYRK)
    public String getNijinyrk() {
        return nijinyrk;
    }

    public void setNijinyrk(String pNijinyrk) {
        nijinyrk = pNijinyrk;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_NrkDif.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_NrkDif.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}