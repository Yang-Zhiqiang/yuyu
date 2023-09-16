package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BT_GkFBSoukinHukaInfo;
import yuyu.def.db.mapping.GenBT_GkFBSoukinHukaInfo;
import yuyu.def.db.meta.GenQBT_GkFBSoukinHukaInfo;
import yuyu.def.db.meta.QBT_GkFBSoukinHukaInfo;

/**
 * 外貨ＦＢ送金付加情報データテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_GkFBSoukinHukaInfo}</td><td colspan="3">外貨ＦＢ送金付加情報データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getFbsoukindatasikibetukey fbsoukindatasikibetukey}</td><td>ＦＢ送金データ識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>fbtrhksyoukaino</td><td>ＦＢ取引先照会番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dengk</td><td>伝票金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BT_GkFBSoukinHukaInfo
 * @see     GenBT_GkFBSoukinHukaInfo
 * @see     QBT_GkFBSoukinHukaInfo
 * @see     GenQBT_GkFBSoukinHukaInfo
 */
public class PKBT_GkFBSoukinHukaInfo extends AbstractExDBPrimaryKey<BT_GkFBSoukinHukaInfo, PKBT_GkFBSoukinHukaInfo> {

    private static final long serialVersionUID = 1L;

    public PKBT_GkFBSoukinHukaInfo() {
    }

    public PKBT_GkFBSoukinHukaInfo(String pFbsoukindatasikibetukey) {
        fbsoukindatasikibetukey = pFbsoukindatasikibetukey;
    }

    @Transient
    @Override
    public Class<BT_GkFBSoukinHukaInfo> getEntityClass() {
        return BT_GkFBSoukinHukaInfo.class;
    }

    private String fbsoukindatasikibetukey;

    public String getFbsoukindatasikibetukey() {
        return fbsoukindatasikibetukey;
    }

    public void setFbsoukindatasikibetukey(String pFbsoukindatasikibetukey) {
        fbsoukindatasikibetukey = pFbsoukindatasikibetukey;
    }

}