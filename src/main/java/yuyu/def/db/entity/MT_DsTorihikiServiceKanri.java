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

import yuyu.def.db.mapping.GenMT_DsTorihikiServiceKanri;

import com.google.common.collect.Lists;

/**
 * ＤＳ取引サービス管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsTorihikiServiceKanri} の JavaDoc を参照してください。<br />
 * @see     GenMT_DsTorihikiServiceKanri<br />
 * @see     PKMT_DsTorihikiServiceKanri<br />
 * @see     QMT_DsTorihikiServiceKanri<br />
 * @see     GenQMT_DsTorihikiServiceKanri<br />
 */
@Entity
public class MT_DsTorihikiServiceKanri extends GenMT_DsTorihikiServiceKanri {

    private static final long serialVersionUID = 1L;

    public MT_DsTorihikiServiceKanri() {
    }

    public MT_DsTorihikiServiceKanri(String pDskokno,String pSyono) {
        super(pDskokno,pSyono);
    }



    private MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_DsTorihikiServiceKanri.DSKOKNO  , referencedColumnName=MT_DsKokyakuKeiyaku.DSKOKNO, insertable=false, updatable=false),
        @JoinColumn(name=MT_DsTorihikiServiceKanri.SYONO  , referencedColumnName=MT_DsKokyakuKeiyaku.SYONO, insertable=false, updatable=false)
    })
    public MT_DsKokyakuKeiyaku getDsKokyakuKeiyaku() {
        return mT_DsKokyakuKeiyaku;
    }

    public void setDsKokyakuKeiyaku(MT_DsKokyakuKeiyaku pMT_DsKokyakuKeiyaku) {
        this.mT_DsKokyakuKeiyaku = pMT_DsKokyakuKeiyaku;
    }

    private List<MT_DsSoukinyouKouza> mT_DsSoukinyouKouza = Lists.newLinkedList();
    public MT_DsSoukinyouKouza createDsSoukinyouKouza() {
        MT_DsSoukinyouKouza dsSoukinyouKouza =  new MT_DsSoukinyouKouza();
        dsSoukinyouKouza.setDsTorihikiServiceKanri(this);
        dsSoukinyouKouza.setDskokno(this.getDskokno());
        dsSoukinyouKouza.setSyono(this.getSyono());
        getDsSoukinyouKouzas().add(dsSoukinyouKouza);
        return dsSoukinyouKouza;
    }
    public void setDsSoukinyouKouzas(List<MT_DsSoukinyouKouza> pMT_DsSoukinyouKouzas) {
        this.mT_DsSoukinyouKouza = pMT_DsSoukinyouKouzas;
    }
    @OneToMany (
        mappedBy = "dsTorihikiServiceKanri",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(MT_DsSoukinyouKouza.DSKOKNO+" ASC ,"+MT_DsSoukinyouKouza.SYONO+" ASC ,"+MT_DsSoukinyouKouza.KZSYURUIKBN+" ASC ")
    public  List<MT_DsSoukinyouKouza> getDsSoukinyouKouzas() {
        return mT_DsSoukinyouKouza;
    }

    private List<MT_DsTorihikiyouAnsyono> mT_DsTorihikiyouAnsyonos = Lists.newLinkedList();
    public MT_DsTorihikiyouAnsyono createDsTorihikiyouAnsyono() {
        MT_DsTorihikiyouAnsyono dsTorihikiyouAnsyono =  new MT_DsTorihikiyouAnsyono();
        dsTorihikiyouAnsyono.setDsTorihikiServiceKanri(this);
        dsTorihikiyouAnsyono.setDskokno(this.getDskokno());
        dsTorihikiyouAnsyono.setSyono(this.getSyono());
        setDsTorihikiyouAnsyono(dsTorihikiyouAnsyono);
        return dsTorihikiyouAnsyono;
    }
    @Transient
    public  MT_DsTorihikiyouAnsyono getDsTorihikiyouAnsyono() {
        requiredEntities(getDsTorihikiyouAnsyonos(),MT_DsTorihikiyouAnsyono.class);
        if(getDsTorihikiyouAnsyonos().size() == 0) {
            return null;
        }
        return getDsTorihikiyouAnsyonos().get(0);
    }
    @Transient
    public void setDsTorihikiyouAnsyono(MT_DsTorihikiyouAnsyono pMT_DsTorihikiyouAnsyono) {
        if(this.getDsTorihikiyouAnsyonos().size() >0){
            this.getDsTorihikiyouAnsyonos().set(0, pMT_DsTorihikiyouAnsyono) ;
        }else{
            this.getDsTorihikiyouAnsyonos().add(pMT_DsTorihikiyouAnsyono) ;
        }
    }
    public void setDsTorihikiyouAnsyonos(List<MT_DsTorihikiyouAnsyono> pMT_DsTorihikiyouAnsyonos) {
        this.mT_DsTorihikiyouAnsyonos = pMT_DsTorihikiyouAnsyonos;
    }
    @OneToMany (
        mappedBy = "dsTorihikiServiceKanri",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(MT_DsTorihikiyouAnsyono.DSKOKNO+" ASC ,"+MT_DsTorihikiyouAnsyono.SYONO+" ASC ")
    public  List<MT_DsTorihikiyouAnsyono> getDsTorihikiyouAnsyonos() {
        return mT_DsTorihikiyouAnsyonos;
    }

}

