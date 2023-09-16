package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_EigyoubiKbn;
import yuyu.def.classification.C_KadouTimeYoubiKbn;
import yuyu.def.db.entity.AT_KadouTime;
import yuyu.def.db.mapping.GenAT_KadouTime;
import yuyu.def.db.meta.GenQAT_KadouTime;
import yuyu.def.db.meta.QAT_KadouTime;

/**
 * 稼働時間テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_KadouTime}</td><td colspan="3">稼働時間テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKadouTimeGroupCd kadouTimeGroupCd}</td><td>稼働時間グループコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKadouTimeYoubiKbn kadouTimeYoubiKbn}</td><td>稼働時間曜日区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_KadouTimeYoubiKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getEigyoubiKbn eigyoubiKbn}</td><td>営業日区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_EigyoubiKbn}</td></tr>
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
 * @see     AT_KadouTime
 * @see     GenAT_KadouTime
 * @see     QAT_KadouTime
 * @see     GenQAT_KadouTime
 */
public class PKAT_KadouTime extends AbstractExDBPrimaryKey<AT_KadouTime, PKAT_KadouTime> {

    private static final long serialVersionUID = 1L;

    public PKAT_KadouTime() {
    }

    public PKAT_KadouTime(
        String pKadouTimeGroupCd,
        C_KadouTimeYoubiKbn pKadouTimeYoubiKbn,
        C_EigyoubiKbn pEigyoubiKbn
    ) {
        kadouTimeGroupCd = pKadouTimeGroupCd;
        kadouTimeYoubiKbn = pKadouTimeYoubiKbn;
        eigyoubiKbn = pEigyoubiKbn;
    }

    @Transient
    @Override
    public Class<AT_KadouTime> getEntityClass() {
        return AT_KadouTime.class;
    }

    private String kadouTimeGroupCd;

    public String getKadouTimeGroupCd() {
        return kadouTimeGroupCd;
    }

    public void setKadouTimeGroupCd(String pKadouTimeGroupCd) {
        kadouTimeGroupCd = pKadouTimeGroupCd;
    }
    private C_KadouTimeYoubiKbn kadouTimeYoubiKbn;

    @org.hibernate.annotations.Type(type="UserType_C_KadouTimeYoubiKbn")
    public C_KadouTimeYoubiKbn getKadouTimeYoubiKbn() {
        return kadouTimeYoubiKbn;
    }

    public void setKadouTimeYoubiKbn(C_KadouTimeYoubiKbn pKadouTimeYoubiKbn) {
        kadouTimeYoubiKbn = pKadouTimeYoubiKbn;
    }
    private C_EigyoubiKbn eigyoubiKbn;

    @org.hibernate.annotations.Type(type="UserType_C_EigyoubiKbn")
    public C_EigyoubiKbn getEigyoubiKbn() {
        return eigyoubiKbn;
    }

    public void setEigyoubiKbn(C_EigyoubiKbn pEigyoubiKbn) {
        eigyoubiKbn = pEigyoubiKbn;
    }

}