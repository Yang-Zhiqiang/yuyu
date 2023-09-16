package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.HT_BosKoumokuCheckError;
import yuyu.def.db.id.PKHT_BosKoumokuCheckError;
import yuyu.def.db.meta.GenQHT_BosKoumokuCheckError;
import yuyu.def.db.meta.QHT_BosKoumokuCheckError;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 募集項目チェックエラーテーブル テーブルのマッピング情報クラスで、 {@link HT_BosKoumokuCheckError} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_BosKoumokuCheckError}</td><td colspan="3">募集項目チェックエラーテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_BosKoumokuCheckError ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKHT_BosKoumokuCheckError ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getErrorkm errorkm}</td><td>エラー項目</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_BosKoumokuCheckError
 * @see     PKHT_BosKoumokuCheckError
 * @see     QHT_BosKoumokuCheckError
 * @see     GenQHT_BosKoumokuCheckError
 */
@MappedSuperclass
@Table(name=GenHT_BosKoumokuCheckError.TABLE_NAME)
@IdClass(value=PKHT_BosKoumokuCheckError.class)
public abstract class GenHT_BosKoumokuCheckError extends AbstractExDBEntity<HT_BosKoumokuCheckError, PKHT_BosKoumokuCheckError> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_BosKoumokuCheckError";
    public static final String MOSNO                    = "mosno";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String ERRORKM                  = "errorkm";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_BosKoumokuCheckError primaryKey;

    public GenHT_BosKoumokuCheckError() {
        primaryKey = new PKHT_BosKoumokuCheckError();
    }

    public GenHT_BosKoumokuCheckError(String pMosno, Integer pRenno3keta) {
        primaryKey = new PKHT_BosKoumokuCheckError(pMosno, pRenno3keta);
    }

    @Transient
    @Override
    public PKHT_BosKoumokuCheckError getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_BosKoumokuCheckError> getMetaClass() {
        return QHT_BosKoumokuCheckError.class;
    }

    @Id
    @Column(name=GenHT_BosKoumokuCheckError.MOSNO)
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
    @Column(name=GenHT_BosKoumokuCheckError.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private String errorkm;

    @Column(name=GenHT_BosKoumokuCheckError.ERRORKM)
    public String getErrorkm() {
        return errorkm;
    }

    public void setErrorkm(String pErrorkm) {
        errorkm = pErrorkm;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_BosKoumokuCheckError.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}