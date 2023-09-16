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

import yuyu.def.db.mapping.GenHT_DakuhiKettei;

import com.google.common.collect.Lists;


/**
 * 諾否決定テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_DakuhiKettei} の JavaDoc を参照してください。<br />
 * @see     GenHT_DakuhiKettei<br />
 * @see     PKHT_DakuhiKettei<br />
 * @see     QHT_DakuhiKettei<br />
 * @see     GenQHT_DakuhiKettei<br />
 */
@Entity
public class HT_DakuhiKettei extends GenHT_DakuhiKettei {

    private static final long serialVersionUID = 1L;

    public HT_DakuhiKettei() {
    }

    public HT_DakuhiKettei(String pMosno,Integer pDakuhiktrenno) {
        super(pMosno,pDakuhiktrenno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_DakuhiKettei.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

    private List<HT_TokujyouRireki> hT_TokujyouRirekis = Lists.newLinkedList();
    public HT_TokujyouRireki createTokujyouRireki() {
        HT_TokujyouRireki tokujyouRireki =  new HT_TokujyouRireki();
        tokujyouRireki.setDakuhiKettei(this);
        tokujyouRireki.setMosno(this.getMosno());
        tokujyouRireki.setDakuhiktrenno(this.getDakuhiktrenno());
        setTokujyouRireki(tokujyouRireki);
        return tokujyouRireki;
    }
    @Transient
    public  HT_TokujyouRireki getTokujyouRireki() {
        if(getTokujyouRirekis().size() == 0) {
            return null;
        }
        return getTokujyouRirekis().get(0);
    }
    @Transient
    public void setTokujyouRireki(HT_TokujyouRireki pHT_TokujyouRireki) {
        if(this.getTokujyouRirekis().size() >0){
            this.getTokujyouRirekis().set(0, pHT_TokujyouRireki) ;
        }else{
            this.getTokujyouRirekis().add(pHT_TokujyouRireki) ;
        }
    }
    public void setTokujyouRirekis(List<HT_TokujyouRireki> pHT_TokujyouRirekis) {
        this.hT_TokujyouRirekis = pHT_TokujyouRirekis;
    }
    @OneToMany (
        mappedBy = "dakuhiKettei",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(HT_TokujyouRireki.MOSNO+" ASC ,"+HT_TokujyouRireki.DAKUHIKTRENNO+" ASC ")
    public  List<HT_TokujyouRireki> getTokujyouRirekis() {
        return hT_TokujyouRirekis;
    }

    private List<HT_SyouhnTokujyouRireki> hT_SyouhnTokujyouRirekis = Lists.newLinkedList();
    public HT_SyouhnTokujyouRireki createSyouhnTokujyouRireki() {
        HT_SyouhnTokujyouRireki syouhnTokujyouRireki =  new HT_SyouhnTokujyouRireki();
        syouhnTokujyouRireki.setDakuhiKettei(this);
        syouhnTokujyouRireki.setMosno(this.getMosno());
        syouhnTokujyouRireki.setDakuhiktrenno(this.getDakuhiktrenno());
        getSyouhnTokujyouRirekis().add(syouhnTokujyouRireki);
        return syouhnTokujyouRireki;
    }
    public void setSyouhnTokujyouRirekis(List<HT_SyouhnTokujyouRireki> pHT_SyouhnTokujyouRirekis) {
        this.hT_SyouhnTokujyouRirekis = pHT_SyouhnTokujyouRirekis;
    }
    @OneToMany (
        mappedBy = "dakuhiKettei",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(HT_SyouhnTokujyouRireki.MOSNO+" ASC ,"+HT_SyouhnTokujyouRireki.DAKUHIKTRENNO+" ASC ,"+HT_SyouhnTokujyouRireki.SYOUHNCD+" ASC ")
    public  List<HT_SyouhnTokujyouRireki> getSyouhnTokujyouRirekis() {
        return hT_SyouhnTokujyouRirekis;
    }

    private List<HT_SonotaTkykJktkRireki> hT_SonotaTkykJktkRirekis = Lists.newLinkedList();
    public HT_SonotaTkykJktkRireki createSonotaTkykJktkRireki() {
        HT_SonotaTkykJktkRireki sonotaTkykJktkRireki =  new HT_SonotaTkykJktkRireki();
        sonotaTkykJktkRireki.setDakuhiKettei(this);
        sonotaTkykJktkRireki.setMosno(this.getMosno());
        sonotaTkykJktkRireki.setDakuhiktrenno(this.getDakuhiktrenno());
        getSonotaTkykJktkRirekis().add(sonotaTkykJktkRireki);
        return sonotaTkykJktkRireki;
    }
    public void setSonotaTkykJktkRirekis(List<HT_SonotaTkykJktkRireki> pHT_SonotaTkykJktkRirekis) {
        this.hT_SonotaTkykJktkRirekis = pHT_SonotaTkykJktkRirekis;
    }
    @OneToMany (
        mappedBy = "dakuhiKettei",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(HT_SonotaTkykJktkRireki.MOSNO+" ASC ,"+HT_SonotaTkykJktkRireki.DAKUHIKTRENNO+" ASC ,"+HT_SonotaTkykJktkRireki.PMNJTKKBN+" ASC ")
    public  List<HT_SonotaTkykJktkRireki> getSonotaTkykJktkRirekis() {
        return hT_SonotaTkykJktkRirekis;
    }

    private BM_Syoubyou bM_Syoubyou1 ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_DakuhiKettei.SYOUBYOUCD1  , referencedColumnName=BM_Syoubyou.SYOUBYOUCD, insertable=false, updatable=false)
    })
    public  BM_Syoubyou getSyoubyou1() {
        return bM_Syoubyou1;
    }

    public void setSyoubyou1(BM_Syoubyou pBM_Syoubyou) {
        this.bM_Syoubyou1 = pBM_Syoubyou;
    }

    private BM_Syoubyou bM_Syoubyou2 ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_DakuhiKettei.SYOUBYOUCD2  , referencedColumnName=BM_Syoubyou.SYOUBYOUCD, insertable=false, updatable=false)
    })
    public  BM_Syoubyou getSyoubyou2() {
        return bM_Syoubyou2;
    }

    public void setSyoubyou2(BM_Syoubyou pBM_Syoubyou) {
        this.bM_Syoubyou2 = pBM_Syoubyou;
    }

    private HM_KetteiSya hM_KetteiSya ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_DakuhiKettei.KETSYACD  , referencedColumnName=HM_KetteiSya.KETSYACD, insertable=false, updatable=false)
    })
    public  HM_KetteiSya getKetteiSya() {
        return hM_KetteiSya;
    }

    public void setKetteiSya(HM_KetteiSya pHM_KetteiSya) {
        this.hM_KetteiSya = pHM_KetteiSya;
    }

}

