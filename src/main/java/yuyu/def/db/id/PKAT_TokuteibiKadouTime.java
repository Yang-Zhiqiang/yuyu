package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.AT_TokuteibiKadouTime;
import yuyu.def.db.mapping.GenAT_TokuteibiKadouTime;
import yuyu.def.db.meta.GenQAT_TokuteibiKadouTime;
import yuyu.def.db.meta.QAT_TokuteibiKadouTime;

/**
 * 特定日稼働時間テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_TokuteibiKadouTime}</td><td colspan="3">特定日稼働時間テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKadouTimeGroupCd kadouTimeGroupCd}</td><td>稼働時間グループコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKadouTimeSiteiYmd kadouTimeSiteiYmd}</td><td>稼働時間指定年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kadouTimeSiteiKbn</td><td>稼働時間指定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KadouTimeSiteiKbn C_KadouTimeSiteiKbn}</td></tr>
 *  <tr><td>kadouTimeFrom1</td><td>稼働時間１（自）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kadouTimeTo1</td><td>稼働時間１（至）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kadouTimeFrom2</td><td>稼働時間２（自）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kadouTimeTo2</td><td>稼働時間２（至）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kadouTimeFrom3</td><td>稼働時間３（自）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kadouTimeTo3</td><td>稼働時間３（至）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kadouTimeFrom4</td><td>稼働時間４（自）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kadouTimeTo4</td><td>稼働時間４（至）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kadouTimeFrom5</td><td>稼働時間５（自）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kadouTimeTo5</td><td>稼働時間５（至）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_TokuteibiKadouTime
 * @see     GenAT_TokuteibiKadouTime
 * @see     QAT_TokuteibiKadouTime
 * @see     GenQAT_TokuteibiKadouTime
 */
public class PKAT_TokuteibiKadouTime extends AbstractExDBPrimaryKey<AT_TokuteibiKadouTime, PKAT_TokuteibiKadouTime> {

    private static final long serialVersionUID = 1L;

    public PKAT_TokuteibiKadouTime() {
    }

    public PKAT_TokuteibiKadouTime(String pKadouTimeGroupCd, BizDate pKadouTimeSiteiYmd) {
        kadouTimeGroupCd = pKadouTimeGroupCd;
        kadouTimeSiteiYmd = pKadouTimeSiteiYmd;
    }

    @Transient
    @Override
    public Class<AT_TokuteibiKadouTime> getEntityClass() {
        return AT_TokuteibiKadouTime.class;
    }

    private String kadouTimeGroupCd;

    public String getKadouTimeGroupCd() {
        return kadouTimeGroupCd;
    }

    public void setKadouTimeGroupCd(String pKadouTimeGroupCd) {
        kadouTimeGroupCd = pKadouTimeGroupCd;
    }
    private BizDate kadouTimeSiteiYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getKadouTimeSiteiYmd() {
        return kadouTimeSiteiYmd;
    }

    public void setKadouTimeSiteiYmd(BizDate pKadouTimeSiteiYmd) {
        kadouTimeSiteiYmd = pKadouTimeSiteiYmd;
    }

}