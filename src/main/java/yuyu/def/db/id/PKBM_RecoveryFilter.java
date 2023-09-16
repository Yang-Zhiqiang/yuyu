package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.mapping.GenBM_RecoveryFilter;
import yuyu.def.db.meta.GenQBM_RecoveryFilter;
import yuyu.def.db.meta.QBM_RecoveryFilter;

/**
 * リカバリフィルタマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_RecoveryFilter}</td><td colspan="3">リカバリフィルタマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getRecoveryfilterid recoveryfilterid}</td><td>リカバリフィルタＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>recoveryfilternm</td><td>リカバリフィルタ名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>recoveryfilterkeykmid1</td><td>リカバリフィルタキー項目ＩＤ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>recoveryfilterkeykmid2</td><td>リカバリフィルタキー項目ＩＤ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>recoveryfilterkeykmid3</td><td>リカバリフィルタキー項目ＩＤ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>recoveryfilterkeykmid4</td><td>リカバリフィルタキー項目ＩＤ４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>recoveryfilterkeykmid5</td><td>リカバリフィルタキー項目ＩＤ５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_RecoveryFilter
 * @see     GenBM_RecoveryFilter
 * @see     QBM_RecoveryFilter
 * @see     GenQBM_RecoveryFilter
 */
public class PKBM_RecoveryFilter extends AbstractExDBPrimaryKey<BM_RecoveryFilter, PKBM_RecoveryFilter> {

    private static final long serialVersionUID = 1L;

    public PKBM_RecoveryFilter() {
    }

    public PKBM_RecoveryFilter(String pRecoveryfilterid) {
        recoveryfilterid = pRecoveryfilterid;
    }

    @Transient
    @Override
    public Class<BM_RecoveryFilter> getEntityClass() {
        return BM_RecoveryFilter.class;
    }

    private String recoveryfilterid;

    public String getRecoveryfilterid() {
        return recoveryfilterid;
    }

    public void setRecoveryfilterid(String pRecoveryfilterid) {
        recoveryfilterid = pRecoveryfilterid;
    }

}