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

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.mapping.GenIT_BAK_KykUkt;

import com.google.common.collect.Lists;


/**
 * 契約受取人バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KykUkt} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KykUkt<br />
 * @see     PKIT_BAK_KykUkt<br />
 * @see     QIT_BAK_KykUkt<br />
 * @see     GenQIT_BAK_KykUkt<br />
 */
@Entity
public class IT_BAK_KykUkt extends GenIT_BAK_KykUkt {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KykUkt() {
    }

    public IT_BAK_KykUkt(String pKbnkey,String pSyono,String pTrkssikibetukey,C_UktsyuKbn pUktsyukbn,Integer pUktsyurenno) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pUktsyukbn,pUktsyurenno);
    }

    public IT_BAK_KykUkt(String pSyono,String pTrkssikibetukey,C_UktsyuKbn pUktsyukbn,Integer pUktsyurenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pUktsyukbn,pUktsyurenno);
    }


    private IT_BAK_KykKihon iT_BAKKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_KykUkt.KBNKEY  , referencedColumnName=IT_BAK_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KykUkt.SYONO  , referencedColumnName=IT_BAK_KykKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KykUkt.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KykKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KykKihon getBAKKykKihon() {
        return iT_BAKKykKihon;
    }

    public void setBAKKykKihon(IT_BAK_KykKihon pIT_BAK_KykKihon) {
        this.iT_BAKKykKihon = pIT_BAK_KykKihon;
    }

    private List<IT_BAK_UketoriKouza> iT_BAKUketoriKouzas = Lists.newLinkedList();
    public IT_BAK_UketoriKouza createBAKUketoriKouza() {
        IT_BAK_UketoriKouza bAKUketoriKouza =  new IT_BAK_UketoriKouza();
        bAKUketoriKouza.setBAKKykUkt(this);
        bAKUketoriKouza.setKbnkey(this.getKbnkey());
        bAKUketoriKouza.setSyono(this.getSyono());
        bAKUketoriKouza.setTrkssikibetukey(this.getTrkssikibetukey());
        bAKUketoriKouza.setUktsyukbn(this.getUktsyukbn());
        bAKUketoriKouza.setUktsyurenno(this.getUktsyurenno());
        setBAKUketoriKouza(bAKUketoriKouza);
        return bAKUketoriKouza;
    }
    @Transient
    public  IT_BAK_UketoriKouza getBAKUketoriKouza() {
        if(getBAKUketoriKouzas().size() == 0) {
            return null;
        }
        return getBAKUketoriKouzas().get(0);
    }
    @Transient
    public void setBAKUketoriKouza(IT_BAK_UketoriKouza pIT_BAK_UketoriKouza) {
        if(this.getBAKUketoriKouzas().size() >0){
            this.getBAKUketoriKouzas().set(0, pIT_BAK_UketoriKouza) ;
        }else{
            this.getBAKUketoriKouzas().add(pIT_BAK_UketoriKouza) ;
        }
    }
    public void setBAKUketoriKouzas(List<IT_BAK_UketoriKouza> pIT_BAK_UketoriKouzas) {
        this.iT_BAKUketoriKouzas = pIT_BAK_UketoriKouzas;
    }
    @OneToMany (
        mappedBy = "BAKKykUkt",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_UketoriKouza.SYONO+" ASC ,"+IT_BAK_UketoriKouza.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_UketoriKouza.UKTSYUKBN+" ASC ,"+IT_BAK_UketoriKouza.UKTSYURENNO+" ASC ")
    public  List<IT_BAK_UketoriKouza> getBAKUketoriKouzas() {
        return iT_BAKUketoriKouzas;
    }

}

