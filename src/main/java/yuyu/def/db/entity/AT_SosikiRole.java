package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenAT_SosikiRole;


/**
 * 組織ロールテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_SosikiRole} の JavaDoc を参照してください。<br />
 * @see     GenAT_SosikiRole<br />
 * @see     PKAT_SosikiRole<br />
 * @see     QAT_SosikiRole<br />
 * @see     GenQAT_SosikiRole<br />
 */
@Entity
public class AT_SosikiRole extends GenAT_SosikiRole {

    private static final long serialVersionUID = 1L;

    public AT_SosikiRole() {
    }

    public AT_SosikiRole(String pTanmatusettisosikicd,String pRoleCd) {
        super(pTanmatusettisosikicd,pRoleCd);
    }

    private AM_Role aM_Role ;

    @ManyToOne (fetch = FetchType.LAZY,
                       cascade = { CascadeType.DETACH }
                       )
        @JoinColumn(name=AT_SosikiRole.ROLECD  , referencedColumnName=AM_Role.ROLECD, insertable=false, updatable=false)
    public  AM_Role getRole() {
        return aM_Role;
    }

    public void setRole(AM_Role pAM_Role) {
        this.aM_Role = pAM_Role;
    }

}

