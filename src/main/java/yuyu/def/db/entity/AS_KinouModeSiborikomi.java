package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import yuyu.def.db.id.PKAS_KinouModeSiborikomi;
import yuyu.def.db.mapping.GenAS_KinouModeSiborikomi;
import yuyu.def.db.meta.GenQAS_KinouModeSiborikomi;
import yuyu.def.db.meta.QAS_KinouModeSiborikomi;

/**
 * 機能モード絞込み基幹テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAS_KinouModeSiborikomi} の JavaDoc を参照してください。
 * @see     GenAS_KinouModeSiborikomi
 * @see     PKAS_KinouModeSiborikomi
 * @see     QAS_KinouModeSiborikomi
 * @see     GenQAS_KinouModeSiborikomi
 */
@Entity
public class AS_KinouModeSiborikomi extends GenAS_KinouModeSiborikomi {

    private static final long serialVersionUID = 1L;

    public AS_KinouModeSiborikomi() {
    }

    public AS_KinouModeSiborikomi(
        String pKinouId,
        String pKinouModeId,
        String pSiborikomiId
        ) {
        super(
            pKinouId,
            pKinouModeId,
            pSiborikomiId
            );
    }

    private AS_KinouMode aS_KinouMode;

    @ManyToOne(
        )
    @JoinColumns({
        @JoinColumn(name=AS_KinouModeSiborikomi.KINOUID,     referencedColumnName=AS_KinouMode.KINOUID,     insertable=false, updatable=false),
        @JoinColumn(name=AS_KinouModeSiborikomi.KINOUMODEID, referencedColumnName=AS_KinouMode.KINOUMODEID, insertable=false, updatable=false)
    })
    public AS_KinouMode getKinouMode() {
        return aS_KinouMode;
    }

    public void setKinouMode(AS_KinouMode pKinouMode) {
        aS_KinouMode = pKinouMode;
    }
}
