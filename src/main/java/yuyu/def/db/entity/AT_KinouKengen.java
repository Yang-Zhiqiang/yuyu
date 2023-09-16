package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.id.PKAT_KinouKengen;
import yuyu.def.db.mapping.GenAT_KinouKengen;
import yuyu.def.db.meta.GenQAT_KinouKengen;
import yuyu.def.db.meta.QAT_KinouKengen;

/**
 * 機能権限テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_KinouKengen} の JavaDoc を参照してください。
 * @see     GenAT_KinouKengen
 * @see     PKAT_KinouKengen
 * @see     QAT_KinouKengen
 * @see     GenQAT_KinouKengen
 */
@Entity
public class AT_KinouKengen extends GenAT_KinouKengen {

    private static final long serialVersionUID = 1L;

    public AT_KinouKengen() {
    }

    public AT_KinouKengen(
        String pKinouId,
        String pKinouModeId,
        String pRoleCd
        ) {
        super(
            pKinouId,
            pKinouModeId,
            pRoleCd
            );
    }

    private AM_Role aM_Role;

    @ManyToOne
    @JoinColumn(name=AT_KinouKengen.ROLECD, referencedColumnName=AM_Role.ROLECD, insertable=false, updatable=false)
    public AM_Role getRole() {
        return aM_Role;
    }

    public void setRole(AM_Role pRole) {
        aM_Role = pRole;
    }

    private AS_KinouMode aS_KinouMode;

    @ManyToOne(
        )
    @JoinColumns({
        @JoinColumn(name=AT_KinouKengen.KINOUID,     referencedColumnName=AS_KinouMode.KINOUID,     insertable=false, updatable=false),
        @JoinColumn(name=AT_KinouKengen.KINOUMODEID, referencedColumnName=AS_KinouMode.KINOUMODEID, insertable=false, updatable=false)
    })
    public AS_KinouMode getKinouMode() {
        return aS_KinouMode;
    }

    public void setKinouMode(AS_KinouMode pKinouMode) {
        aS_KinouMode = pKinouMode;
    }

}
