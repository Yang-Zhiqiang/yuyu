package yuyu.def.db.entity;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.id.PKAM_TblsTarget;
import yuyu.def.db.mapping.GenAM_TblsTarget;
import yuyu.def.db.meta.GenQAM_TblsTarget;
import yuyu.def.db.meta.QAM_TblsTarget;

/**
 * テーブル照会対象マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAM_TblsTarget} の JavaDoc を参照してください。
 * @see     GenAM_TblsTarget
 * @see     PKAM_TblsTarget
 * @see     QAM_TblsTarget
 * @see     GenQAM_TblsTarget
 */
@Entity
public class AM_TblsTarget extends GenAM_TblsTarget {

    private static final long serialVersionUID = 1L;

    public AM_TblsTarget() {
    }

    public AM_TblsTarget(String pBaseTableId) {
        super(pBaseTableId);
    }

    private List<AM_TblsSearchPattern> tblSearchPattern;

    @OneToMany(
            orphanRemoval = true,
            fetch = FetchType.EAGER,
            cascade       = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH }
            )
    @JoinColumn(name=AM_TblsSearchPattern.BASETABLEID, referencedColumnName=AM_TblsTarget.BASETABLEID, insertable=false, updatable=false)
    public List<AM_TblsSearchPattern> getTblSearchPattern() {
        return tblSearchPattern;
    }

    public void setTblSearchPattern(List<AM_TblsSearchPattern> tblSearchPattern) {
        this.tblSearchPattern = tblSearchPattern;
    }

        private static final Map<String, AS_SubSystem> subsystemMap = new ConcurrentHashMap<>();

    @Transient
    public AS_SubSystem getSubsystem(){
        synchronized(subsystemMap) {
            if(!subsystemMap.containsKey(getSubSystemId())){
                subsystemMap.put(getSubSystemId(), SWAKInjector.getInstance(BaseDomManager.class).getSubSystem(getSubSystemId()));
            }
        }

        return subsystemMap.get(getSubSystemId());
    }

}
