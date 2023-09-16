package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.mapping.GenAM_User;
import yuyu.def.db.meta.GenQAM_User;
import yuyu.def.db.meta.QAM_User;

/**
 * ユーザーマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_User}</td><td colspan="3">ユーザーマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>userNm</td><td>ユーザー名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>userGroupCd</td><td>ユーザーグループコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
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
 *  <tr><td>lastLoginTime</td><td>最終ログイン時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AM_User
 * @see     GenAM_User
 * @see     QAM_User
 * @see     GenQAM_User
 */
public class PKAM_User extends AbstractExDBPrimaryKey<AM_User, PKAM_User> {

    private static final long serialVersionUID = 1L;

    public PKAM_User() {
    }

    public PKAM_User(String pUserId) {
        userId = pUserId;
    }

    @Transient
    @Override
    public Class<AM_User> getEntityClass() {
        return AM_User.class;
    }

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String pUserId) {
        userId = pUserId;
    }

}