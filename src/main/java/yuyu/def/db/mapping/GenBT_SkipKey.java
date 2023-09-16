package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.id.PKBT_SkipKey;
import yuyu.def.db.meta.GenQBT_SkipKey;
import yuyu.def.db.meta.QBT_SkipKey;

/**
 * スキップキーテーブル テーブルのマッピング情報クラスで、 {@link BT_SkipKey} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_SkipKey}</td><td colspan="3">スキップキーテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getRecoverysikibetukey recoverysikibetukey}</td><td>リカバリ識別キー</td><td align="center">{@link PKBT_SkipKey ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKakutyoujobcd kakutyoujobcd}</td><td>拡張ジョブコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTableid tableid}</td><td>テーブルＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRecoveryfilterid recoveryfilterid}</td><td>リカバリフィルタＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRecoveryfilterkey1 recoveryfilterkey1}</td><td>リカバリフィルタキー１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRecoveryfilterkey2 recoveryfilterkey2}</td><td>リカバリフィルタキー２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRecoveryfilterkey3 recoveryfilterkey3}</td><td>リカバリフィルタキー３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRecoveryfilterkey4 recoveryfilterkey4}</td><td>リカバリフィルタキー４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRecoveryfilterkey5 recoveryfilterkey5}</td><td>リカバリフィルタキー５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_SkipKey
 * @see     PKBT_SkipKey
 * @see     QBT_SkipKey
 * @see     GenQBT_SkipKey
 */
@MappedSuperclass
@Table(name=GenBT_SkipKey.TABLE_NAME)
@IdClass(value=PKBT_SkipKey.class)
public abstract class GenBT_SkipKey extends AbstractExDBEntity<BT_SkipKey, PKBT_SkipKey> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_SkipKey";
    public static final String RECOVERYSIKIBETUKEY      = "recoverysikibetukey";
    public static final String KAKUTYOUJOBCD            = "kakutyoujobcd";
    public static final String TABLEID                  = "tableid";
    public static final String RECOVERYFILTERID         = "recoveryfilterid";
    public static final String RECOVERYFILTERKEY1       = "recoveryfilterkey1";
    public static final String RECOVERYFILTERKEY2       = "recoveryfilterkey2";
    public static final String RECOVERYFILTERKEY3       = "recoveryfilterkey3";
    public static final String RECOVERYFILTERKEY4       = "recoveryfilterkey4";
    public static final String RECOVERYFILTERKEY5       = "recoveryfilterkey5";

    private final PKBT_SkipKey primaryKey;

    public GenBT_SkipKey() {
        primaryKey = new PKBT_SkipKey();
    }

    public GenBT_SkipKey(String pRecoverysikibetukey) {
        primaryKey = new PKBT_SkipKey(pRecoverysikibetukey);
    }

    @Transient
    @Override
    public PKBT_SkipKey getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_SkipKey> getMetaClass() {
        return QBT_SkipKey.class;
    }

    @Id
    @Column(name=GenBT_SkipKey.RECOVERYSIKIBETUKEY)
    public String getRecoverysikibetukey() {
        return getPrimaryKey().getRecoverysikibetukey();
    }

    public void setRecoverysikibetukey(String pRecoverysikibetukey) {
        getPrimaryKey().setRecoverysikibetukey(pRecoverysikibetukey);
    }

    private String kakutyoujobcd;

    @Column(name=GenBT_SkipKey.KAKUTYOUJOBCD)
    public String getKakutyoujobcd() {
        return kakutyoujobcd;
    }

    public void setKakutyoujobcd(String pKakutyoujobcd) {
        kakutyoujobcd = pKakutyoujobcd;
    }

    private String tableid;

    @Column(name=GenBT_SkipKey.TABLEID)
    public String getTableid() {
        return tableid;
    }

    public void setTableid(String pTableid) {
        tableid = pTableid;
    }

    private String recoveryfilterid;

    @Column(name=GenBT_SkipKey.RECOVERYFILTERID)
    public String getRecoveryfilterid() {
        return recoveryfilterid;
    }

    public void setRecoveryfilterid(String pRecoveryfilterid) {
        recoveryfilterid = pRecoveryfilterid;
    }

    private String recoveryfilterkey1;

    @Column(name=GenBT_SkipKey.RECOVERYFILTERKEY1)
    public String getRecoveryfilterkey1() {
        return recoveryfilterkey1;
    }

    public void setRecoveryfilterkey1(String pRecoveryfilterkey1) {
        recoveryfilterkey1 = pRecoveryfilterkey1;
    }

    private String recoveryfilterkey2;

    @Column(name=GenBT_SkipKey.RECOVERYFILTERKEY2)
    public String getRecoveryfilterkey2() {
        return recoveryfilterkey2;
    }

    public void setRecoveryfilterkey2(String pRecoveryfilterkey2) {
        recoveryfilterkey2 = pRecoveryfilterkey2;
    }

    private String recoveryfilterkey3;

    @Column(name=GenBT_SkipKey.RECOVERYFILTERKEY3)
    public String getRecoveryfilterkey3() {
        return recoveryfilterkey3;
    }

    public void setRecoveryfilterkey3(String pRecoveryfilterkey3) {
        recoveryfilterkey3 = pRecoveryfilterkey3;
    }

    private String recoveryfilterkey4;

    @Column(name=GenBT_SkipKey.RECOVERYFILTERKEY4)
    public String getRecoveryfilterkey4() {
        return recoveryfilterkey4;
    }

    public void setRecoveryfilterkey4(String pRecoveryfilterkey4) {
        recoveryfilterkey4 = pRecoveryfilterkey4;
    }

    private String recoveryfilterkey5;

    @Column(name=GenBT_SkipKey.RECOVERYFILTERKEY5)
    public String getRecoveryfilterkey5() {
        return recoveryfilterkey5;
    }

    public void setRecoveryfilterkey5(String pRecoveryfilterkey5) {
        recoveryfilterkey5 = pRecoveryfilterkey5;
    }
}
