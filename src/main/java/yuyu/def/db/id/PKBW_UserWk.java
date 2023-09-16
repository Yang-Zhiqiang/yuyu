package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.BW_UserWk;
import yuyu.def.db.mapping.GenBW_UserWk;
import yuyu.def.db.meta.GenQBW_UserWk;
import yuyu.def.db.meta.QBW_UserWk;

/**
 * ユーザーマスタワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BW_UserWk}</td><td colspan="3">ユーザーマスタワークテーブル</td></tr>
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
 * @see     BW_UserWk
 * @see     GenBW_UserWk
 * @see     QBW_UserWk
 * @see     GenQBW_UserWk
 */
public class PKBW_UserWk extends AbstractExDBPrimaryKey<BW_UserWk, PKBW_UserWk> {

    private static final long serialVersionUID = 1L;

    public PKBW_UserWk() {
    }

    public PKBW_UserWk(String pUserId) {
        userId = pUserId;
    }

    @Transient
    @Override
    public Class<BW_UserWk> getEntityClass() {
        return BW_UserWk.class;
    }

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String pUserId) {
        userId = pUserId;
    }

}