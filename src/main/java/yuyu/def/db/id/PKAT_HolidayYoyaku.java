package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.AT_HolidayYoyaku;
import yuyu.def.db.mapping.GenAT_HolidayYoyaku;
import yuyu.def.db.meta.GenQAT_HolidayYoyaku;
import yuyu.def.db.meta.QAT_HolidayYoyaku;

/**
 * 休日予約テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_HolidayYoyaku}</td><td colspan="3">休日予約テーブル</td></tr>
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
 *  <tr><td>yoyakuKbn</td><td>予約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YoyakuKbn C_YoyakuKbn}</td></tr>
 * </table>
 * @see     AT_HolidayYoyaku
 * @see     GenAT_HolidayYoyaku
 * @see     QAT_HolidayYoyaku
 * @see     GenQAT_HolidayYoyaku
 */
public class PKAT_HolidayYoyaku extends AbstractExDBPrimaryKey<AT_HolidayYoyaku, PKAT_HolidayYoyaku> {

    private static final long serialVersionUID = 1L;

    public PKAT_HolidayYoyaku() {
    }

    public PKAT_HolidayYoyaku(String pHolidayGroupCd, String pHolidayCd) {
        holidayGroupCd = pHolidayGroupCd;
        holidayCd = pHolidayCd;
    }

    @Transient
    @Override
    public Class<AT_HolidayYoyaku> getEntityClass() {
        return AT_HolidayYoyaku.class;
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