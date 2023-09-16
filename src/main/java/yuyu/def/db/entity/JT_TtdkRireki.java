package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenJT_TtdkRireki;


/**
 * 手続履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_TtdkRireki} の JavaDoc を参照してください。<br />
 * @see     GenJT_TtdkRireki<br />
 * @see     PKJT_TtdkRireki<br />
 * @see     QJT_TtdkRireki<br />
 * @see     GenQJT_TtdkRireki<br />
 */
@Entity
public class JT_TtdkRireki extends GenJT_TtdkRireki {

    private static final long serialVersionUID = 1L;

    public JT_TtdkRireki() {
    }

    public JT_TtdkRireki(String pSkno,String pSyono,String pTtdkrrkskbtkey) {
        super(pSkno,pSyono,pTtdkrrkskbtkey);
    }



    private JT_SkKihon jT_SkKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_TtdkRireki.SKNO  , referencedColumnName=JT_SkKihon.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_TtdkRireki.SYONO  , referencedColumnName=JT_SkKihon.SYONO, insertable=false, updatable=false)
    })
    public JT_SkKihon getSkKihon() {
        return jT_SkKihon;
    }

    public void setSkKihon(JT_SkKihon pJT_SkKihon) {
        this.jT_SkKihon = pJT_SkKihon;
    }

    private AM_User aM_User ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=JT_TtdkRireki.GYOUMUKOUSINSYAID  , referencedColumnName=AM_User.USERID, insertable=false, updatable=false)
    })
    public  AM_User getUser() {
        return aM_User;
    }

    public void setUser(AM_User pAM_User) {
        this.aM_User = pAM_User;
    }

}

