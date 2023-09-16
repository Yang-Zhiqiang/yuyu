package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BT_TestKykData;
import yuyu.def.db.mapping.GenBT_TestKykData;
import yuyu.def.db.meta.GenQBT_TestKykData;
import yuyu.def.db.meta.QBT_TestKykData;

/**
 * テスト用契約データ抽出テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_TestKykData}</td><td colspan="3">テスト用契約データ抽出テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getUniqueId uniqueId}</td><td>ユニークＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>fileNm</td><td>ファイル名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>testfilecontents</td><td>テスト用ファイル内容</td><td>&nbsp;</td><td align="center">BLOB</td><td>byte[]</td></tr>
 * </table>
 * @see     BT_TestKykData
 * @see     GenBT_TestKykData
 * @see     QBT_TestKykData
 * @see     GenQBT_TestKykData
 */
public class PKBT_TestKykData extends AbstractExDBPrimaryKey<BT_TestKykData, PKBT_TestKykData> {

    private static final long serialVersionUID = 1L;

    public PKBT_TestKykData() {
    }

    public PKBT_TestKykData(String pUniqueId) {
        uniqueId = pUniqueId;
    }

    @Transient
    @Override
    public Class<BT_TestKykData> getEntityClass() {
        return BT_TestKykData.class;
    }

    private String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String pUniqueId) {
        uniqueId = pUniqueId;
    }

}