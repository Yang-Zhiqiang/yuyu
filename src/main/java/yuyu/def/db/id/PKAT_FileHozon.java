package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_FileHozon;
import yuyu.def.db.mapping.GenAT_FileHozon;
import yuyu.def.db.meta.GenQAT_FileHozon;
import yuyu.def.db.meta.QAT_FileHozon;

/**
 * ファイル保存テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_FileHozon}</td><td colspan="3">ファイル保存テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getUniqueId uniqueId}</td><td>ユニークＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>fileContents</td><td>ファイル内容</td><td>&nbsp;</td><td align="center">BLOB</td><td>byte[]</td></tr>
 * </table>
 * @see     AT_FileHozon
 * @see     GenAT_FileHozon
 * @see     QAT_FileHozon
 * @see     GenQAT_FileHozon
 */
public class PKAT_FileHozon extends AbstractExDBPrimaryKey<AT_FileHozon, PKAT_FileHozon> {

    private static final long serialVersionUID = 1L;

    public PKAT_FileHozon() {
    }

    public PKAT_FileHozon(String pUniqueId) {
        uniqueId = pUniqueId;
    }

    @Transient
    @Override
    public Class<AT_FileHozon> getEntityClass() {
        return AT_FileHozon.class;
    }

    private String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String pUniqueId) {
        uniqueId = pUniqueId;
    }

}