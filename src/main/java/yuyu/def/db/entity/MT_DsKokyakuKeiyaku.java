package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import yuyu.def.db.mapping.GenMT_DsKokyakuKeiyaku;

import com.google.common.collect.Lists;

/**
 * ＤＳ顧客契約テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsKokyakuKeiyaku} の JavaDoc を参照してください。<br />
 * @see     GenMT_DsKokyakuKeiyaku<br />
 * @see     PKMT_DsKokyakuKeiyaku<br />
 * @see     QMT_DsKokyakuKeiyaku<br />
 * @see     GenQMT_DsKokyakuKeiyaku<br />
 */
@Entity
public class MT_DsKokyakuKeiyaku extends GenMT_DsKokyakuKeiyaku {

    private static final long serialVersionUID = 1L;

    public MT_DsKokyakuKeiyaku() {
    }

    public MT_DsKokyakuKeiyaku(String pDskokno,String pSyono) {
        super(pDskokno,pSyono);
    }



    private MT_DsKokyakuKanri mT_DsKokyakuKanri ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_DsKokyakuKeiyaku.DSKOKNO  , referencedColumnName=MT_DsKokyakuKanri.DSKOKNO, insertable=false, updatable=false)
    })
    public MT_DsKokyakuKanri getDsKokyakuKanri() {
        return mT_DsKokyakuKanri;
    }

    public void setDsKokyakuKanri(MT_DsKokyakuKanri pMT_DsKokyakuKanri) {
        this.mT_DsKokyakuKanri = pMT_DsKokyakuKanri;
    }

    private List<MT_DsTorihikiServiceKanri> mT_DsTorihikiServiceKanris = Lists.newLinkedList();
    public MT_DsTorihikiServiceKanri createDsTorihikiServiceKanri() {
        MT_DsTorihikiServiceKanri dsTorihikiServiceKanri =  new MT_DsTorihikiServiceKanri();
        dsTorihikiServiceKanri.setDsKokyakuKeiyaku(this);
        dsTorihikiServiceKanri.setDskokno(this.getDskokno());
        dsTorihikiServiceKanri.setSyono(this.getSyono());
        setDsTorihikiServiceKanri(dsTorihikiServiceKanri);
        return dsTorihikiServiceKanri;
    }
    @Transient
    public  MT_DsTorihikiServiceKanri getDsTorihikiServiceKanri() {
        if(getDsTorihikiServiceKanris().size() == 0) {
            return null;
        }
        return getDsTorihikiServiceKanris().get(0);
    }
    @Transient
    public void setDsTorihikiServiceKanri(MT_DsTorihikiServiceKanri pMT_DsTorihikiServiceKanri) {
        if(this.getDsTorihikiServiceKanris().size() >0){
            this.getDsTorihikiServiceKanris().set(0, pMT_DsTorihikiServiceKanri) ;
        }else{
            this.getDsTorihikiServiceKanris().add(pMT_DsTorihikiServiceKanri) ;
        }
    }
    public void setDsTorihikiServiceKanris(List<MT_DsTorihikiServiceKanri> pMT_DsTorihikiServiceKanris) {
        this.mT_DsTorihikiServiceKanris = pMT_DsTorihikiServiceKanris;
    }
    @OneToMany (
        mappedBy = "dsKokyakuKeiyaku",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(MT_DsTorihikiServiceKanri.DSKOKNO+" ASC ,"+MT_DsTorihikiServiceKanri.SYONO+" ASC ")
    public  List<MT_DsTorihikiServiceKanri> getDsTorihikiServiceKanris() {
        return mT_DsTorihikiServiceKanris;
    }

}

