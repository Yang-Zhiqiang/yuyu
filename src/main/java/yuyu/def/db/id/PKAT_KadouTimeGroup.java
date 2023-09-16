package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.AT_KadouTimeGroup;
import yuyu.def.db.mapping.GenAT_KadouTimeGroup;
import yuyu.def.db.meta.GenQAT_KadouTimeGroup;
import yuyu.def.db.meta.QAT_KadouTimeGroup;

/**
 * 稼働時間グループテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_KadouTimeGroup}</td><td colspan="3">稼働時間グループテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKadouTimeGroupCd kadouTimeGroupCd}</td><td>稼働時間グループコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kadouTimeGroupNm</td><td>稼働時間グループ名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kadouTimeGroupDescription</td><td>稼働時間グループ備考</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>holidayGroupCd</td><td>休日グループコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_KadouTimeGroup
 * @see     GenAT_KadouTimeGroup
 * @see     QAT_KadouTimeGroup
 * @see     GenQAT_KadouTimeGroup
 */
public class PKAT_KadouTimeGroup extends AbstractExDBPrimaryKey<AT_KadouTimeGroup, PKAT_KadouTimeGroup> {

    private static final long serialVersionUID = 1L;

    public PKAT_KadouTimeGroup() {
    }

    public PKAT_KadouTimeGroup(String pKadouTimeGroupCd) {
        kadouTimeGroupCd = pKadouTimeGroupCd;
    }

    @Transient
    @Override
    public Class<AT_KadouTimeGroup> getEntityClass() {
        return AT_KadouTimeGroup.class;
    }

    private String kadouTimeGroupCd;

    public String getKadouTimeGroupCd() {
        return kadouTimeGroupCd;
    }

    public void setKadouTimeGroupCd(String pKadouTimeGroupCd) {
        kadouTimeGroupCd = pKadouTimeGroupCd;
    }

}