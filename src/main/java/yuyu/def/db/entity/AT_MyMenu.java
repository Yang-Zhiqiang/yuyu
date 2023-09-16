package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import yuyu.def.db.id.PKAT_MyMenu;
import yuyu.def.db.mapping.GenAT_MyMenu;
import yuyu.def.db.meta.GenQAT_MyMenu;
import yuyu.def.db.meta.QAT_MyMenu;

/**
 * マイメニューテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_MyMenu} の JavaDoc を参照してください。
 * @see     GenAT_MyMenu
 * @see     PKAT_MyMenu
 * @see     QAT_MyMenu
 * @see     GenQAT_MyMenu
 */
@Entity
public class AT_MyMenu extends GenAT_MyMenu {

    private static final long serialVersionUID = 1L;

    public AT_MyMenu() {
    }

    public AT_MyMenu(String pUserId, String pKinouId) {
        super(pUserId, pKinouId);
    }

    private AM_User aM_User;

    @LazyToOne(LazyToOneOption.FALSE)
    @ManyToOne
    @JoinColumn(name=AT_MyMenu.USERID, referencedColumnName=AM_User.USERID, insertable=false, updatable=false)
    public AM_User getUser() {
        return aM_User;
    }

    void setUser(AM_User pUser) {
        aM_User = pUser;
    }

    private AS_Kinou aS_Kinou;

    @LazyToOne(LazyToOneOption.FALSE)
    @ManyToOne
    @JoinColumn(name=AT_MyMenu.KINOUID, referencedColumnName=AS_Kinou.KINOUID, insertable=false, updatable=false)
    public AS_Kinou getKinou(){
        return aS_Kinou;
    }

    void setKinou(AS_Kinou pKinou){
        aS_Kinou = pKinou;
    }
}
