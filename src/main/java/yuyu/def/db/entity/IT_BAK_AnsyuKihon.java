package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_AnsyuKihon;

import com.google.common.collect.Lists;


/**
 * 案内収納基本バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_AnsyuKihon} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_AnsyuKihon<br />
 * @see     PKIT_BAK_AnsyuKihon<br />
 * @see     QIT_BAK_AnsyuKihon<br />
 * @see     GenQIT_BAK_AnsyuKihon<br />
 */
@Entity
public class IT_BAK_AnsyuKihon extends GenIT_BAK_AnsyuKihon {

    private static final long serialVersionUID = 1L;

    public IT_BAK_AnsyuKihon() {
    }

    public IT_BAK_AnsyuKihon(String pKbnkey,String pSyono,String pTrkssikibetukey) {
        super(pKbnkey,pSyono,pTrkssikibetukey);
    }

    public IT_BAK_AnsyuKihon(String pSyono,String pTrkssikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey);
    }


    private List<IT_BAK_AnsyuRireki> iT_BAKAnsyuRirekis = Lists.newLinkedList();
    public IT_BAK_AnsyuRireki createBAKAnsyuRireki() {
        IT_BAK_AnsyuRireki bAKAnsyuRireki =  new IT_BAK_AnsyuRireki();
        bAKAnsyuRireki.setBAKAnsyuKihon(this);
        bAKAnsyuRireki.setKbnkey(this.getKbnkey());
        bAKAnsyuRireki.setSyono(this.getSyono());
        bAKAnsyuRireki.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKAnsyuRirekis().add(bAKAnsyuRireki);
        return bAKAnsyuRireki;
    }
    public void setBAKAnsyuRirekis(List<IT_BAK_AnsyuRireki> pIT_BAK_AnsyuRirekis) {
        this.iT_BAKAnsyuRirekis = pIT_BAK_AnsyuRirekis;
    }
    @OneToMany (
        mappedBy = "BAKAnsyuKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_AnsyuRireki.SYONO+" ASC ,"+IT_BAK_AnsyuRireki.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_AnsyuRireki.NYKNAIYOUKBN+" ASC ,"+IT_BAK_AnsyuRireki.JYUUTOUYM+" ASC ,"+IT_BAK_AnsyuRireki.ANNAINO+" ASC ")
    public  List<IT_BAK_AnsyuRireki> getBAKAnsyuRirekis() {
        return iT_BAKAnsyuRirekis;
    }

    private List<IT_BAK_AnsyuCreditCard> iT_BAKAnsyuCreditCards = Lists.newLinkedList();
    public IT_BAK_AnsyuCreditCard createBAKAnsyuCreditCard() {
        IT_BAK_AnsyuCreditCard bAKAnsyuCreditCard =  new IT_BAK_AnsyuCreditCard();
        bAKAnsyuCreditCard.setBAKAnsyuKihon(this);
        bAKAnsyuCreditCard.setKbnkey(this.getKbnkey());
        bAKAnsyuCreditCard.setSyono(this.getSyono());
        bAKAnsyuCreditCard.setTrkssikibetukey(this.getTrkssikibetukey());
        setBAKAnsyuCreditCard(bAKAnsyuCreditCard);
        return bAKAnsyuCreditCard;
    }
    @Transient
    public  IT_BAK_AnsyuCreditCard getBAKAnsyuCreditCard() {
        if(getBAKAnsyuCreditCards().size() == 0) {
            return null;
        }
        return getBAKAnsyuCreditCards().get(0);
    }
    @Transient
    public void setBAKAnsyuCreditCard(IT_BAK_AnsyuCreditCard pIT_BAK_AnsyuCreditCard) {
        if(this.getBAKAnsyuCreditCards().size() >0){
            this.getBAKAnsyuCreditCards().set(0, pIT_BAK_AnsyuCreditCard) ;
        }else{
            this.getBAKAnsyuCreditCards().add(pIT_BAK_AnsyuCreditCard) ;
        }
    }
    public void setBAKAnsyuCreditCards(List<IT_BAK_AnsyuCreditCard> pIT_BAK_AnsyuCreditCards) {
        this.iT_BAKAnsyuCreditCards = pIT_BAK_AnsyuCreditCards;
    }
    @OneToMany (
        mappedBy = "BAKAnsyuKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_AnsyuCreditCard.SYONO+" ASC ,"+IT_BAK_AnsyuCreditCard.TRKSSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_AnsyuCreditCard> getBAKAnsyuCreditCards() {
        return iT_BAKAnsyuCreditCards;
    }

    private List<IT_BAK_Tokusin> iT_BAKTokusins = Lists.newLinkedList();
    public IT_BAK_Tokusin createBAKTokusin() {
        IT_BAK_Tokusin bAKTokusin =  new IT_BAK_Tokusin();
        bAKTokusin.setBAKAnsyuKihon(this);
        bAKTokusin.setKbnkey(this.getKbnkey());
        bAKTokusin.setSyono(this.getSyono());
        bAKTokusin.setTrkssikibetukey(this.getTrkssikibetukey());
        setBAKTokusin(bAKTokusin);
        return bAKTokusin;
    }
    @Transient
    public  IT_BAK_Tokusin getBAKTokusin() {
        if(getBAKTokusins().size() == 0) {
            return null;
        }
        return getBAKTokusins().get(0);
    }
    @Transient
    public void setBAKTokusin(IT_BAK_Tokusin pIT_BAK_Tokusin) {
        if(this.getBAKTokusins().size() >0){
            this.getBAKTokusins().set(0, pIT_BAK_Tokusin) ;
        }else{
            this.getBAKTokusins().add(pIT_BAK_Tokusin) ;
        }
    }
    public void setBAKTokusins(List<IT_BAK_Tokusin> pIT_BAK_Tokusins) {
        this.iT_BAKTokusins = pIT_BAK_Tokusins;
    }
    @OneToMany (
        mappedBy = "BAKAnsyuKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_Tokusin.SYONO+" ASC ,"+IT_BAK_Tokusin.TRKSSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_Tokusin> getBAKTokusins() {
        return iT_BAKTokusins;
    }

    private List<IT_BAK_DattaiUktk> iT_BAKDattaiUktks = Lists.newLinkedList();
    public IT_BAK_DattaiUktk createBAKDattaiUktk() {
        IT_BAK_DattaiUktk bAKDattaiUktk =  new IT_BAK_DattaiUktk();
        bAKDattaiUktk.setBAKAnsyuKihon(this);
        bAKDattaiUktk.setKbnkey(this.getKbnkey());
        bAKDattaiUktk.setSyono(this.getSyono());
        bAKDattaiUktk.setTrkssikibetukey(this.getTrkssikibetukey());
        setBAKDattaiUktk(bAKDattaiUktk);
        return bAKDattaiUktk;
    }
    @Transient
    public  IT_BAK_DattaiUktk getBAKDattaiUktk() {
        if(getBAKDattaiUktks().size() == 0) {
            return null;
        }
        return getBAKDattaiUktks().get(0);
    }
    @Transient
    public void setBAKDattaiUktk(IT_BAK_DattaiUktk pIT_BAK_DattaiUktk) {
        if(this.getBAKDattaiUktks().size() >0){
            this.getBAKDattaiUktks().set(0, pIT_BAK_DattaiUktk) ;
        }else{
            this.getBAKDattaiUktks().add(pIT_BAK_DattaiUktk) ;
        }
    }
    public void setBAKDattaiUktks(List<IT_BAK_DattaiUktk> pIT_BAK_DattaiUktks) {
        this.iT_BAKDattaiUktks = pIT_BAK_DattaiUktks;
    }
    @OneToMany (
        mappedBy = "BAKAnsyuKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_DattaiUktk.SYONO+" ASC ,"+IT_BAK_DattaiUktk.TRKSSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_DattaiUktk> getBAKDattaiUktks() {
        return iT_BAKDattaiUktks;
    }

    private List<IT_BAK_SyuunouHenknRireki> iT_BAKSyuunouHenknRirekis = Lists.newLinkedList();
    public IT_BAK_SyuunouHenknRireki createBAKSyuunouHenknRireki() {
        IT_BAK_SyuunouHenknRireki bAKSyuunouHenknRireki =  new IT_BAK_SyuunouHenknRireki();
        bAKSyuunouHenknRireki.setBAKAnsyuKihon(this);
        bAKSyuunouHenknRireki.setKbnkey(this.getKbnkey());
        bAKSyuunouHenknRireki.setSyono(this.getSyono());
        bAKSyuunouHenknRireki.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKSyuunouHenknRirekis().add(bAKSyuunouHenknRireki);
        return bAKSyuunouHenknRireki;
    }
    public void setBAKSyuunouHenknRirekis(List<IT_BAK_SyuunouHenknRireki> pIT_BAK_SyuunouHenknRirekis) {
        this.iT_BAKSyuunouHenknRirekis = pIT_BAK_SyuunouHenknRirekis;
    }
    @OneToMany (
        mappedBy = "BAKAnsyuKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_SyuunouHenknRireki.SYONO+" ASC ,"+IT_BAK_SyuunouHenknRireki.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_SyuunouHenknRireki.DENRENNO+" ASC ,"+IT_BAK_SyuunouHenknRireki.EDANO+" ASC ")
    public  List<IT_BAK_SyuunouHenknRireki> getBAKSyuunouHenknRirekis() {
        return iT_BAKSyuunouHenknRirekis;
    }

    private List<IT_BAK_Zennou> iT_BAKZennous = Lists.newLinkedList();
    public IT_BAK_Zennou createBAKZennou() {
        IT_BAK_Zennou bAKZennou =  new IT_BAK_Zennou();
        bAKZennou.setBAKAnsyuKihon(this);
        bAKZennou.setKbnkey(this.getKbnkey());
        bAKZennou.setSyono(this.getSyono());
        bAKZennou.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKZennous().add(bAKZennou);
        return bAKZennou;
    }
    public void setBAKZennous(List<IT_BAK_Zennou> pIT_BAK_Zennous) {
        this.iT_BAKZennous = pIT_BAK_Zennous;
    }
    @OneToMany (
        mappedBy = "BAKAnsyuKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_Zennou.SYONO+" ASC ,"+IT_BAK_Zennou.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_Zennou.ZENNOUKAISIYMD+" ASC ,"+IT_BAK_Zennou.RENNO+" ASC ")
    public  List<IT_BAK_Zennou> getBAKZennous() {
        return iT_BAKZennous;
    }

    private List<IT_BAK_HrkeIraiInfo> iT_BAKHrkeIraiInfos = Lists.newLinkedList();
    public IT_BAK_HrkeIraiInfo createBAKHrkeIraiInfo() {
        IT_BAK_HrkeIraiInfo bAKHrkeIraiInfo =  new IT_BAK_HrkeIraiInfo();
        bAKHrkeIraiInfo.setBAKAnsyuKihon(this);
        bAKHrkeIraiInfo.setKbnkey(this.getKbnkey());
        bAKHrkeIraiInfo.setSyono(this.getSyono());
        bAKHrkeIraiInfo.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKHrkeIraiInfos().add(bAKHrkeIraiInfo);
        return bAKHrkeIraiInfo;
    }
    public void setBAKHrkeIraiInfos(List<IT_BAK_HrkeIraiInfo> pIT_BAK_HrkeIraiInfos) {
        this.iT_BAKHrkeIraiInfos = pIT_BAK_HrkeIraiInfos;
    }
    @OneToMany (
        mappedBy = "BAKAnsyuKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_HrkeIraiInfo.SYONO+" ASC ,"+IT_BAK_HrkeIraiInfo.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_HrkeIraiInfo.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_HrkeIraiInfo> getBAKHrkeIraiInfos() {
        return iT_BAKHrkeIraiInfos;
    }

    private List<IT_BAK_UriageSeikyuuData> iT_BAKUriageSeikyuuDatas = Lists.newLinkedList();
    public IT_BAK_UriageSeikyuuData createBAKUriageSeikyuuData() {
        IT_BAK_UriageSeikyuuData bAKUriageSeikyuuData =  new IT_BAK_UriageSeikyuuData();
        bAKUriageSeikyuuData.setBAKAnsyuKihon(this);
        bAKUriageSeikyuuData.setKbnkey(this.getKbnkey());
        bAKUriageSeikyuuData.setSyono(this.getSyono());
        bAKUriageSeikyuuData.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKUriageSeikyuuDatas().add(bAKUriageSeikyuuData);
        return bAKUriageSeikyuuData;
    }
    public void setBAKUriageSeikyuuDatas(List<IT_BAK_UriageSeikyuuData> pIT_BAK_UriageSeikyuuDatas) {
        this.iT_BAKUriageSeikyuuDatas = pIT_BAK_UriageSeikyuuDatas;
    }
    @OneToMany (
        mappedBy = "BAKAnsyuKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_UriageSeikyuuData.SYONO+" ASC ,"+IT_BAK_UriageSeikyuuData.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_UriageSeikyuuData.CREDITKESSAIYOUNO+" ASC ,"+IT_BAK_UriageSeikyuuData.URIAGENENGAPPI+" ASC ,"+IT_BAK_UriageSeikyuuData.RENNO3KETA+" ASC ")
    public  List<IT_BAK_UriageSeikyuuData> getBAKUriageSeikyuuDatas() {
        return iT_BAKUriageSeikyuuDatas;
    }

}

