package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_SkeittdkrenrakuKbn;
import yuyu.def.db.mapping.GenHT_SkTtdkTyuui;


/**
 * 新契約手続注意テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SkTtdkTyuui} の JavaDoc を参照してください。<br />
 * @see     GenHT_SkTtdkTyuui<br />
 * @see     PKHT_SkTtdkTyuui<br />
 * @see     QHT_SkTtdkTyuui<br />
 * @see     GenQHT_SkTtdkTyuui<br />
 */
@Entity
public class HT_SkTtdkTyuui extends GenHT_SkTtdkTyuui {

    private static final long serialVersionUID = 1L;

    public HT_SkTtdkTyuui() {
    }

    public HT_SkTtdkTyuui(String pMosno,C_SkeittdkrenrakuKbn pSkeittdkrenrakukbn,Integer pDatarenno) {
        super(pMosno,pSkeittdkrenrakukbn,pDatarenno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_SkTtdkTyuui.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

    private AM_User aM_User ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_SkTtdkTyuui.GYOUMUKOUSINSYAID  , referencedColumnName=AM_User.USERID, insertable=false, updatable=false)
    })
    public  AM_User getUser() {
        return aM_User;
    }

    public void setUser(AM_User pAM_User) {
        this.aM_User = pAM_User;
    }

}

