package yuyu.def.db.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import yuyu.def.db.id.PKAS_Kinou;
import yuyu.def.db.mapping.GenAS_Kinou;
import yuyu.def.db.meta.GenQAS_Kinou;
import yuyu.def.db.meta.QAS_Kinou;

import com.google.common.collect.Sets;

/**
 * 機能基幹テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAS_Kinou} の JavaDoc を参照してください。
 * @see     GenAS_Kinou
 * @see     PKAS_Kinou
 * @see     QAS_Kinou
 * @see     GenQAS_Kinou
 */
@Entity
public class AS_Kinou extends GenAS_Kinou {

    private static final long serialVersionUID = 1L;

    public AS_Kinou() {
    }

    public AS_Kinou(String pKinouId) {
        super(pKinouId);
    }


    @Transient
    public AS_SubSystem getSubSystem() {
        return getCategory().getSubSystem();
    }

    private AS_Category aS_Category;

    @ManyToOne
    @JoinColumn(name=AS_Kinou.CATEGORYID, referencedColumnName=AS_Category.CATEGORYID, insertable=false, updatable=false)
    public AS_Category getCategory() {
        return aS_Category;
    }

    public void setCategory(AS_Category pCategory) {
        aS_Category = pCategory;
    }

    private Set<AS_KinouMode>  aS_KinouModes = Sets.newLinkedHashSet();

    public AS_KinouMode createKinouMode() {
        AS_KinouMode aS_KinouMode = new AS_KinouMode();
        aS_KinouMode.setKinou(this);
        aS_KinouMode.setKinouId(this.getKinouId());
        getKinouModes().add(aS_KinouMode);
        return aS_KinouMode;
    }

    @OneToMany(
        fetch         = FetchType.EAGER,
        cascade       = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.DETACH, CascadeType.REFRESH },
        orphanRemoval = true
        )
    @JoinColumn(name=AS_KinouMode.KINOUID, referencedColumnName=AS_Kinou.KINOUID, insertable=false, updatable=false)
    public Set<AS_KinouMode> getKinouModes() {
        return aS_KinouModes;
    }

    public void setKinouModes(Set<AS_KinouMode> pKinouModes) {
        aS_KinouModes = pKinouModes;
    }

    public AS_KinouMode getKinouMode(String kinouModeId) {
        for (AS_KinouMode mode : getKinouModes()) {
            if (mode.getKinouModeId().equals(kinouModeId)) {
                return mode;
            }
        }
        return null;
    }

    public void deleteKinouMode(String kinouModeId) {
        AS_KinouMode mode = getKinouMode(kinouModeId);
        if (mode != null) {
            getKinouModes().remove(mode);
        }
        // TODO 指定 kinouModeId の機能モードを持っていないときは無視してるけど、エラーにしなくて良い？  2014/03/11 T.Hoshino
        //      あとこのメソッド、どう考えても機能定義登録あたりからしか使われないよね..  Entity のメソッドか？？
    }

}
