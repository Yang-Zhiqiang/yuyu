package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.AT_UserSettei;
import yuyu.def.db.mapping.GenAT_UserSettei;
import yuyu.def.db.meta.GenQAT_UserSettei;
import yuyu.def.db.meta.QAT_UserSettei;

/**
 * ユーザー設定テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_UserSettei}</td><td colspan="3">ユーザー設定テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>niGamenModKbn</td><td>２画面モード区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NiGamenModeJyoutaiKbn C_NiGamenModeJyoutaiKbn}</td></tr>
 * </table>
 * @see     AT_UserSettei
 * @see     GenAT_UserSettei
 * @see     QAT_UserSettei
 * @see     GenQAT_UserSettei
 */
public class PKAT_UserSettei extends AbstractExDBPrimaryKey<AT_UserSettei, PKAT_UserSettei> {

    private static final long serialVersionUID = 1L;

    public PKAT_UserSettei() {
    }

    public PKAT_UserSettei(String pUserId) {
        userId = pUserId;
    }

    @Transient
    @Override
    public Class<AT_UserSettei> getEntityClass() {
        return AT_UserSettei.class;
    }

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String pUserId) {
        userId = pUserId;
    }

}