package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_FileSansyoKaisu;
import yuyu.def.db.mapping.GenAT_FileSansyoKaisu;
import yuyu.def.db.meta.GenQAT_FileSansyoKaisu;
import yuyu.def.db.meta.QAT_FileSansyoKaisu;

/**
 * ファイル参照回数テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_FileSansyoKaisu}</td><td colspan="3">ファイル参照回数テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getUniqueId uniqueId}</td><td>ユニークＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sansyoucount</td><td>参照回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     AT_FileSansyoKaisu
 * @see     GenAT_FileSansyoKaisu
 * @see     QAT_FileSansyoKaisu
 * @see     GenQAT_FileSansyoKaisu
 */
public class PKAT_FileSansyoKaisu extends AbstractExDBPrimaryKey<AT_FileSansyoKaisu, PKAT_FileSansyoKaisu> {

    private static final long serialVersionUID = 1L;

    public PKAT_FileSansyoKaisu() {
    }

    public PKAT_FileSansyoKaisu(String pUniqueId) {
        uniqueId = pUniqueId;
    }

    @Transient
    @Override
    public Class<AT_FileSansyoKaisu> getEntityClass() {
        return AT_FileSansyoKaisu.class;
    }

    private String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String pUniqueId) {
        uniqueId = pUniqueId;
    }

}