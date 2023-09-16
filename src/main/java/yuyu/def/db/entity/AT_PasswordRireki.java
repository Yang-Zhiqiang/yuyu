package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import yuyu.def.db.id.PKAT_PasswordRireki;
import yuyu.def.db.mapping.GenAT_PasswordRireki;
import yuyu.def.db.meta.GenQAT_PasswordRireki;
import yuyu.def.db.meta.QAT_PasswordRireki;

/**
 * パスワード履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_PasswordRireki} の JavaDoc を参照してください。
 * パスワード履歴テーブル のエンティティです。<br />
 * <br />
 * 例)<br />
 * 　以下のように ユーザー登録・パスワード変更 した場合、
 * <ol>
 *   <li>新規ユーザー登録 { userId: 'user1', password: 'Password1' }</li>
 *   <li>パスワード変更　 { userId: 'user1', password: 'Password2' }</li>
 *   <li>パスワード変更　 { userId: 'user1', password: 'Password3' }</li>
 * </ol>
 * パスワード履歴は以下のようになっています。
 * <table border="1" cellspacing="0" cellpadding="1">
 *   <tr bgcolor="whitesmoke"><th>テーブル</th><th>レコード</th><th>備考</th></tr>
 *   <tr><td>AM_User</td><td>{ userId: 'user1', password: 'Password3' }</td><td>現行(最新)パスワード</td></tr>
 *   <tr><td rowspan="2">AT_PasswordRireki</td><td>{ userId: 'user1', password: 'Password2' }</td><td>1つ前のパスワード</td></tr>
 *   <tr><td>{ userId: 'user1', password: 'Password1' }</td><td>2つ前のパスワード</td></tr>
 * </table>
 * @see     GenAT_PasswordRireki
 * @see     PKAT_PasswordRireki
 * @see     QAT_PasswordRireki
 * @see     GenQAT_PasswordRireki
 */
@Entity
public class AT_PasswordRireki extends GenAT_PasswordRireki {

    private static final long serialVersionUID = 1L;

    public AT_PasswordRireki() {
    }

    public AT_PasswordRireki(String pUniqueId) {
        super(pUniqueId);
    }

    private AM_User aM_User;

    @LazyToOne(LazyToOneOption.FALSE)
    @ManyToOne
    @JoinColumn(name=AT_PasswordRireki.USERID, referencedColumnName=AM_User.USERID ,insertable=false, updatable=false)
    public AM_User getUser() {
        return aM_User;
    }

    void setUser(AM_User pAM_User) {
        aM_User = pAM_User;
    }

}