package yuyu.def.db.entity;

import javax.persistence.Transient;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.db.mapping.GenHT_BosKihon;
import yuyu.def.sinkeiyaku.predicate.FilterBosSyouhnBySyutkkbn;
import yuyu.def.sinkeiyaku.predicate.FilterBosUketoriKouzaJyouhouByUktkzsyubetukbn;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


/**
 * 募集基本テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_BosKihon} の JavaDoc を参照してください。<br />
 * @see     GenHT_BosKihon<br />
 * @see     PKHT_BosKihon<br />
 * @see     QHT_BosKihon<br />
 * @see     GenQHT_BosKihon<br />
 */
@Entity
public class HT_BosKihon extends GenHT_BosKihon {

    private static final long serialVersionUID = 1L;

    public HT_BosKihon() {
    }

    public HT_BosKihon(String pMosno) {
        super(pMosno);
    }



    private List<HT_BosSyouhn> hT_BosSyouhns = Lists.newLinkedList();
    public HT_BosSyouhn createBosSyouhn() {
        HT_BosSyouhn bosSyouhn =  new HT_BosSyouhn();
        bosSyouhn.setBosKihon(this);
        bosSyouhn.setMosno(this.getMosno());
        getBosSyouhns().add(bosSyouhn);
        return bosSyouhn;
    }
    public void setBosSyouhns(List<HT_BosSyouhn> pHT_BosSyouhns) {
        this.hT_BosSyouhns = pHT_BosSyouhns;
    }
    @OneToMany (
        mappedBy = "bosKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_BosSyouhn.MOSNO+" ASC ,"+HT_BosSyouhn.SYOUHNCD+" ASC ")
    public  List<HT_BosSyouhn> getBosSyouhns() {
        return hT_BosSyouhns;
    }

    private List<HT_BosKokutisyo> hT_BosKokutisyoss = Lists.newLinkedList();
    public HT_BosKokutisyo createBosKokutisyo() {
        HT_BosKokutisyo bosKokutisyo =  new HT_BosKokutisyo();
        bosKokutisyo.setBosKihon(this);
        bosKokutisyo.setMosno(this.getMosno());
        setBosKokutisyo(bosKokutisyo);
        return bosKokutisyo;
    }
    @Transient
    public  HT_BosKokutisyo getBosKokutisyo() {
        if(getBosKokutisyos().size() == 0) {
            return null;
        }
        return getBosKokutisyos().get(0);
    }
    @Transient
    public void setBosKokutisyo(HT_BosKokutisyo pHT_BosKokutisyo) {
        if(this.getBosKokutisyos().size() >0){
            this.getBosKokutisyos().set(0, pHT_BosKokutisyo) ;
        }else{
            this.getBosKokutisyos().add(pHT_BosKokutisyo) ;
        }
    }
    public void setBosKokutisyos(List<HT_BosKokutisyo> pHT_BosKokutisyos) {
        this.hT_BosKokutisyoss = pHT_BosKokutisyos;
    }
    @OneToMany (
        mappedBy = "bosKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_BosKokutisyo.MOSNO+" ASC ")
    public  List<HT_BosKokutisyo> getBosKokutisyos() {
        return hT_BosKokutisyoss;
    }

    private List<HT_BosUketorinin> hT_BosUketorinins = Lists.newLinkedList();
    public HT_BosUketorinin createBosUketorinin() {
        HT_BosUketorinin bosUketorinin =  new HT_BosUketorinin();
        bosUketorinin.setBosKihon(this);
        bosUketorinin.setMosno(this.getMosno());
        getBosUketorinins().add(bosUketorinin);
        return bosUketorinin;
    }
    public void setBosUketorinins(List<HT_BosUketorinin> pHT_BosUketorinins) {
        this.hT_BosUketorinins = pHT_BosUketorinins;
    }
    @OneToMany (
        mappedBy = "bosKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_BosUketorinin.MOSNO+" ASC ,"+HT_BosUketorinin.UKTSYUKBN+" ASC ,"+HT_BosUketorinin.UKTSYURENNO+" ASC ")
    public  List<HT_BosUketorinin> getBosUketorinins() {
        return hT_BosUketorinins;
    }

    private List<HT_BosDairiten> hT_BosDairitens = Lists.newLinkedList();
    public HT_BosDairiten createBosDairiten() {
        HT_BosDairiten bosDairiten =  new HT_BosDairiten();
        bosDairiten.setBosKihon(this);
        bosDairiten.setMosno(this.getMosno());
        getBosDairitens().add(bosDairiten);
        return bosDairiten;
    }
    public void setBosDairitens(List<HT_BosDairiten> pHT_BosDairitens) {
        this.hT_BosDairitens = pHT_BosDairitens;
    }
    @OneToMany (
        mappedBy = "bosKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_BosDairiten.MOSNO+" ASC ,"+HT_BosDairiten.RENNO+" ASC ")
    public  List<HT_BosDairiten> getBosDairitens() {
        return hT_BosDairitens;
    }

    private List<HT_BosUketoriKouzaJyouhou> hT_BosUketoriKouzaJyouhous = Lists.newLinkedList();
    public HT_BosUketoriKouzaJyouhou createBosUketoriKouzaJyouhou() {
        HT_BosUketoriKouzaJyouhou bosUketoriKouzaJyouhou =  new HT_BosUketoriKouzaJyouhou();
        bosUketoriKouzaJyouhou.setBosKihon(this);
        bosUketoriKouzaJyouhou.setMosno(this.getMosno());
        getBosUketoriKouzaJyouhous().add(bosUketoriKouzaJyouhou);
        return bosUketoriKouzaJyouhou;
    }
    public void setBosUketoriKouzaJyouhous(List<HT_BosUketoriKouzaJyouhou> pHT_BosUketoriKouzaJyouhous) {
        this.hT_BosUketoriKouzaJyouhous = pHT_BosUketoriKouzaJyouhous;
    }
    @OneToMany (
        mappedBy = "bosKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_BosUketoriKouzaJyouhou.MOSNO+" ASC ,"+HT_BosUketoriKouzaJyouhou.UKTKZSYUBETUKBN+" ASC ")
    public  List<HT_BosUketoriKouzaJyouhou> getBosUketoriKouzaJyouhous() {
        return hT_BosUketoriKouzaJyouhous;
    }

    private List<HT_BosKouzaJyouhou> hT_BosKouzaJyouhous = Lists.newLinkedList();
    public HT_BosKouzaJyouhou createBosKouzaJyouhou() {
        HT_BosKouzaJyouhou bosKouzaJyouhou =  new HT_BosKouzaJyouhou();
        bosKouzaJyouhou.setBosKihon(this);
        bosKouzaJyouhou.setMosno(this.getMosno());
        setBosKouzaJyouhou(bosKouzaJyouhou);
        return bosKouzaJyouhou;
    }
    @Transient
    public  HT_BosKouzaJyouhou getBosKouzaJyouhou() {
        if(getBosKouzaJyouhous().size() == 0) {
            return null;
        }
        return getBosKouzaJyouhous().get(0);
    }
    @Transient
    public void setBosKouzaJyouhou(HT_BosKouzaJyouhou pHT_BosKouzaJyouhou) {
        if(this.getBosKouzaJyouhous().size() >0){
            this.getBosKouzaJyouhous().set(0, pHT_BosKouzaJyouhou) ;
        }else{
            this.getBosKouzaJyouhous().add(pHT_BosKouzaJyouhou) ;
        }
    }
    public void setBosKouzaJyouhous(List<HT_BosKouzaJyouhou> pHT_BosKouzaJyouhous) {
        this.hT_BosKouzaJyouhous = pHT_BosKouzaJyouhous;
    }
    @OneToMany (
        mappedBy = "bosKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_BosKouzaJyouhou.MOSNO+" ASC ")
    public  List<HT_BosKouzaJyouhou> getBosKouzaJyouhous() {
        return hT_BosKouzaJyouhous;
    }

    private List<HT_BosKoumokuCheckError> hT_BosKoumokuCheckErrors = Lists.newLinkedList();
    public HT_BosKoumokuCheckError createBosKoumokuCheckError() {
        HT_BosKoumokuCheckError bosKoumokuCheckError =  new HT_BosKoumokuCheckError();
        bosKoumokuCheckError.setBosKihon(this);
        bosKoumokuCheckError.setMosno(this.getMosno());
        getBosKoumokuCheckErrors().add(bosKoumokuCheckError);
        return bosKoumokuCheckError;
    }
    public void setBosKoumokuCheckErrors(List<HT_BosKoumokuCheckError> pHT_BosKoumokuCheckErrors) {
        this.hT_BosKoumokuCheckErrors = pHT_BosKoumokuCheckErrors;
    }
    @OneToMany (
        mappedBy = "bosKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_BosKoumokuCheckError.MOSNO+" ASC ,"+HT_BosKoumokuCheckError.RENNO3KETA+" ASC ")
    public  List<HT_BosKoumokuCheckError> getBosKoumokuCheckErrors() {
        return hT_BosKoumokuCheckErrors;
    }

    private BM_Syokugyou bM_Syokugyou ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_BosKihon.HHKNSYKGYCD  , referencedColumnName=BM_Syokugyou.SYOKUGYOUCD, insertable=false, updatable=false)
    })
    public  BM_Syokugyou getSyokugyou() {
        return bM_Syokugyou;
    }

    public void setSyokugyou(BM_Syokugyou pBM_Syokugyou) {
        this.bM_Syokugyou = pBM_Syokugyou;
    }

    private List<HT_BosTrkKzk> hT_BosTrkKzks = Lists.newLinkedList();
    public HT_BosTrkKzk createBosTrkKzk() {
        HT_BosTrkKzk bosTrkKzk =  new HT_BosTrkKzk();
        bosTrkKzk.setBosKihon(this);
        bosTrkKzk.setMosno(this.getMosno());
        getBosTrkKzks().add(bosTrkKzk);
        return bosTrkKzk;
    }
    public void setBosTrkKzks(List<HT_BosTrkKzk> pHT_BosTrkKzks) {
        this.hT_BosTrkKzks = pHT_BosTrkKzks;
    }
    @OneToMany (
        mappedBy = "bosKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_BosTrkKzk.MOSNO+" ASC ,"+HT_BosTrkKzk.TRKKZKKBN+" ASC ")
    public  List<HT_BosTrkKzk> getBosTrkKzks() {
        return hT_BosTrkKzks;
    }

    @Transient
    public  List<HT_BosSyouhn> getBosSyouhnsBySyutkkbn(C_SyutkKbn pSyutkkbn) {
        return new ArrayList<HT_BosSyouhn>(Collections2.filter(getBosSyouhns(),
            new FilterBosSyouhnBySyutkkbn(pSyutkkbn)));
    }
    @Transient
    public  HT_BosUketoriKouzaJyouhou getBosUketoriKouzaJyouhouByUktkzsyubetukbn(C_UketorikouzasyubetuKbn pUktkzsyubetukbn) {
        return Iterables.getFirst(Iterables.filter(getBosUketoriKouzaJyouhous(),
            new FilterBosUketoriKouzaJyouhouByUktkzsyubetukbn(pUktkzsyubetukbn)), null);
    }
}

