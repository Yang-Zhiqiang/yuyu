package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import yuyu.def.classification.C_DsTtdksyubetuKbn;
import yuyu.def.db.mapping.GenMT_DsTourokuUkKanri;

import com.google.common.collect.Lists;

/**
 * ＤＳ登録受付管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsTourokuUkKanri} の JavaDoc を参照してください。<br />
 * @see     GenMT_DsTourokuUkKanri<br />
 * @see     PKMT_DsTourokuUkKanri<br />
 * @see     QMT_DsTourokuUkKanri<br />
 * @see     GenQMT_DsTourokuUkKanri<br />
 */
@Entity
public class MT_DsTourokuUkKanri extends GenMT_DsTourokuUkKanri {

    private static final long serialVersionUID = 1L;

    public MT_DsTourokuUkKanri() {
    }

    public MT_DsTourokuUkKanri(String pSyono,C_DsTtdksyubetuKbn pDsttdksyubetukbn,Integer pDatarenno) {
        super(pSyono,pDsttdksyubetukbn,pDatarenno);
    }



    private List<MT_DsTourokuUkKouzaAnsyono> mT_DsTourokuUkKouzaAnsyonos = Lists.newLinkedList();
    public MT_DsTourokuUkKouzaAnsyono createDsTourokuUkKouzaAnsyono() {
        MT_DsTourokuUkKouzaAnsyono dsTourokuUkKouzaAnsyono =  new MT_DsTourokuUkKouzaAnsyono();
        dsTourokuUkKouzaAnsyono.setDsTourokuUkKanri(this);
        dsTourokuUkKouzaAnsyono.setSyono(this.getSyono());
        dsTourokuUkKouzaAnsyono.setDsttdksyubetukbn(this.getDsttdksyubetukbn());
        dsTourokuUkKouzaAnsyono.setDatarenno(this.getDatarenno());
        setDsTourokuUkKouzaAnsyono(dsTourokuUkKouzaAnsyono);
        return dsTourokuUkKouzaAnsyono;
    }
    @Transient
    public  MT_DsTourokuUkKouzaAnsyono getDsTourokuUkKouzaAnsyono() {
        requiredEntities(getDsTourokuUkKouzaAnsyonos(),MT_DsTourokuUkKouzaAnsyono.class);
        if(getDsTourokuUkKouzaAnsyonos().size() == 0) {
            return null;
        }
        return getDsTourokuUkKouzaAnsyonos().get(0);
    }
    @Transient
    public void setDsTourokuUkKouzaAnsyono(MT_DsTourokuUkKouzaAnsyono pMT_DsTourokuUkKouzaAnsyono) {
        if(this.getDsTourokuUkKouzaAnsyonos().size() >0){
            this.getDsTourokuUkKouzaAnsyonos().set(0, pMT_DsTourokuUkKouzaAnsyono) ;
        }else{
            this.getDsTourokuUkKouzaAnsyonos().add(pMT_DsTourokuUkKouzaAnsyono) ;
        }
    }
    public void setDsTourokuUkKouzaAnsyonos(List<MT_DsTourokuUkKouzaAnsyono> pMT_DsTourokuUkKouzaAnsyonos) {
        this.mT_DsTourokuUkKouzaAnsyonos = pMT_DsTourokuUkKouzaAnsyonos;
    }
    @OneToMany (
        mappedBy = "dsTourokuUkKanri",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(MT_DsTourokuUkKouzaAnsyono.SYONO+" ASC ,"+MT_DsTourokuUkKouzaAnsyono.DSTTDKSYUBETUKBN+" ASC ,"+MT_DsTourokuUkKouzaAnsyono.DATARENNO+" ASC ")
    public  List<MT_DsTourokuUkKouzaAnsyono> getDsTourokuUkKouzaAnsyonos() {
        return mT_DsTourokuUkKouzaAnsyonos;
    }

}

