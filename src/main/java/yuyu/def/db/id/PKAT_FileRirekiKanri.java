package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_FileRirekiKanri;
import yuyu.def.db.mapping.GenAT_FileRirekiKanri;
import yuyu.def.db.meta.GenQAT_FileRirekiKanri;
import yuyu.def.db.meta.QAT_FileRirekiKanri;

/**
 * ファイル履歴管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_FileRirekiKanri}</td><td colspan="3">ファイル履歴管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHistoryId historyId}</td><td>履歴ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hozonHousiki</td><td>保存方式</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HozonHousiki C_HozonHousiki}</td></tr>
 *  <tr><td>hozonSaki</td><td>保存先</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>namingPattern</td><td>ネーミングパターン</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rirekiSakujyoJyouken</td><td>履歴削除条件</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_FileRirekiKanri
 * @see     GenAT_FileRirekiKanri
 * @see     QAT_FileRirekiKanri
 * @see     GenQAT_FileRirekiKanri
 */
public class PKAT_FileRirekiKanri extends AbstractExDBPrimaryKey<AT_FileRirekiKanri, PKAT_FileRirekiKanri> {

    private static final long serialVersionUID = 1L;

    public PKAT_FileRirekiKanri() {
    }

    public PKAT_FileRirekiKanri(String pHistoryId) {
        historyId = pHistoryId;
    }

    @Transient
    @Override
    public Class<AT_FileRirekiKanri> getEntityClass() {
        return AT_FileRirekiKanri.class;
    }

    private String historyId;

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String pHistoryId) {
        historyId = pHistoryId;
    }

}