package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenJT_SiHubiDetail;


/**
 * 支払不備詳細テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SiHubiDetail} の JavaDoc を参照してください。<br />
 * @see     GenJT_SiHubiDetail<br />
 * @see     PKJT_SiHubiDetail<br />
 * @see     QJT_SiHubiDetail<br />
 * @see     GenQJT_SiHubiDetail<br />
 */
@Entity
public class JT_SiHubiDetail extends GenJT_SiHubiDetail {

    private static final long serialVersionUID = 1L;

    public JT_SiHubiDetail() {
    }

    public JT_SiHubiDetail(String pHubisikibetukey,Integer pRenno3keta) {
        super(pHubisikibetukey,pRenno3keta);
    }



    private JT_SiHubi jT_SiHubi ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_SiHubiDetail.HUBISIKIBETUKEY  , referencedColumnName=JT_SiHubi.HUBISIKIBETUKEY, insertable=false, updatable=false)
    })
    public JT_SiHubi getSiHubi() {
        return jT_SiHubi;
    }

    public void setSiHubi(JT_SiHubi pJT_SiHubi) {
        this.jT_SiHubi = pJT_SiHubi;
    }

    private AM_SyoruiZokusei aM_SyoruiZokusei ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=JT_SiHubiDetail.HUBISYORUICD  , referencedColumnName=AM_SyoruiZokusei.SYORUICD, insertable=false, updatable=false)
    })
    public  AM_SyoruiZokusei getSyoruiZokusei() {
        return aM_SyoruiZokusei;
    }

    public void setSyoruiZokusei(AM_SyoruiZokusei pAM_SyoruiZokusei) {
        this.aM_SyoruiZokusei = pAM_SyoruiZokusei;
    }

    private AM_User aM_User ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=JT_SiHubiDetail.GYOUMUKOUSINSYAID  , referencedColumnName=AM_User.USERID, insertable=false, updatable=false)
    })
    public  AM_User getUser() {
        return aM_User;
    }

    public void setUser(AM_User pAM_User) {
        this.aM_User = pAM_User;
    }

}

