package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.BT_FBSoukinHukaInfo;
import yuyu.def.db.id.PKBT_FBSoukinHukaInfo;
import yuyu.def.db.meta.GenQBT_FBSoukinHukaInfo;
import yuyu.def.db.meta.QBT_FBSoukinHukaInfo;

/**
 * ＦＢ送金付加情報データテーブル テーブルのマッピング情報クラスで、 {@link BT_FBSoukinHukaInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_FBSoukinHukaInfo}</td><td colspan="3">ＦＢ送金付加情報データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getFbsoukindatasikibetukey fbsoukindatasikibetukey}</td><td>ＦＢ送金データ識別キー</td><td align="center">{@link PKBT_FBSoukinHukaInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKokcd1 kokcd1}</td><td>顧客コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_FBSoukinHukaInfo
 * @see     PKBT_FBSoukinHukaInfo
 * @see     QBT_FBSoukinHukaInfo
 * @see     GenQBT_FBSoukinHukaInfo
 */
@MappedSuperclass
@Table(name=GenBT_FBSoukinHukaInfo.TABLE_NAME)
@IdClass(value=PKBT_FBSoukinHukaInfo.class)
public abstract class GenBT_FBSoukinHukaInfo extends AbstractExDBEntity<BT_FBSoukinHukaInfo, PKBT_FBSoukinHukaInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_FBSoukinHukaInfo";
    public static final String FBSOUKINDATASIKIBETUKEY  = "fbsoukindatasikibetukey";
    public static final String KOKCD1                   = "kokcd1";

    private final PKBT_FBSoukinHukaInfo primaryKey;

    public GenBT_FBSoukinHukaInfo() {
        primaryKey = new PKBT_FBSoukinHukaInfo();
    }

    public GenBT_FBSoukinHukaInfo(String pFbsoukindatasikibetukey) {
        primaryKey = new PKBT_FBSoukinHukaInfo(pFbsoukindatasikibetukey);
    }

    @Transient
    @Override
    public PKBT_FBSoukinHukaInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_FBSoukinHukaInfo> getMetaClass() {
        return QBT_FBSoukinHukaInfo.class;
    }

    @Id
    @Column(name=GenBT_FBSoukinHukaInfo.FBSOUKINDATASIKIBETUKEY)
    public String getFbsoukindatasikibetukey() {
        return getPrimaryKey().getFbsoukindatasikibetukey();
    }

    public void setFbsoukindatasikibetukey(String pFbsoukindatasikibetukey) {
        getPrimaryKey().setFbsoukindatasikibetukey(pFbsoukindatasikibetukey);
    }

    private String kokcd1;

    @Column(name=GenBT_FBSoukinHukaInfo.KOKCD1)
    public String getKokcd1() {
        return kokcd1;
    }

    public void setKokcd1(String pKokcd1) {
        kokcd1 = pKokcd1;
    }
}
