package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import yuyu.def.db.id.PKAT_UserRole;
import yuyu.def.db.mapping.GenAT_UserRole;
import yuyu.def.db.meta.GenQAT_UserRole;
import yuyu.def.db.meta.QAT_UserRole;

/**
 * ユーザーロールテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_UserRole} の JavaDoc を参照してください。
 * @see     GenAT_UserRole
 * @see     PKAT_UserRole
 * @see     QAT_UserRole
 * @see     GenQAT_UserRole
 */
@Entity
public class AT_UserRole extends GenAT_UserRole {

    private static final long serialVersionUID = 1L;

    public AT_UserRole() {
    }

    public AT_UserRole(String pUserId, String pRoleCd) {
        super(pUserId, pRoleCd);
    }

            
    private AM_Role aM_Role;

    @ManyToOne
    @JoinColumn(name=AT_UserRole.ROLECD, referencedColumnName=AM_Role.ROLECD, insertable=false, updatable=false)
    public AM_Role getRole(){
        return aM_Role;
    }

    void setRole(AM_Role pRole){
        aM_Role = pRole;
    }

            
    private AM_User aM_User;

    @ManyToOne
    @JoinColumn(name=AT_UserRole.USERID, referencedColumnName=AM_User.USERID, insertable=false, updatable=false)
    public AM_User getUser(){
        return aM_User;
    }

    void setUser(AM_User pUser){
        aM_User = pUser;
    }

}