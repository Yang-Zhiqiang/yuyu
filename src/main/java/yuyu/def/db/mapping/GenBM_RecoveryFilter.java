package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.id.PKBM_RecoveryFilter;
import yuyu.def.db.meta.GenQBM_RecoveryFilter;
import yuyu.def.db.meta.QBM_RecoveryFilter;

/**
 * リカバリフィルタマスタ テーブルのマッピング情報クラスで、 {@link BM_RecoveryFilter} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_RecoveryFilter}</td><td colspan="3">リカバリフィルタマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getRecoveryfilterid recoveryfilterid}</td><td>リカバリフィルタＩＤ</td><td align="center">{@link PKBM_RecoveryFilter ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRecoveryfilternm recoveryfilternm}</td><td>リカバリフィルタ名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRecoveryfilterkeykmid1 recoveryfilterkeykmid1}</td><td>リカバリフィルタキー項目ＩＤ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRecoveryfilterkeykmid2 recoveryfilterkeykmid2}</td><td>リカバリフィルタキー項目ＩＤ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRecoveryfilterkeykmid3 recoveryfilterkeykmid3}</td><td>リカバリフィルタキー項目ＩＤ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRecoveryfilterkeykmid4 recoveryfilterkeykmid4}</td><td>リカバリフィルタキー項目ＩＤ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRecoveryfilterkeykmid5 recoveryfilterkeykmid5}</td><td>リカバリフィルタキー項目ＩＤ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_RecoveryFilter
 * @see     PKBM_RecoveryFilter
 * @see     QBM_RecoveryFilter
 * @see     GenQBM_RecoveryFilter
 */
@MappedSuperclass
@Table(name=GenBM_RecoveryFilter.TABLE_NAME)
@IdClass(value=PKBM_RecoveryFilter.class)
public abstract class GenBM_RecoveryFilter extends AbstractExDBEntity<BM_RecoveryFilter, PKBM_RecoveryFilter> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_RecoveryFilter";
    public static final String RECOVERYFILTERID         = "recoveryfilterid";
    public static final String RECOVERYFILTERNM         = "recoveryfilternm";
    public static final String RECOVERYFILTERKEYKMID1   = "recoveryfilterkeykmid1";
    public static final String RECOVERYFILTERKEYKMID2   = "recoveryfilterkeykmid2";
    public static final String RECOVERYFILTERKEYKMID3   = "recoveryfilterkeykmid3";
    public static final String RECOVERYFILTERKEYKMID4   = "recoveryfilterkeykmid4";
    public static final String RECOVERYFILTERKEYKMID5   = "recoveryfilterkeykmid5";

    private final PKBM_RecoveryFilter primaryKey;

    public GenBM_RecoveryFilter() {
        primaryKey = new PKBM_RecoveryFilter();
    }

    public GenBM_RecoveryFilter(String pRecoveryfilterid) {
        primaryKey = new PKBM_RecoveryFilter(pRecoveryfilterid);
    }

    @Transient
    @Override
    public PKBM_RecoveryFilter getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_RecoveryFilter> getMetaClass() {
        return QBM_RecoveryFilter.class;
    }

    @Id
    @Column(name=GenBM_RecoveryFilter.RECOVERYFILTERID)
    public String getRecoveryfilterid() {
        return getPrimaryKey().getRecoveryfilterid();
    }

    public void setRecoveryfilterid(String pRecoveryfilterid) {
        getPrimaryKey().setRecoveryfilterid(pRecoveryfilterid);
    }

    private String recoveryfilternm;

    @Column(name=GenBM_RecoveryFilter.RECOVERYFILTERNM)
    public String getRecoveryfilternm() {
        return recoveryfilternm;
    }

    public void setRecoveryfilternm(String pRecoveryfilternm) {
        recoveryfilternm = pRecoveryfilternm;
    }

    private String recoveryfilterkeykmid1;

    @Column(name=GenBM_RecoveryFilter.RECOVERYFILTERKEYKMID1)
    public String getRecoveryfilterkeykmid1() {
        return recoveryfilterkeykmid1;
    }

    public void setRecoveryfilterkeykmid1(String pRecoveryfilterkeykmid1) {
        recoveryfilterkeykmid1 = pRecoveryfilterkeykmid1;
    }

    private String recoveryfilterkeykmid2;

    @Column(name=GenBM_RecoveryFilter.RECOVERYFILTERKEYKMID2)
    public String getRecoveryfilterkeykmid2() {
        return recoveryfilterkeykmid2;
    }

    public void setRecoveryfilterkeykmid2(String pRecoveryfilterkeykmid2) {
        recoveryfilterkeykmid2 = pRecoveryfilterkeykmid2;
    }

    private String recoveryfilterkeykmid3;

    @Column(name=GenBM_RecoveryFilter.RECOVERYFILTERKEYKMID3)
    public String getRecoveryfilterkeykmid3() {
        return recoveryfilterkeykmid3;
    }

    public void setRecoveryfilterkeykmid3(String pRecoveryfilterkeykmid3) {
        recoveryfilterkeykmid3 = pRecoveryfilterkeykmid3;
    }

    private String recoveryfilterkeykmid4;

    @Column(name=GenBM_RecoveryFilter.RECOVERYFILTERKEYKMID4)
    public String getRecoveryfilterkeykmid4() {
        return recoveryfilterkeykmid4;
    }

    public void setRecoveryfilterkeykmid4(String pRecoveryfilterkeykmid4) {
        recoveryfilterkeykmid4 = pRecoveryfilterkeykmid4;
    }

    private String recoveryfilterkeykmid5;

    @Column(name=GenBM_RecoveryFilter.RECOVERYFILTERKEYKMID5)
    public String getRecoveryfilterkeykmid5() {
        return recoveryfilterkeykmid5;
    }

    public void setRecoveryfilterkeykmid5(String pRecoveryfilterkeykmid5) {
        recoveryfilterkeykmid5 = pRecoveryfilterkeykmid5;
    }
}
