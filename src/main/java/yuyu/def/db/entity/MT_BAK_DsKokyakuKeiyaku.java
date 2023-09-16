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

import yuyu.def.db.mapping.GenMT_BAK_DsKokyakuKeiyaku;

import com.google.common.collect.Lists;

/**
 * ＤＳ顧客契約バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_BAK_DsKokyakuKeiyaku} の JavaDoc を参照してください。<br />
 * @see     GenMT_BAK_DsKokyakuKeiyaku<br />
 * @see     PKMT_BAK_DsKokyakuKeiyaku<br />
 * @see     QMT_BAK_DsKokyakuKeiyaku<br />
 * @see     GenQMT_BAK_DsKokyakuKeiyaku<br />
 */
@Entity
public class MT_BAK_DsKokyakuKeiyaku extends GenMT_BAK_DsKokyakuKeiyaku {

    private static final long serialVersionUID = 1L;

    public MT_BAK_DsKokyakuKeiyaku() {
    }

    public MT_BAK_DsKokyakuKeiyaku(String pDskokno,String pSyono,String pTrkssikibetukey) {
        super(pDskokno,pSyono,pTrkssikibetukey);
    }



    private MT_BAK_DsKokyakuKanri mT_BAKDsKokyakuKanri ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_BAK_DsKokyakuKeiyaku.DSKOKNO  , referencedColumnName=MT_BAK_DsKokyakuKanri.DSKOKNO, insertable=false, updatable=false),
        @JoinColumn(name=MT_BAK_DsKokyakuKeiyaku.TRKSSIKIBETUKEY  , referencedColumnName=MT_BAK_DsKokyakuKanri.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public MT_BAK_DsKokyakuKanri getBAKDsKokyakuKanri() {
        return mT_BAKDsKokyakuKanri;
    }

    public void setBAKDsKokyakuKanri(MT_BAK_DsKokyakuKanri pMT_BAK_DsKokyakuKanri) {
        this.mT_BAKDsKokyakuKanri = pMT_BAK_DsKokyakuKanri;
    }

    private List<MT_BAK_DsTorihikiServiceKanri> mT_BAKDsTorihikiServiceKanris = Lists.newLinkedList();
    public MT_BAK_DsTorihikiServiceKanri createBAKDsTorihikiServiceKanri() {
        MT_BAK_DsTorihikiServiceKanri bAKDsTorihikiServiceKanri =  new MT_BAK_DsTorihikiServiceKanri();
        bAKDsTorihikiServiceKanri.setBAKDsKokyakuKeiyaku(this);
        bAKDsTorihikiServiceKanri.setDskokno(this.getDskokno());
        bAKDsTorihikiServiceKanri.setSyono(this.getSyono());
        bAKDsTorihikiServiceKanri.setTrkssikibetukey(this.getTrkssikibetukey());
        setBAKDsTorihikiServiceKanri(bAKDsTorihikiServiceKanri);
        return bAKDsTorihikiServiceKanri;
    }
    @Transient
    public  MT_BAK_DsTorihikiServiceKanri getBAKDsTorihikiServiceKanri() {
        if(getBAKDsTorihikiServiceKanris().size() == 0) {
            return null;
        }
        return getBAKDsTorihikiServiceKanris().get(0);
    }
    @Transient
    public void setBAKDsTorihikiServiceKanri(MT_BAK_DsTorihikiServiceKanri pMT_BAK_DsTorihikiServiceKanri) {
        if(this.getBAKDsTorihikiServiceKanris().size() >0){
            this.getBAKDsTorihikiServiceKanris().set(0, pMT_BAK_DsTorihikiServiceKanri) ;
        }else{
            this.getBAKDsTorihikiServiceKanris().add(pMT_BAK_DsTorihikiServiceKanri) ;
        }
    }
    public void setBAKDsTorihikiServiceKanris(List<MT_BAK_DsTorihikiServiceKanri> pMT_BAK_DsTorihikiServiceKanris) {
        this.mT_BAKDsTorihikiServiceKanris = pMT_BAK_DsTorihikiServiceKanris;
    }
    @OneToMany (
        mappedBy = "BAKDsKokyakuKeiyaku",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(MT_BAK_DsTorihikiServiceKanri.DSKOKNO+" ASC ,"+MT_BAK_DsTorihikiServiceKanri.SYONO+" ASC ,"+MT_BAK_DsTorihikiServiceKanri.TRKSSIKIBETUKEY+" ASC ")
    public  List<MT_BAK_DsTorihikiServiceKanri> getBAKDsTorihikiServiceKanris() {
        return mT_BAKDsTorihikiServiceKanris;
    }

}

