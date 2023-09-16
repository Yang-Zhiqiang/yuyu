package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BT_FBSoukinHukaInfo;
import yuyu.def.db.mapping.GenBT_FBSoukinHukaInfo;
import yuyu.def.db.meta.GenQBT_FBSoukinHukaInfo;
import yuyu.def.db.meta.QBT_FBSoukinHukaInfo;

/**
 * ＦＢ送金付加情報データテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_FBSoukinHukaInfo}</td><td colspan="3">ＦＢ送金付加情報データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getFbsoukindatasikibetukey fbsoukindatasikibetukey}</td><td>ＦＢ送金データ識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kokcd1</td><td>顧客コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_FBSoukinHukaInfo
 * @see     GenBT_FBSoukinHukaInfo
 * @see     QBT_FBSoukinHukaInfo
 * @see     GenQBT_FBSoukinHukaInfo
 */
public class PKBT_FBSoukinHukaInfo extends AbstractExDBPrimaryKey<BT_FBSoukinHukaInfo, PKBT_FBSoukinHukaInfo> {

    private static final long serialVersionUID = 1L;

    public PKBT_FBSoukinHukaInfo() {
    }

    public PKBT_FBSoukinHukaInfo(String pFbsoukindatasikibetukey) {
        fbsoukindatasikibetukey = pFbsoukindatasikibetukey;
    }

    @Transient
    @Override
    public Class<BT_FBSoukinHukaInfo> getEntityClass() {
        return BT_FBSoukinHukaInfo.class;
    }

    private String fbsoukindatasikibetukey;

    public String getFbsoukindatasikibetukey() {
        return fbsoukindatasikibetukey;
    }

    public void setFbsoukindatasikibetukey(String pFbsoukindatasikibetukey) {
        fbsoukindatasikibetukey = pFbsoukindatasikibetukey;
    }

}