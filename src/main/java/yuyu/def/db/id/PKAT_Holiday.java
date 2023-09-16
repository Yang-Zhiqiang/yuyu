package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.AT_Holiday;
import yuyu.def.db.mapping.GenAT_Holiday;
import yuyu.def.db.meta.GenQAT_Holiday;
import yuyu.def.db.meta.QAT_Holiday;

/**
 * 休日テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_Holiday}</td><td colspan="3">休日テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHolidayGroupCd holidayGroupCd}</td><td>休日グループコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHolidayCd holidayCd}</td><td>休日コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>legalHolidayKbn</td><td>法定休日区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_LegalHolidayKbn C_LegalHolidayKbn}</td></tr>
 *  <tr><td>tekiyouYmdFrom</td><td>適用年月日（自）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tekiyouYmdTo</td><td>適用年月日（至）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>holidayPattern</td><td>休日パターン</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HolidayPtn C_HolidayPtn}</td></tr>
 *  <tr><td>holidayPatternParam</td><td>休日パターンパラメータ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>holidayPatternNm</td><td>休日パターン名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>holidayPatternDescription</td><td>休日パターン備考</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_Holiday
 * @see     GenAT_Holiday
 * @see     QAT_Holiday
 * @see     GenQAT_Holiday
 */
public class PKAT_Holiday extends AbstractExDBPrimaryKey<AT_Holiday, PKAT_Holiday> {

    private static final long serialVersionUID = 1L;

    public PKAT_Holiday() {
    }

    public PKAT_Holiday(String pHolidayGroupCd, String pHolidayCd) {
        holidayGroupCd = pHolidayGroupCd;
        holidayCd = pHolidayCd;
    }

    @Transient
    @Override
    public Class<AT_Holiday> getEntityClass() {
        return AT_Holiday.class;
    }

    private String holidayGroupCd;

    public String getHolidayGroupCd() {
        return holidayGroupCd;
    }

    public void setHolidayGroupCd(String pHolidayGroupCd) {
        holidayGroupCd = pHolidayGroupCd;
    }
    private String holidayCd;

    public String getHolidayCd() {
        return holidayCd;
    }

    public void setHolidayCd(String pHolidayCd) {
        holidayCd = pHolidayCd;
    }

}