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

import yuyu.def.db.mapping.GenMT_BAK_DsTorihikiServiceKanri;

import com.google.common.collect.Lists;

/**
 * ＤＳ取引サービス管理バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_BAK_DsTorihikiServiceKanri} の JavaDoc を参照してください。<br />
 * @see     GenMT_BAK_DsTorihikiServiceKanri<br />
 * @see     PKMT_BAK_DsTorihikiServiceKanri<br />
 * @see     QMT_BAK_DsTorihikiServiceKanri<br />
 * @see     GenQMT_BAK_DsTorihikiServiceKanri<br />
 */
@Entity
public class MT_BAK_DsTorihikiServiceKanri extends GenMT_BAK_DsTorihikiServiceKanri {

    private static final long serialVersionUID = 1L;

    public MT_BAK_DsTorihikiServiceKanri() {
    }

    public MT_BAK_DsTorihikiServiceKanri(String pDskokno,String pSyono,String pTrkssikibetukey) {
        super(pDskokno,pSyono,pTrkssikibetukey);
    }



    private MT_BAK_DsKokyakuKeiyaku mT_BAKDsKokyakuKeiyaku ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_BAK_DsTorihikiServiceKanri.DSKOKNO  , referencedColumnName=MT_BAK_DsKokyakuKeiyaku.DSKOKNO, insertable=false, updatable=false),
        @JoinColumn(name=MT_BAK_DsTorihikiServiceKanri.SYONO  , referencedColumnName=MT_BAK_DsKokyakuKeiyaku.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=MT_BAK_DsTorihikiServiceKanri.TRKSSIKIBETUKEY  , referencedColumnName=MT_BAK_DsKokyakuKeiyaku.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public MT_BAK_DsKokyakuKeiyaku getBAKDsKokyakuKeiyaku() {
        return mT_BAKDsKokyakuKeiyaku;
    }

    public void setBAKDsKokyakuKeiyaku(MT_BAK_DsKokyakuKeiyaku pMT_BAK_DsKokyakuKeiyaku) {
        this.mT_BAKDsKokyakuKeiyaku = pMT_BAK_DsKokyakuKeiyaku;
    }

    private List<MT_BAK_DsSoukinyouKouza> mT_BAKDsSoukinyouKouza = Lists.newLinkedList();
    public MT_BAK_DsSoukinyouKouza createBAKDsSoukinyouKouza() {
        MT_BAK_DsSoukinyouKouza bAKDsSoukinyouKouza =  new MT_BAK_DsSoukinyouKouza();
        bAKDsSoukinyouKouza.setBAKDsTorihikiServiceKanri(this);
        bAKDsSoukinyouKouza.setDskokno(this.getDskokno());
        bAKDsSoukinyouKouza.setSyono(this.getSyono());
        bAKDsSoukinyouKouza.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKDsSoukinyouKouzas().add(bAKDsSoukinyouKouza);
        return bAKDsSoukinyouKouza;
    }
    public void setBAKDsSoukinyouKouzas(List<MT_BAK_DsSoukinyouKouza> pMT_BAK_DsSoukinyouKouzas) {
        this.mT_BAKDsSoukinyouKouza = pMT_BAK_DsSoukinyouKouzas;
    }
    @OneToMany (
        mappedBy = "BAKDsTorihikiServiceKanri",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(MT_BAK_DsSoukinyouKouza.DSKOKNO+" ASC ,"+MT_BAK_DsSoukinyouKouza.SYONO+" ASC ,"+MT_BAK_DsSoukinyouKouza.KZSYURUIKBN+" ASC ,"+MT_BAK_DsSoukinyouKouza.TRKSSIKIBETUKEY+" ASC ")
    public  List<MT_BAK_DsSoukinyouKouza> getBAKDsSoukinyouKouzas() {
        return mT_BAKDsSoukinyouKouza;
    }

    private List<MT_BAK_DsTorihikiyouAnsyono> mT_BAKDsTorihikiyouAnsyonos = Lists.newLinkedList();
    public MT_BAK_DsTorihikiyouAnsyono createBAKDsTorihikiyouAnsyono() {
        MT_BAK_DsTorihikiyouAnsyono bAKDsTorihikiyouAnsyono =  new MT_BAK_DsTorihikiyouAnsyono();
        bAKDsTorihikiyouAnsyono.setBAKDsTorihikiServiceKanri(this);
        bAKDsTorihikiyouAnsyono.setDskokno(this.getDskokno());
        bAKDsTorihikiyouAnsyono.setSyono(this.getSyono());
        bAKDsTorihikiyouAnsyono.setTrkssikibetukey(this.getTrkssikibetukey());
        setBAKDsTorihikiyouAnsyono(bAKDsTorihikiyouAnsyono);
        return bAKDsTorihikiyouAnsyono;
    }
    @Transient
    public  MT_BAK_DsTorihikiyouAnsyono getBAKDsTorihikiyouAnsyono() {
        requiredEntities(getBAKDsTorihikiyouAnsyonos(),MT_BAK_DsTorihikiyouAnsyono.class);
        if(getBAKDsTorihikiyouAnsyonos().size() == 0) {
            return null;
        }
        return getBAKDsTorihikiyouAnsyonos().get(0);
    }
    @Transient
    public void setBAKDsTorihikiyouAnsyono(MT_BAK_DsTorihikiyouAnsyono pMT_BAK_DsTorihikiyouAnsyono) {
        if(this.getBAKDsTorihikiyouAnsyonos().size() >0){
            this.getBAKDsTorihikiyouAnsyonos().set(0, pMT_BAK_DsTorihikiyouAnsyono) ;
        }else{
            this.getBAKDsTorihikiyouAnsyonos().add(pMT_BAK_DsTorihikiyouAnsyono) ;
        }
    }
    public void setBAKDsTorihikiyouAnsyonos(List<MT_BAK_DsTorihikiyouAnsyono> pMT_BAK_DsTorihikiyouAnsyonos) {
        this.mT_BAKDsTorihikiyouAnsyonos = pMT_BAK_DsTorihikiyouAnsyonos;
    }
    @OneToMany (
        mappedBy = "BAKDsTorihikiServiceKanri",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(MT_BAK_DsTorihikiyouAnsyono.DSKOKNO+" ASC ,"+MT_BAK_DsTorihikiyouAnsyono.SYONO+" ASC ,"+MT_BAK_DsTorihikiyouAnsyono.TRKSSIKIBETUKEY+" ASC ")
    public  List<MT_BAK_DsTorihikiyouAnsyono> getBAKDsTorihikiyouAnsyonos() {
        return mT_BAKDsTorihikiyouAnsyonos;
    }

}

