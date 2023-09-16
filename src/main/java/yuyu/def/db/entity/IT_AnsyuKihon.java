package yuyu.def.db.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.db.mapping.GenIT_AnsyuKihon;
import yuyu.def.hozen.predicate.FilterAnsyuRirekiByAnnaijkkbn;
import yuyu.def.hozen.predicate.FilterAnsyuRirekiByAnnaisakuseiym;
import yuyu.def.hozen.predicate.FilterZennouMsisnBySyono;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;


/**
 * 案内収納基本テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_AnsyuKihon} の JavaDoc を参照してください。<br />
 * @see     GenIT_AnsyuKihon<br />
 * @see     PKIT_AnsyuKihon<br />
 * @see     QIT_AnsyuKihon<br />
 * @see     GenQIT_AnsyuKihon<br />
 */
@Entity
public class IT_AnsyuKihon extends GenIT_AnsyuKihon {

    private static final long serialVersionUID = 1L;

    public IT_AnsyuKihon() {
    }

    public IT_AnsyuKihon(String pKbnkey,String pSyono) {
        super(pKbnkey,pSyono);
    }

    public IT_AnsyuKihon(String pSyono) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono);
    }


    private List<IT_AnsyuRireki> iT_AnsyuRirekis = Lists.newLinkedList();
    public IT_AnsyuRireki createAnsyuRireki() {
        IT_AnsyuRireki ansyuRireki =  new IT_AnsyuRireki();
        ansyuRireki.setAnsyuKihon(this);
        ansyuRireki.setKbnkey(this.getKbnkey());
        ansyuRireki.setSyono(this.getSyono());
        getAnsyuRirekis().add(ansyuRireki);
        return ansyuRireki;
    }
    public void setAnsyuRirekis(List<IT_AnsyuRireki> pIT_AnsyuRirekis) {
        this.iT_AnsyuRirekis = pIT_AnsyuRirekis;
    }
    @OneToMany (
        mappedBy = "ansyuKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_AnsyuRireki.SYONO+" ASC ,"+IT_AnsyuRireki.NYKNAIYOUKBN+" ASC ,"+IT_AnsyuRireki.JYUUTOUYM+" ASC ,"+IT_AnsyuRireki.ANNAINO+" ASC ")
    public  List<IT_AnsyuRireki> getAnsyuRirekis() {
        return iT_AnsyuRirekis;
    }

    private List<IT_AnsyuCreditCard> iT_AnsyuCreditCards = Lists.newLinkedList();
    public IT_AnsyuCreditCard createAnsyuCreditCard() {
        IT_AnsyuCreditCard ansyuCreditCard =  new IT_AnsyuCreditCard();
        ansyuCreditCard.setAnsyuKihon(this);
        ansyuCreditCard.setKbnkey(this.getKbnkey());
        ansyuCreditCard.setSyono(this.getSyono());
        setAnsyuCreditCard(ansyuCreditCard);
        return ansyuCreditCard;
    }
    @Transient
    public  IT_AnsyuCreditCard getAnsyuCreditCard() {
        if(getAnsyuCreditCards().size() == 0) {
            return null;
        }
        return getAnsyuCreditCards().get(0);
    }
    @Transient
    public void setAnsyuCreditCard(IT_AnsyuCreditCard pIT_AnsyuCreditCard) {
        if(this.getAnsyuCreditCards().size() >0){
            this.getAnsyuCreditCards().set(0, pIT_AnsyuCreditCard) ;
        }else{
            this.getAnsyuCreditCards().add(pIT_AnsyuCreditCard) ;
        }
    }
    public void setAnsyuCreditCards(List<IT_AnsyuCreditCard> pIT_AnsyuCreditCards) {
        this.iT_AnsyuCreditCards = pIT_AnsyuCreditCards;
    }
    @OneToMany (
        mappedBy = "ansyuKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_AnsyuCreditCard.SYONO+" ASC ")
    public  List<IT_AnsyuCreditCard> getAnsyuCreditCards() {
        return iT_AnsyuCreditCards;
    }

    private List<IT_Tokusin> iT_Tokusins = Lists.newLinkedList();
    public IT_Tokusin createTokusin() {
        IT_Tokusin tokusin =  new IT_Tokusin();
        tokusin.setAnsyuKihon(this);
        tokusin.setKbnkey(this.getKbnkey());
        tokusin.setSyono(this.getSyono());
        setTokusin(tokusin);
        return tokusin;
    }
    @Transient
    public  IT_Tokusin getTokusin() {
        if(getTokusins().size() == 0) {
            return null;
        }
        return getTokusins().get(0);
    }
    @Transient
    public void setTokusin(IT_Tokusin pIT_Tokusin) {
        if(this.getTokusins().size() >0){
            this.getTokusins().set(0, pIT_Tokusin) ;
        }else{
            this.getTokusins().add(pIT_Tokusin) ;
        }
    }
    public void setTokusins(List<IT_Tokusin> pIT_Tokusins) {
        this.iT_Tokusins = pIT_Tokusins;
    }
    @OneToMany (
        mappedBy = "ansyuKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_Tokusin.SYONO+" ASC ")
    public  List<IT_Tokusin> getTokusins() {
        return iT_Tokusins;
    }

    private List<IT_DattaiUktk> iT_DattaiUktks = Lists.newLinkedList();
    public IT_DattaiUktk createDattaiUktk() {
        IT_DattaiUktk dattaiUktk =  new IT_DattaiUktk();
        dattaiUktk.setAnsyuKihon(this);
        dattaiUktk.setKbnkey(this.getKbnkey());
        dattaiUktk.setSyono(this.getSyono());
        setDattaiUktk(dattaiUktk);
        return dattaiUktk;
    }
    @Transient
    public  IT_DattaiUktk getDattaiUktk() {
        if(getDattaiUktks().size() == 0) {
            return null;
        }
        return getDattaiUktks().get(0);
    }
    @Transient
    public void setDattaiUktk(IT_DattaiUktk pIT_DattaiUktk) {
        if(this.getDattaiUktks().size() >0){
            this.getDattaiUktks().set(0, pIT_DattaiUktk) ;
        }else{
            this.getDattaiUktks().add(pIT_DattaiUktk) ;
        }
    }
    public void setDattaiUktks(List<IT_DattaiUktk> pIT_DattaiUktks) {
        this.iT_DattaiUktks = pIT_DattaiUktks;
    }
    @OneToMany (
        mappedBy = "ansyuKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_DattaiUktk.SYONO+" ASC ")
    public  List<IT_DattaiUktk> getDattaiUktks() {
        return iT_DattaiUktks;
    }

    private List<IT_SyuunouHenknRireki> iT_SyuunouHenknRirekis = Lists.newLinkedList();
    public IT_SyuunouHenknRireki createSyuunouHenknRireki() {
        IT_SyuunouHenknRireki syuunouHenknRireki =  new IT_SyuunouHenknRireki();
        syuunouHenknRireki.setAnsyuKihon(this);
        syuunouHenknRireki.setKbnkey(this.getKbnkey());
        syuunouHenknRireki.setSyono(this.getSyono());
        getSyuunouHenknRirekis().add(syuunouHenknRireki);
        return syuunouHenknRireki;
    }
    public void setSyuunouHenknRirekis(List<IT_SyuunouHenknRireki> pIT_SyuunouHenknRirekis) {
        this.iT_SyuunouHenknRirekis = pIT_SyuunouHenknRirekis;
    }
    @OneToMany (
        mappedBy = "ansyuKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_SyuunouHenknRireki.SYONO+" ASC ,"+IT_SyuunouHenknRireki.DENRENNO+" ASC ,"+IT_SyuunouHenknRireki.EDANO+" ASC ")
    public  List<IT_SyuunouHenknRireki> getSyuunouHenknRirekis() {
        return iT_SyuunouHenknRirekis;
    }

    private List<IT_Zennou> iT_Zennous = Lists.newLinkedList();
    public IT_Zennou createZennou() {
        IT_Zennou zennou =  new IT_Zennou();
        zennou.setAnsyuKihon(this);
        zennou.setKbnkey(this.getKbnkey());
        zennou.setSyono(this.getSyono());
        getZennous().add(zennou);
        return zennou;
    }
    public void setZennous(List<IT_Zennou> pIT_Zennous) {
        this.iT_Zennous = pIT_Zennous;
    }
    @OneToMany (
        mappedBy = "ansyuKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_Zennou.SYONO+" ASC ,"+IT_Zennou.ZENNOUKAISIYMD+" ASC ,"+IT_Zennou.RENNO+" ASC ")
    public  List<IT_Zennou> getZennous() {
        return iT_Zennous;
    }

    private List<IT_HrkeIraiInfo> iT_HrkeIraiInfos = Lists.newLinkedList();
    public IT_HrkeIraiInfo createHrkeIraiInfo() {
        IT_HrkeIraiInfo hrkeIraiInfo =  new IT_HrkeIraiInfo();
        hrkeIraiInfo.setAnsyuKihon(this);
        hrkeIraiInfo.setKbnkey(this.getKbnkey());
        hrkeIraiInfo.setSyono(this.getSyono());
        getHrkeIraiInfos().add(hrkeIraiInfo);
        return hrkeIraiInfo;
    }
    public void setHrkeIraiInfos(List<IT_HrkeIraiInfo> pIT_HrkeIraiInfos) {
        this.iT_HrkeIraiInfos = pIT_HrkeIraiInfos;
    }
    @OneToMany (
        mappedBy = "ansyuKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_HrkeIraiInfo.SYONO+" ASC ,"+IT_HrkeIraiInfo.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_HrkeIraiInfo> getHrkeIraiInfos() {
        return iT_HrkeIraiInfos;
    }

    private List<IT_UriageSeikyuuData> iT_UriageSeikyuuDatas = Lists.newLinkedList();
    public IT_UriageSeikyuuData createUriageSeikyuuData() {
        IT_UriageSeikyuuData uriageSeikyuuData =  new IT_UriageSeikyuuData();
        uriageSeikyuuData.setAnsyuKihon(this);
        uriageSeikyuuData.setKbnkey(this.getKbnkey());
        uriageSeikyuuData.setSyono(this.getSyono());
        getUriageSeikyuuDatas().add(uriageSeikyuuData);
        return uriageSeikyuuData;
    }
    public void setUriageSeikyuuDatas(List<IT_UriageSeikyuuData> pIT_UriageSeikyuuDatas) {
        this.iT_UriageSeikyuuDatas = pIT_UriageSeikyuuDatas;
    }
    @OneToMany (
        mappedBy = "ansyuKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_UriageSeikyuuData.SYONO+" ASC ,"+IT_UriageSeikyuuData.CREDITKESSAIYOUNO+" ASC ,"+IT_UriageSeikyuuData.URIAGENENGAPPI+" ASC ,"+IT_UriageSeikyuuData.RENNO3KETA+" ASC ")
    public  List<IT_UriageSeikyuuData> getUriageSeikyuuDatas() {
        return iT_UriageSeikyuuDatas;
    }

    @Transient
    public  List<IT_AnsyuRireki> getAnsyuRirekisByAnnaisakuseiym(BizDateYM pAnnaisakuseiym) {
        return new ArrayList<IT_AnsyuRireki>(Collections2.filter(getAnsyuRirekis(),
            new FilterAnsyuRirekiByAnnaisakuseiym(pAnnaisakuseiym)));
    }
    @Transient
    public  List<IT_AnsyuRireki> getAnsyuRirekisByAnnaijkkbn(C_AnnaijkKbn pAnnaijkkbn) {
        return new ArrayList<IT_AnsyuRireki>(Collections2.filter(getAnsyuRirekis(),
            new FilterAnsyuRirekiByAnnaijkkbn(pAnnaijkkbn)));
    }
    @Transient
    public  List<IT_Zennou> getZennouMsisnsBySyono() {
        return new ArrayList<IT_Zennou>(Collections2.filter(getZennous(),
            new FilterZennouMsisnBySyono()));
    }
}

