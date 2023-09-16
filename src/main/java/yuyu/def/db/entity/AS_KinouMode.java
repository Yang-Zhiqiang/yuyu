package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.id.PKAS_KinouMode;
import yuyu.def.db.mapping.GenAS_KinouMode;
import yuyu.def.db.meta.GenQAS_KinouMode;
import yuyu.def.db.meta.QAS_KinouMode;

import com.google.common.collect.Lists;

/**
 * 機能モード基幹テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAS_KinouMode} の JavaDoc を参照してください。
 * @see     GenAS_KinouMode
 * @see     PKAS_KinouMode
 * @see     QAS_KinouMode
 * @see     GenQAS_KinouMode
 */
@Entity
public class AS_KinouMode extends GenAS_KinouMode {

    private static final long serialVersionUID = 1L;

    public AS_KinouMode() {
    }

    public AS_KinouMode(String pKinouId, String pKinouModeId) {
        super(pKinouId, pKinouModeId);
    }

    private AS_Kinou aS_Kinou;

    @ManyToOne
    @JoinColumn(name=AS_KinouMode.KINOUID, referencedColumnName=AS_Kinou.KINOUID, insertable=false, updatable=false)
    public AS_Kinou getKinou() {
        return aS_Kinou;
    }

    public void setKinou(AS_Kinou pKinou) {
        aS_Kinou = pKinou;
    }

    private List<AT_KinouKengen> aT_KinouKengens = Lists.newLinkedList();

    public AT_KinouKengen createKinouKengen() {
        AT_KinouKengen aT_KinouKengen = new AT_KinouKengen();
        aT_KinouKengen.setKinouMode(this);
        aT_KinouKengen.setKinouId(this.getKinouId());
        aT_KinouKengen.setKinouModeId(this.getKinouModeId());
        getKinouKengens().add(aT_KinouKengen);
        return aT_KinouKengen;
    }

    @OneToMany(
        cascade       = { CascadeType.PERSIST,  CascadeType.DETACH, CascadeType.REFRESH },
        orphanRemoval = true
        )
    @JoinColumns({
        @JoinColumn(name=AT_KinouKengen.KINOUID,     referencedColumnName=AS_KinouMode.KINOUID,     insertable=false, updatable=false),
        @JoinColumn(name=AT_KinouKengen.KINOUMODEID, referencedColumnName=AS_KinouMode.KINOUMODEID, insertable=false, updatable=false)
    })
    public List<AT_KinouKengen> getKinouKengens() {
        return aT_KinouKengens;
    }

    public void setKinouKengens(List<AT_KinouKengen> pKinouKengens) {
        aT_KinouKengens = pKinouKengens;
    }

    public AT_KinouKengen getKinouKengen(String pRoleCd) {
        for (AT_KinouKengen kinouKengen : getKinouKengens()) {
            if (kinouKengen.getRoleCd().equals(pRoleCd)) {
                return kinouKengen;
            }
        }
        return null;
    }

    public void deleteAllKinouKengens() {
        getKinouKengens().clear();
    }

    private List<AS_KinouModeSiborikomi> aS_KinouModeSiborikomis = Lists.newLinkedList();

    public AS_KinouModeSiborikomi createKinouModeSiborikomi() {
        AS_KinouModeSiborikomi aS_KinouModeSiborikomi = new AS_KinouModeSiborikomi();
        aS_KinouModeSiborikomi.setKinouMode(this);
        aS_KinouModeSiborikomi.setKinouId(this.getKinouId());
        aS_KinouModeSiborikomi.setKinouModeId(this.getKinouModeId());
        getKinouModeSiborikomis().add(aS_KinouModeSiborikomi);
        return aS_KinouModeSiborikomi;
    }

    @OneToMany(
        cascade       = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH },
        orphanRemoval = true
        )
    @JoinColumns({
        @JoinColumn(name=AS_KinouModeSiborikomi.KINOUID,     referencedColumnName=AS_KinouMode.KINOUID,     insertable=false, updatable=false),
        @JoinColumn(name=AS_KinouModeSiborikomi.KINOUMODEID, referencedColumnName=AS_KinouMode.KINOUMODEID, insertable=false, updatable=false)
    })
    public List<AS_KinouModeSiborikomi> getKinouModeSiborikomis() {
        return aS_KinouModeSiborikomis;
    }

    public void setKinouModeSiborikomis(List<AS_KinouModeSiborikomi> pKinouModeSiborikomis) {
        aS_KinouModeSiborikomis = pKinouModeSiborikomis;
    }

    public AS_KinouModeSiborikomi getKinouModoSiborikomi(final String siborikomiId) {
        for (AS_KinouModeSiborikomi siborikomi : getKinouModeSiborikomis()) {
            if (siborikomi.getSiborikomiId().equals(siborikomiId)) {
                return siborikomi;
            }
        }
        return null;
    }

    private AT_KadouTimeGroup aT_KadouTimeGroup;

    @ManyToOne
    @NotFound(action=NotFoundAction.IGNORE)
    @JoinColumn(name=AS_KinouMode.KADOUTIMEGROUPCD, referencedColumnName=AT_KadouTimeGroup.KADOUTIMEGROUPCD, insertable=false, updatable=false)
    public AT_KadouTimeGroup getKadouTimeGroup() {
        return aT_KadouTimeGroup;
    }

    public void setKadouTimeGroup(AT_KadouTimeGroup pKadouTimeGroup) {
        aT_KadouTimeGroup = pKadouTimeGroup;
    }

}
