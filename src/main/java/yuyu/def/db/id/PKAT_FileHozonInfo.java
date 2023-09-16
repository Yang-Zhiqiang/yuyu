package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_FileHozonInfo;
import yuyu.def.db.mapping.GenAT_FileHozonInfo;
import yuyu.def.db.meta.GenQAT_FileHozonInfo;
import yuyu.def.db.meta.QAT_FileHozonInfo;

/**
 * ファイル保存情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_FileHozonInfo}</td><td colspan="3">ファイル保存情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getUniqueId uniqueId}</td><td>ユニークＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>fileNm</td><td>ファイル名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>fileSyuruiCd</td><td>ファイル種類コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_FileSyuruiCdKbn C_FileSyuruiCdKbn}</td></tr>
 *  <tr><td>fileStatusKbn</td><td>ファイルステータス区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_FileStatusKbn C_FileStatusKbn}</td></tr>
 *  <tr><td>haitaKey</td><td>排他キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tourokuTime</td><td>登録時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sakuseiKinouId</td><td>作成機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_FileHozonInfo
 * @see     GenAT_FileHozonInfo
 * @see     QAT_FileHozonInfo
 * @see     GenQAT_FileHozonInfo
 */
public class PKAT_FileHozonInfo extends AbstractExDBPrimaryKey<AT_FileHozonInfo, PKAT_FileHozonInfo> {

    private static final long serialVersionUID = 1L;

    public PKAT_FileHozonInfo() {
    }

    public PKAT_FileHozonInfo(String pUniqueId) {
        uniqueId = pUniqueId;
    }

    @Transient
    @Override
    public Class<AT_FileHozonInfo> getEntityClass() {
        return AT_FileHozonInfo.class;
    }

    private String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String pUniqueId) {
        uniqueId = pUniqueId;
    }

}