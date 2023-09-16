package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import yuyu.def.db.id.PKAT_UserSettei;
import yuyu.def.db.mapping.GenAT_UserSettei;
import yuyu.def.db.meta.GenQAT_UserSettei;
import yuyu.def.db.meta.QAT_UserSettei;

/**
 * ユーザー設定テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_UserSettei} の JavaDoc を参照してください。
 * @see     GenAT_UserSettei
 * @see     PKAT_UserSettei
 * @see     QAT_UserSettei
 * @see     GenQAT_UserSettei
 */
@Entity
public class AT_UserSettei extends GenAT_UserSettei {

    private static final long serialVersionUID = 1L;

    public AT_UserSettei() {
    }

    public AT_UserSettei(String pUserId) {
        super(pUserId);
    }

    public AT_UserSettei(AM_User pUser) {
        super(pUser.getUserId());
        setUser(pUser);
    }

    private AM_User aM_User;

    @LazyToOne(LazyToOneOption.FALSE)
    @ManyToOne(optional=true)
    @JoinColumn(name=AT_UserSettei.USERID, referencedColumnName=AM_User.USERID, insertable=false, updatable=false)
    public AM_User getUser() {
        return aM_User;
    }

    public void setUser(AM_User pUser) {
        aM_User = pUser;
    }

}
