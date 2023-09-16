package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.mapping.GenBM_SyoruiZokuseiHukaInfo;
/**
 * 書類属性付加情報マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_SyoruiZokuseiHukaInfo} の JavaDoc を参照してください。<br />
 * @see     GenBM_SyoruiZokuseiHukaInfo<br />
 * @see     PKBM_SyoruiZokuseiHukaInfo<br />
 * @see     QBM_SyoruiZokuseiHukaInfo<br />
 * @see     GenQBM_SyoruiZokuseiHukaInfo<br />
 */
@Entity
public class BM_SyoruiZokuseiHukaInfo extends GenBM_SyoruiZokuseiHukaInfo {

    private static final long serialVersionUID = 1L;

    public BM_SyoruiZokuseiHukaInfo() {
    }

    public BM_SyoruiZokuseiHukaInfo(C_SyoruiCdKbn pSyoruiCd) {
        super(pSyoruiCd);
    }



    private AM_SyoruiZokusei aM_SyoruiZokusei ;

    @ManyToOne (
        fetch = FetchType.LAZY,
        optional = true,
        cascade = { CascadeType.DETACH }
        )
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name=BM_SyoruiZokuseiHukaInfo.SYORUICD  , referencedColumnName=AM_SyoruiZokusei.SYORUICD, insertable=false, updatable=false)
    public  AM_SyoruiZokusei getSyoruiZokusei() {
        return aM_SyoruiZokusei;
    }

    public void setSyoruiZokusei(AM_SyoruiZokusei pAM_SyoruiZokusei) {
        this.aM_SyoruiZokusei = pAM_SyoruiZokusei;
    }

    //    private List<BT_TyouhyouOutputKengen> bT_TyouhyouOutputKengens = Lists.newLinkedList();
    //
    //    @OneToMany (
    //            fetch = FetchType.LAZY,
    //            cascade = { CascadeType.ALL },
    //            orphanRemoval = true
    //            )
    //        @JoinColumn(name=BT_TyouhyouOutputKengen.SYORUICD  , referencedColumnName=BM_SyoruiZokuseiHukaInfo.SYORUICD, insertable=false, updatable=false)
    //    @OrderBy(BT_TyouhyouOutputKengen.ROLECD+" ASC ,"+BT_TyouhyouOutputKengen.SYORUICD+" ASC ")
    //    public  List<BT_TyouhyouOutputKengen> getTyouhyouOutputKengens() {
    //        return bT_TyouhyouOutputKengens;
    //    }
    //
    //    public void setTyouhyouOutputKengens(List<BT_TyouhyouOutputKengen> pBT_TyouhyouOutputKengens) {
    //        this.bT_TyouhyouOutputKengens = pBT_TyouhyouOutputKengens;
    //    }

    private AS_SubSystem aS_SubSystem ;

    @ManyToOne (fetch = FetchType.LAZY,
        cascade = { CascadeType.DETACH }
        )
    @JoinColumn(name=BM_SyoruiZokuseiHukaInfo.SUBSYSTEMID  , referencedColumnName=AS_SubSystem.SUBSYSTEMID, insertable=false, updatable=false)
    public  AS_SubSystem getSubSystem() {
        return aS_SubSystem;
    }

    public void setSubSystem(AS_SubSystem pAS_SubSystem) {
        this.aS_SubSystem = pAS_SubSystem;
    }



}


