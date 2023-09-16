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
import yuyu.def.db.mapping.GenIT_KykUkt;

import com.google.common.collect.Lists;


/**
 * 契約受取人テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KykUkt} の JavaDoc を参照してください。<br />
 * @see     GenIT_KykUkt<br />
 * @see     PKIT_KykUkt<br />
 * @see     QIT_KykUkt<br />
 * @see     GenQIT_KykUkt<br />
 */
@Entity
public class IT_KykUkt extends GenIT_KykUkt {

    private static final long serialVersionUID = 1L;

    public IT_KykUkt() {
    }

    public IT_KykUkt(String pKbnkey,String pSyono,C_UktsyuKbn pUktsyukbn,Integer pUktsyurenno) {
        super(pKbnkey,pSyono,pUktsyukbn,pUktsyurenno);
    }

    public IT_KykUkt(String pSyono,C_UktsyuKbn pUktsyukbn,Integer pUktsyurenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pUktsyukbn,pUktsyurenno);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_KykUkt.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_KykUkt.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

    private List<IT_UketoriKouza> iT_UketoriKouzas = Lists.newLinkedList();
    public IT_UketoriKouza createUketoriKouza() {
        IT_UketoriKouza uketoriKouza =  new IT_UketoriKouza();
        uketoriKouza.setKykUkt(this);
        uketoriKouza.setKbnkey(this.getKbnkey());
        uketoriKouza.setSyono(this.getSyono());
        uketoriKouza.setUktsyukbn(this.getUktsyukbn());
        uketoriKouza.setUktsyurenno(this.getUktsyurenno());
        setUketoriKouza(uketoriKouza);
        return uketoriKouza;
    }
    @Transient
    public  IT_UketoriKouza getUketoriKouza() {
        if(getUketoriKouzas().size() == 0) {
            return null;
        }
        return getUketoriKouzas().get(0);
    }
    @Transient
    public void setUketoriKouza(IT_UketoriKouza pIT_UketoriKouza) {
        if(this.getUketoriKouzas().size() >0){
            this.getUketoriKouzas().set(0, pIT_UketoriKouza) ;
        }else{
            this.getUketoriKouzas().add(pIT_UketoriKouza) ;
        }
    }
    public void setUketoriKouzas(List<IT_UketoriKouza> pIT_UketoriKouzas) {
        this.iT_UketoriKouzas = pIT_UketoriKouzas;
    }
    @OneToMany (
        mappedBy = "kykUkt",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_UketoriKouza.SYONO+" ASC ,"+IT_UketoriKouza.UKTSYUKBN+" ASC ,"+IT_UketoriKouza.UKTSYURENNO+" ASC ")
    public  List<IT_UketoriKouza> getUketoriKouzas() {
        return iT_UketoriKouzas;
    }

}

