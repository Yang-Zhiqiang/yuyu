package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.def.db.mapping.GenAT_HolidayGroup;
import yuyu.def.db.meta.GenQAT_HolidayGroup;
import yuyu.def.db.meta.QAT_HolidayGroup;

/**
 * 休日グループテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_HolidayGroup}</td><td colspan="3">休日グループテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHolidayGroupCd holidayGroupCd}</td><td>休日グループコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>holidayGroupNm</td><td>休日グループ名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>holidayGroupDescription</td><td>休日グループ備考</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sysSiyouKbn</td><td>システム使用区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SysSiyouKbn C_SysSiyouKbn}</td></tr>
 * </table>
 * @see     AT_HolidayGroup
 * @see     GenAT_HolidayGroup
 * @see     QAT_HolidayGroup
 * @see     GenQAT_HolidayGroup
 */
public class PKAT_HolidayGroup extends AbstractExDBPrimaryKey<AT_HolidayGroup, PKAT_HolidayGroup> {

    private static final long serialVersionUID = 1L;

    public PKAT_HolidayGroup() {
    }

    public PKAT_HolidayGroup(String pHolidayGroupCd) {
        holidayGroupCd = pHolidayGroupCd;
    }

    @Transient
    @Override
    public Class<AT_HolidayGroup> getEntityClass() {
        return AT_HolidayGroup.class;
    }

    private String holidayGroupCd;

    public String getHolidayGroupCd() {
        return holidayGroupCd;
    }

    public void setHolidayGroupCd(String pHolidayGroupCd) {
        holidayGroupCd = pHolidayGroupCd;
    }

}