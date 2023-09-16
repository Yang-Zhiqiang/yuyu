package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AS_Sequence;
import yuyu.def.db.mapping.GenAS_Sequence;
import yuyu.def.db.meta.GenQAS_Sequence;
import yuyu.def.db.meta.QAS_Sequence;

/**
 * 連番管理基幹テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_Sequence}</td><td colspan="3">連番管理基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getId id}</td><td>ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>name</td><td>名前</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>startWith</td><td>初期値</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>increase</td><td>増分値</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>maxValue</td><td>最大値</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>cacheSize</td><td>キャッシュサイズ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>padding</td><td>ゼロパディング有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>length</td><td>桁数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     AS_Sequence
 * @see     GenAS_Sequence
 * @see     QAS_Sequence
 * @see     GenQAS_Sequence
 */
public class PKAS_Sequence extends AbstractExDBPrimaryKey<AS_Sequence, PKAS_Sequence> {

    private static final long serialVersionUID = 1L;

    public PKAS_Sequence() {
    }

    public PKAS_Sequence(String pId) {
        id = pId;
    }

    @Transient
    @Override
    public Class<AS_Sequence> getEntityClass() {
        return AS_Sequence.class;
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String pId) {
        id = pId;
    }

}