package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_UserHenkouRireki;
import yuyu.def.db.mapping.GenAT_UserHenkouRireki;
import yuyu.def.db.meta.GenQAT_UserHenkouRireki;
import yuyu.def.db.meta.QAT_UserHenkouRireki;

/**
 * ユーザー変更履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_UserHenkouRireki}</td><td colspan="3">ユーザー変更履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getUniqueId uniqueId}</td><td>ユニークＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>userId</td><td>ユーザーＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rirekiSyuruiKbn</td><td>履歴種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_RirekiSyuruiKbn C_RirekiSyuruiKbn}</td></tr>
 *  <tr><td>userNm</td><td>ユーザー名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>specialUserKbn</td><td>特別ユーザー区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SpecialUserKbn C_SpecialUserKbn}</td></tr>
 *  <tr><td>password</td><td>パスワード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>passwordSetteiYmd</td><td>パスワード設定年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>passwordYuukouKigenYmd</td><td>パスワード有効期限年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>passwordYuukouCountY</td><td>パスワード有効年数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>passwordYuukouCountM</td><td>パスワード有効月数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>passwordYuukouCountD</td><td>パスワード有効日数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>passwordYuukouKikanKbn</td><td>パスワード有効期間区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_PasswordYuukouKikanKbn C_PasswordYuukouKikanKbn}</td></tr>
 *  <tr><td>passwordHenkouKyokaKbn</td><td>パスワード変更許可区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KyokaKbn C_KyokaKbn}</td></tr>
 *  <tr><td>passwordHenkouYoukyuuKbn</td><td>パスワード変更要求区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YoukyuuKbn C_YoukyuuKbn}</td></tr>
 *  <tr><td>loginKyokaKbn</td><td>ログイン許可区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KyokaKbn C_KyokaKbn}</td></tr>
 *  <tr><td>loginErrorCount</td><td>ログインエラー回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     AT_UserHenkouRireki
 * @see     GenAT_UserHenkouRireki
 * @see     QAT_UserHenkouRireki
 * @see     GenQAT_UserHenkouRireki
 */
public class PKAT_UserHenkouRireki extends AbstractExDBPrimaryKey<AT_UserHenkouRireki, PKAT_UserHenkouRireki> {

    private static final long serialVersionUID = 1L;

    public PKAT_UserHenkouRireki() {
    }

    public PKAT_UserHenkouRireki(String pUniqueId) {
        uniqueId = pUniqueId;
    }

    @Transient
    @Override
    public Class<AT_UserHenkouRireki> getEntityClass() {
        return AT_UserHenkouRireki.class;
    }

    private String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String pUniqueId) {
        uniqueId = pUniqueId;
    }

}