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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.mapping.GenJT_SiKykKihon;
import yuyu.def.siharai.predicate.FilterSiKykSyouhnBySyutkkbnSyouhncdItems;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


/**
 * 支払契約基本テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SiKykKihon} の JavaDoc を参照してください。<br />
 * @see     GenJT_SiKykKihon<br />
 * @see     PKJT_SiKykKihon<br />
 * @see     QJT_SiKykKihon<br />
 * @see     GenQJT_SiKykKihon<br />
 */
@Entity
public class JT_SiKykKihon extends GenJT_SiKykKihon {

    private static final long serialVersionUID = 1L;

    public JT_SiKykKihon() {
    }

    public JT_SiKykKihon(String pSyono) {
        super(pSyono);
    }



    private List<JT_SiKykSyouhn> jT_SiKykSyouhns = Lists.newLinkedList();
    public JT_SiKykSyouhn createSiKykSyouhn() {
        JT_SiKykSyouhn siKykSyouhn =  new JT_SiKykSyouhn();
        siKykSyouhn.setSiKykKihon(this);
        siKykSyouhn.setSyono(this.getSyono());
        getSiKykSyouhns().add(siKykSyouhn);
        return siKykSyouhn;
    }
    public void setSiKykSyouhns(List<JT_SiKykSyouhn> pJT_SiKykSyouhns) {
        this.jT_SiKykSyouhns = pJT_SiKykSyouhns;
    }
    @OneToMany (
        mappedBy = "siKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_SiKykSyouhn.SYONO+" ASC ,"+JT_SiKykSyouhn.SYUTKKBN+" ASC ,"+JT_SiKykSyouhn.SYOUHNCD+" ASC ,"+JT_SiKykSyouhn.KYHGNDKATAKBN+" ASC ,"+JT_SiKykSyouhn.SYOUHNSDNO+" ASC ,"+JT_SiKykSyouhn.KYKSYOUHNRENNO+" ASC ")
    public  List<JT_SiKykSyouhn> getSiKykSyouhns() {
        return jT_SiKykSyouhns;
    }

    private List<JT_SiUkt> jT_SiUkts = Lists.newLinkedList();
    public JT_SiUkt createSiUkt() {
        JT_SiUkt siUkt =  new JT_SiUkt();
        siUkt.setSiKykKihon(this);
        siUkt.setSyono(this.getSyono());
        getSiUkts().add(siUkt);
        return siUkt;
    }
    public void setSiUkts(List<JT_SiUkt> pJT_SiUkts) {
        this.jT_SiUkts = pJT_SiUkts;
    }
    @OneToMany (
        mappedBy = "siKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_SiUkt.SYONO+" ASC ,"+JT_SiUkt.HKUKTSYU+" ASC ,"+JT_SiUkt.UKTSYURENNO+" ASC ")
    public  List<JT_SiUkt> getSiUkts() {
        return jT_SiUkts;
    }

    private BM_Ginkou bM_Ginkou ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=JT_SiKykKihon.BANKCD  , referencedColumnName=BM_Ginkou.BANKCD, insertable=false, updatable=false),
        @JoinColumn(name=JT_SiKykKihon.SITENCD  , referencedColumnName=BM_Ginkou.SITENCD, insertable=false, updatable=false)
    })
    public  BM_Ginkou getGinkou() {
        return bM_Ginkou;
    }

    public void setGinkou(BM_Ginkou pBM_Ginkou) {
        this.bM_Ginkou = pBM_Ginkou;
    }

    @Transient
    public  JT_SiKykSyouhn getSiKykSyouhnBySyutkkbnSyouhncdItems(C_SyutkKbn pSyutkkbn,String pSyouhncd,C_KyhgndkataKbn pKyhgndkatakbn,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        return Iterables.getFirst(Iterables.filter(getSiKykSyouhns(),
            new FilterSiKykSyouhnBySyutkkbnSyouhncdItems(pSyutkkbn, pSyouhncd, pKyhgndkatakbn, pSyouhnsdno, pKyksyouhnrenno)), null);
    }
}

