package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenAT_RoleSiyouKanouSosiki;


/**
 * ロール使用可能組織テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_RoleSiyouKanouSosiki} の JavaDoc を参照してください。<br />
 * @see     GenAT_RoleSiyouKanouSosiki<br />
 * @see     PKAT_RoleSiyouKanouSosiki<br />
 * @see     QAT_RoleSiyouKanouSosiki<br />
 * @see     GenQAT_RoleSiyouKanouSosiki<br />
 */
@Entity
public class AT_RoleSiyouKanouSosiki extends GenAT_RoleSiyouKanouSosiki {

    private static final long serialVersionUID = 1L;

    public AT_RoleSiyouKanouSosiki() {
    }

    public AT_RoleSiyouKanouSosiki(String pSyozokusosikicd,String pRoleCd) {
        super(pSyozokusosikicd,pRoleCd);
    }

    private AM_Role aM_Role ;

    @ManyToOne (fetch = FetchType.LAZY,
                       cascade = { CascadeType.DETACH }
                       )
        @JoinColumn(name=AT_RoleSiyouKanouSosiki.ROLECD  , referencedColumnName=AM_Role.ROLECD, insertable=false, updatable=false)
    public  AM_Role getRole() {
        return aM_Role;
    }

    public void setRole(AM_Role pAM_Role) {
        this.aM_Role = pAM_Role;
    }

}

