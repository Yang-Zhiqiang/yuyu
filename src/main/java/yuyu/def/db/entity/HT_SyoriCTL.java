package yuyu.def.db.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import yuyu.def.classification.C_HnknhouKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_NyknsyubetuKbn;
import yuyu.def.classification.C_Rulehanteimsg;
import yuyu.def.classification.C_SkeittdkrenrakuKbn;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyosaiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.mapping.GenHT_SyoriCTL;
import yuyu.def.sinkeiyaku.predicate.FilterDakuhiKetteiByDakuhiktrenno;
import yuyu.def.sinkeiyaku.predicate.FilterDakuhiKetteiByKetkekkacd;
import yuyu.def.sinkeiyaku.predicate.FilterDakuhiKetteiByKetkekkacds;
import yuyu.def.sinkeiyaku.predicate.FilterHenkinByHnkninputrenno;
import yuyu.def.sinkeiyaku.predicate.FilterHenkinByHnknsyoriymd;
import yuyu.def.sinkeiyaku.predicate.FilterHenkinByHnknsyoriymdHnknhoukbns;
import yuyu.def.sinkeiyaku.predicate.FilterHenkinByHnknsyoriymdHnkntuukasyuZenhenrennoNe;
import yuyu.def.sinkeiyaku.predicate.FilterHenkinByHnknsyoriymdNeNull;
import yuyu.def.sinkeiyaku.predicate.FilterHenkinByHnknsyoriymdNotNull;
import yuyu.def.sinkeiyaku.predicate.FilterHenkinByHnknsyoriymdNull;
import yuyu.def.sinkeiyaku.predicate.FilterHenkinByHnkntuukasyu;
import yuyu.def.sinkeiyaku.predicate.FilterHenkinByHnkntuukasyuHnknsyoriymd;
import yuyu.def.sinkeiyaku.predicate.FilterHenkinByHnkntuukasyuHnknsyoriymdNeNull;
import yuyu.def.sinkeiyaku.predicate.FilterHenkinByRenno;
import yuyu.def.sinkeiyaku.predicate.FilterHenkinByZenhnknrennos;
import yuyu.def.sinkeiyaku.predicate.FilterHenkinSumHnkngkByHnknsyoriymdLe;
import yuyu.def.sinkeiyaku.predicate.FilterHenkinSumHnkngkByHnkntuukasyuHnknsyoriymdLe;
import yuyu.def.sinkeiyaku.predicate.FilterHenkinSumHnkngkByHnkntuukasyuPkakinsyoriymd;
import yuyu.def.sinkeiyaku.predicate.FilterHenkinSumHnkngkByPkakinsyoriymd;
import yuyu.def.sinkeiyaku.predicate.FilterHenkinSumHnkngkByhnknsyoriymdNull;
import yuyu.def.sinkeiyaku.predicate.FilterHoujyouBySyosaikbn;
import yuyu.def.sinkeiyaku.predicate.FilterHubiMsgByHubimsg;
import yuyu.def.sinkeiyaku.predicate.FilterHubiMsgByHubisyubetusyousaikbn;
import yuyu.def.sinkeiyaku.predicate.FilterHubiMsgByMessageId;
import yuyu.def.sinkeiyaku.predicate.FilterImuSonotaTkykJktkByRenno;
import yuyu.def.sinkeiyaku.predicate.FilterImusateiRirekiByImusateikekkakbn;
import yuyu.def.sinkeiyaku.predicate.FilterImusateiSyouhnTokujyouByRenno;
import yuyu.def.sinkeiyaku.predicate.FilterImusateiTokujyouByRenno;
import yuyu.def.sinkeiyaku.predicate.FilterKnksateiRirekiByKnksateikekkakbn;
import yuyu.def.sinkeiyaku.predicate.FilterKykKakByRenno;
import yuyu.def.sinkeiyaku.predicate.FilterMosDairitenByRenno;
import yuyu.def.sinkeiyaku.predicate.FilterMosDairitenVrfByRenno;
import yuyu.def.sinkeiyaku.predicate.FilterMosSyouhnByGanhsyngumu;
import yuyu.def.sinkeiyaku.predicate.FilterMosSyouhnByKatakbns;
import yuyu.def.sinkeiyaku.predicate.FilterMosSyouhnBySyouhncd;
import yuyu.def.sinkeiyaku.predicate.FilterMosSyouhnBySyutkkbn;
import yuyu.def.sinkeiyaku.predicate.FilterMosSyouhnVrfBySyutkkbn;
import yuyu.def.sinkeiyaku.predicate.FilterNayoseKekkaBySignalsetteiumukbn;
import yuyu.def.sinkeiyaku.predicate.FilterNayoseKekkaBySntkinfotaisyousyakbn;
import yuyu.def.sinkeiyaku.predicate.FilterNayoseKekkaBySntkinfotaisyousyakbnEdano;
import yuyu.def.sinkeiyaku.predicate.FilterNayoseKekkaBySntkinfotaisyousyakbnNysjissikekkakbn;
import yuyu.def.sinkeiyaku.predicate.FilterNrkDifByVrfkinouid;
import yuyu.def.sinkeiyaku.predicate.FilterNyuukinByNyknsyubetu;
import yuyu.def.sinkeiyaku.predicate.FilterNyuukinByNyknsyubetuNe;
import yuyu.def.sinkeiyaku.predicate.FilterNyuukinByRenno;
import yuyu.def.sinkeiyaku.predicate.FilterNyuukinByRstuukasyu;
import yuyu.def.sinkeiyaku.predicate.FilterNyuukinByZenhnknkbn;
import yuyu.def.sinkeiyaku.predicate.FilterNyuukinByZenhnknkbnBlank;
import yuyu.def.sinkeiyaku.predicate.FilterNyuukinByZenhnknkbnNe;
import yuyu.def.sinkeiyaku.predicate.FilterNyuukinByZenhnknrennos;
import yuyu.def.sinkeiyaku.predicate.FilterNyuukinSumRsgakuByNyksyoriymd;
import yuyu.def.sinkeiyaku.predicate.FilterNyuukinSumRsgakuByRstuukasyuNyksyoriymd;
import yuyu.def.sinkeiyaku.predicate.FilterNyuukinSumRsgakuByRyosyuymd;
import yuyu.def.sinkeiyaku.predicate.FilterNyuukinsByZenhnknkbn;
import yuyu.def.sinkeiyaku.predicate.FilterRuleHanteiMsgByRulehanteimsg;
import yuyu.def.sinkeiyaku.predicate.FilterSentakuJyouhouBySntkinfotaisyousyakbnEdano;
import yuyu.def.sinkeiyaku.predicate.FilterSkHubiByHasinymdNotNullKaisyouymdNull;
import yuyu.def.sinkeiyaku.predicate.FilterSkHubiByHubisikibetukey;
import yuyu.def.sinkeiyaku.predicate.FilterSkLincSyoukaikekkaByLincjyusintrrennoRenno;
import yuyu.def.sinkeiyaku.predicate.FilterSkTtdkTyuuiBySkeittdkrenrakukbn;
import yuyu.def.sinkeiyaku.predicate.FilterUketoriKouzaJyouhouByUktkzsyubetukbn;
import yuyu.def.sinkeiyaku.predicate.FilterUketoriKouzaJyouhouVrfByUktkzsyubetukbn;
import yuyu.def.sinkeiyaku.predicate.FilterUketorininByUktsyukbn;
import yuyu.def.sinkeiyaku.predicate.FilterUketorininByUktsyukbnUktsyurenno;
import yuyu.def.sinkeiyaku.predicate.FilterUketorininVrfByUktsyukbn;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


/**
 * 処理コントロールテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SyoriCTL} の JavaDoc を参照してください。<br />
 * @see     GenHT_SyoriCTL<br />
 * @see     PKHT_SyoriCTL<br />
 * @see     QHT_SyoriCTL<br />
 * @see     GenQHT_SyoriCTL<br />
 */
@Entity
public class HT_SyoriCTL extends GenHT_SyoriCTL {

    private static final long serialVersionUID = 1L;

    public HT_SyoriCTL() {
    }

    public HT_SyoriCTL(String pMosno) {
        super(pMosno);
    }



    private List<HT_KouzaJyouhou> hT_KouzaJyouhous = Lists.newLinkedList();
    public HT_KouzaJyouhou createKouzaJyouhou() {
        HT_KouzaJyouhou kouzaJyouhou =  new HT_KouzaJyouhou();
        kouzaJyouhou.setSyoriCTL(this);
        kouzaJyouhou.setMosno(this.getMosno());
        setKouzaJyouhou(kouzaJyouhou);
        return kouzaJyouhou;
    }
    @Transient
    public  HT_KouzaJyouhou getKouzaJyouhou() {
        if(getKouzaJyouhous().size() == 0) {
            return null;
        }
        return getKouzaJyouhous().get(0);
    }
    @Transient
    public void setKouzaJyouhou(HT_KouzaJyouhou pHT_KouzaJyouhou) {
        if(this.getKouzaJyouhous().size() >0){
            this.getKouzaJyouhous().set(0, pHT_KouzaJyouhou) ;
        }else{
            this.getKouzaJyouhous().add(pHT_KouzaJyouhou) ;
        }
    }
    public void setKouzaJyouhous(List<HT_KouzaJyouhou> pHT_KouzaJyouhous) {
        this.hT_KouzaJyouhous = pHT_KouzaJyouhous;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_KouzaJyouhou.MOSNO+" ASC ")
    public  List<HT_KouzaJyouhou> getKouzaJyouhous() {
        return hT_KouzaJyouhous;
    }

    private List<HT_MosKihon> hT_MosKihons = Lists.newLinkedList();
    public HT_MosKihon createMosKihon() {
        HT_MosKihon mosKihon =  new HT_MosKihon();
        mosKihon.setSyoriCTL(this);
        mosKihon.setMosno(this.getMosno());
        setMosKihon(mosKihon);
        return mosKihon;
    }
    @Transient
    public  HT_MosKihon getMosKihon() {
        if(getMosKihons().size() == 0) {
            return null;
        }
        return getMosKihons().get(0);
    }
    @Transient
    public void setMosKihon(HT_MosKihon pHT_MosKihon) {
        if(this.getMosKihons().size() >0){
            this.getMosKihons().set(0, pHT_MosKihon) ;
        }else{
            this.getMosKihons().add(pHT_MosKihon) ;
        }
    }
    public void setMosKihons(List<HT_MosKihon> pHT_MosKihons) {
        this.hT_MosKihons = pHT_MosKihons;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_MosKihon.MOSNO+" ASC ")
    public  List<HT_MosKihon> getMosKihons() {
        return hT_MosKihons;
    }

    private List<HT_CreditCardJyouhou> hT_CreditCardJyouhous = Lists.newLinkedList();
    public HT_CreditCardJyouhou createCreditCardJyouhou() {
        HT_CreditCardJyouhou creditCardJyouhou =  new HT_CreditCardJyouhou();
        creditCardJyouhou.setSyoriCTL(this);
        creditCardJyouhou.setMosno(this.getMosno());
        setCreditCardJyouhou(creditCardJyouhou);
        return creditCardJyouhou;
    }
    @Transient
    public  HT_CreditCardJyouhou getCreditCardJyouhou() {
        if(getCreditCardJyouhous().size() == 0) {
            return null;
        }
        return getCreditCardJyouhous().get(0);
    }
    @Transient
    public void setCreditCardJyouhou(HT_CreditCardJyouhou pHT_CreditCardJyouhou) {
        if(this.getCreditCardJyouhous().size() >0){
            this.getCreditCardJyouhous().set(0, pHT_CreditCardJyouhou) ;
        }else{
            this.getCreditCardJyouhous().add(pHT_CreditCardJyouhou) ;
        }
    }
    public void setCreditCardJyouhous(List<HT_CreditCardJyouhou> pHT_CreditCardJyouhous) {
        this.hT_CreditCardJyouhous = pHT_CreditCardJyouhous;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_CreditCardJyouhou.MOSNO+" ASC ")
    public  List<HT_CreditCardJyouhou> getCreditCardJyouhous() {
        return hT_CreditCardJyouhous;
    }

    private List<HT_SkTtdkTyuuiKanri> hT_SkTtdkTyuuiKanris = Lists.newLinkedList();
    public HT_SkTtdkTyuuiKanri createSkTtdkTyuuiKanri() {
        HT_SkTtdkTyuuiKanri skTtdkTyuuiKanri =  new HT_SkTtdkTyuuiKanri();
        skTtdkTyuuiKanri.setSyoriCTL(this);
        skTtdkTyuuiKanri.setMosno(this.getMosno());
        setSkTtdkTyuuiKanri(skTtdkTyuuiKanri);
        return skTtdkTyuuiKanri;
    }
    @Transient
    public  HT_SkTtdkTyuuiKanri getSkTtdkTyuuiKanri() {
        if(getSkTtdkTyuuiKanris().size() == 0) {
            return null;
        }
        return getSkTtdkTyuuiKanris().get(0);
    }
    @Transient
    public void setSkTtdkTyuuiKanri(HT_SkTtdkTyuuiKanri pHT_SkTtdkTyuuiKanri) {
        if(this.getSkTtdkTyuuiKanris().size() >0){
            this.getSkTtdkTyuuiKanris().set(0, pHT_SkTtdkTyuuiKanri) ;
        }else{
            this.getSkTtdkTyuuiKanris().add(pHT_SkTtdkTyuuiKanri) ;
        }
    }
    public void setSkTtdkTyuuiKanris(List<HT_SkTtdkTyuuiKanri> pHT_SkTtdkTyuuiKanris) {
        this.hT_SkTtdkTyuuiKanris = pHT_SkTtdkTyuuiKanris;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_SkTtdkTyuuiKanri.MOSNO+" ASC ")
    public  List<HT_SkTtdkTyuuiKanri> getSkTtdkTyuuiKanris() {
        return hT_SkTtdkTyuuiKanris;
    }

    private List<HT_SkTtdkTyuui> hT_SkTtdkTyuuis = Lists.newLinkedList();
    public HT_SkTtdkTyuui createSkTtdkTyuui() {
        HT_SkTtdkTyuui skTtdkTyuui =  new HT_SkTtdkTyuui();
        skTtdkTyuui.setSyoriCTL(this);
        skTtdkTyuui.setMosno(this.getMosno());
        getSkTtdkTyuuis().add(skTtdkTyuui);
        return skTtdkTyuui;
    }
    public void setSkTtdkTyuuis(List<HT_SkTtdkTyuui> pHT_SkTtdkTyuuis) {
        this.hT_SkTtdkTyuuis = pHT_SkTtdkTyuuis;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_SkTtdkTyuui.MOSNO+" ASC ,"+HT_SkTtdkTyuui.SKEITTDKRENRAKUKBN+" ASC ,"+HT_SkTtdkTyuui.DATARENNO+" ASC ")
    public  List<HT_SkTtdkTyuui> getSkTtdkTyuuis() {
        return hT_SkTtdkTyuuis;
    }

    private List<HT_HubiMsg> hT_HubiMsgs = Lists.newLinkedList();
    public HT_HubiMsg createHubiMsg() {
        HT_HubiMsg hubiMsg =  new HT_HubiMsg();
        hubiMsg.setSyoriCTL(this);
        hubiMsg.setMosno(this.getMosno());
        getHubiMsgs().add(hubiMsg);
        return hubiMsg;
    }
    public void setHubiMsgs(List<HT_HubiMsg> pHT_HubiMsgs) {
        this.hT_HubiMsgs = pHT_HubiMsgs;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_HubiMsg.MOSNO+" ASC ,"+HT_HubiMsg.RENNO+" ASC ")
    public  List<HT_HubiMsg> getHubiMsgs() {
        return hT_HubiMsgs;
    }

    private List<HT_HenteiRireki> hT_HenteiRirekis = Lists.newLinkedList();
    public HT_HenteiRireki createHenteiRireki() {
        HT_HenteiRireki henteiRireki =  new HT_HenteiRireki();
        henteiRireki.setSyoriCTL(this);
        henteiRireki.setMosno(this.getMosno());
        getHenteiRirekis().add(henteiRireki);
        return henteiRireki;
    }
    public void setHenteiRirekis(List<HT_HenteiRireki> pHT_HenteiRirekis) {
        this.hT_HenteiRirekis = pHT_HenteiRirekis;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_HenteiRireki.MOSNO+" ASC ,"+HT_HenteiRireki.RENNO+" ASC ")
    public  List<HT_HenteiRireki> getHenteiRirekis() {
        return hT_HenteiRirekis;
    }

    private List<HT_KmTsRireki> hT_KmTsRirekis = Lists.newLinkedList();
    public HT_KmTsRireki createKmTsRireki() {
        HT_KmTsRireki kmTsRireki =  new HT_KmTsRireki();
        kmTsRireki.setSyoriCTL(this);
        kmTsRireki.setMosno(this.getMosno());
        getKmTsRirekis().add(kmTsRireki);
        return kmTsRireki;
    }
    public void setKmTsRirekis(List<HT_KmTsRireki> pHT_KmTsRirekis) {
        this.hT_KmTsRirekis = pHT_KmTsRirekis;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_KmTsRireki.MOSNO+" ASC ,"+HT_KmTsRireki.SYORITIME+" ASC ,"+HT_KmTsRireki.RENNO3KETA+" ASC ")
    public  List<HT_KmTsRireki> getKmTsRirekis() {
        return hT_KmTsRirekis;
    }

    private List<HT_SkLincTourokuInfo> hT_SkLincTourokuInfos = Lists.newLinkedList();
    public HT_SkLincTourokuInfo createSkLincTourokuInfo() {
        HT_SkLincTourokuInfo skLincTourokuInfo =  new HT_SkLincTourokuInfo();
        skLincTourokuInfo.setSyoriCTL(this);
        skLincTourokuInfo.setMosno(this.getMosno());
        setSkLincTourokuInfo(skLincTourokuInfo);
        return skLincTourokuInfo;
    }
    @Transient
    public  HT_SkLincTourokuInfo getSkLincTourokuInfo() {
        if(getSkLincTourokuInfos().size() == 0) {
            return null;
        }
        return getSkLincTourokuInfos().get(0);
    }
    @Transient
    public void setSkLincTourokuInfo(HT_SkLincTourokuInfo pHT_SkLincTourokuInfo) {
        if(this.getSkLincTourokuInfos().size() >0){
            this.getSkLincTourokuInfos().set(0, pHT_SkLincTourokuInfo) ;
        }else{
            this.getSkLincTourokuInfos().add(pHT_SkLincTourokuInfo) ;
        }
    }
    public void setSkLincTourokuInfos(List<HT_SkLincTourokuInfo> pHT_SkLincTourokuInfos) {
        this.hT_SkLincTourokuInfos = pHT_SkLincTourokuInfos;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_SkLincTourokuInfo.MOSNO+" ASC ")
    public  List<HT_SkLincTourokuInfo> getSkLincTourokuInfos() {
        return hT_SkLincTourokuInfos;
    }

    private List<HT_SkLincSyoukaikekka> hT_SkLincSyoukaikekkas = Lists.newLinkedList();
    public HT_SkLincSyoukaikekka createSkLincSyoukaikekka() {
        HT_SkLincSyoukaikekka skLincSyoukaikekka =  new HT_SkLincSyoukaikekka();
        skLincSyoukaikekka.setSyoriCTL(this);
        skLincSyoukaikekka.setMosno(this.getMosno());
        getSkLincSyoukaikekkas().add(skLincSyoukaikekka);
        return skLincSyoukaikekka;
    }
    public void setSkLincSyoukaikekkas(List<HT_SkLincSyoukaikekka> pHT_SkLincSyoukaikekkas) {
        this.hT_SkLincSyoukaikekkas = pHT_SkLincSyoukaikekkas;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_SkLincSyoukaikekka.MOSNO+" ASC ,"+HT_SkLincSyoukaikekka.LINCJYUSINTRRENNO+" ASC ,"+HT_SkLincSyoukaikekka.RENNO+" ASC ")
    public  List<HT_SkLincSyoukaikekka> getSkLincSyoukaikekkas() {
        return hT_SkLincSyoukaikekkas;
    }

    @Transient
    public HT_SkLincSyoukaikekka getSkLincSyoukaikekkaByLincjyusintrrennoRenno(String pLincjyusintrrenno, Integer pRenno) {
        return Iterables.getFirst(Iterables.filter(getSkLincSyoukaikekkas(),
            new FilterSkLincSyoukaikekkaByLincjyusintrrennoRenno(pLincjyusintrrenno, pRenno)), null);
    }

    private List<HT_UketoriKouzaJyouhou> hT_UketoriKouzaJyouhous = Lists.newLinkedList();
    public HT_UketoriKouzaJyouhou createUketoriKouzaJyouhou() {
        HT_UketoriKouzaJyouhou uketoriKouzaJyouhou =  new HT_UketoriKouzaJyouhou();
        uketoriKouzaJyouhou.setSyoriCTL(this);
        uketoriKouzaJyouhou.setMosno(this.getMosno());
        getUketoriKouzaJyouhous().add(uketoriKouzaJyouhou);
        return uketoriKouzaJyouhou;
    }
    public void setUketoriKouzaJyouhous(List<HT_UketoriKouzaJyouhou> pHT_UketoriKouzaJyouhous) {
        this.hT_UketoriKouzaJyouhous = pHT_UketoriKouzaJyouhous;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_UketoriKouzaJyouhou.MOSNO+" ASC ,"+HT_UketoriKouzaJyouhou.UKTKZSYUBETUKBN+" ASC ")
    public  List<HT_UketoriKouzaJyouhou> getUketoriKouzaJyouhous() {
        return hT_UketoriKouzaJyouhous;
    }

    private List<HT_MosDairiten> hT_MosDairitens = Lists.newLinkedList();
    public HT_MosDairiten createMosDairiten() {
        HT_MosDairiten mosDairiten =  new HT_MosDairiten();
        mosDairiten.setSyoriCTL(this);
        mosDairiten.setMosno(this.getMosno());
        getMosDairitens().add(mosDairiten);
        return mosDairiten;
    }
    public void setMosDairitens(List<HT_MosDairiten> pHT_MosDairitens) {
        this.hT_MosDairitens = pHT_MosDairitens;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_MosDairiten.MOSNO+" ASC ,"+HT_MosDairiten.RENNO+" ASC ")
    public  List<HT_MosDairiten> getMosDairitens() {
        return hT_MosDairitens;
    }

    private List<HT_Uketorinin> hT_Uketorinins = Lists.newLinkedList();
    public HT_Uketorinin createUketorinin() {
        HT_Uketorinin uketorinin =  new HT_Uketorinin();
        uketorinin.setSyoriCTL(this);
        uketorinin.setMosno(this.getMosno());
        getUketorinins().add(uketorinin);
        return uketorinin;
    }
    public void setUketorinins(List<HT_Uketorinin> pHT_Uketorinins) {
        this.hT_Uketorinins = pHT_Uketorinins;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_Uketorinin.MOSNO+" ASC ,"+HT_Uketorinin.UKTSYUKBN+" ASC ,"+HT_Uketorinin.UKTSYURENNO+" ASC ")
    public  List<HT_Uketorinin> getUketorinins() {
        return hT_Uketorinins;
    }

    private List<HT_MosSyouhn> hT_MosSyouhns = Lists.newLinkedList();
    public HT_MosSyouhn createMosSyouhn() {
        HT_MosSyouhn mosSyouhn =  new HT_MosSyouhn();
        mosSyouhn.setSyoriCTL(this);
        mosSyouhn.setMosno(this.getMosno());
        getMosSyouhns().add(mosSyouhn);
        return mosSyouhn;
    }
    public void setMosSyouhns(List<HT_MosSyouhn> pHT_MosSyouhns) {
        this.hT_MosSyouhns = pHT_MosSyouhns;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_MosSyouhn.MOSNO+" ASC ,"+HT_MosSyouhn.SYOUHNCD+" ASC ")
    public  List<HT_MosSyouhn> getMosSyouhns() {
        return hT_MosSyouhns;
    }

    private List<HT_SkHubi> hT_SkHubis = Lists.newLinkedList();
    public HT_SkHubi createSkHubi() {
        HT_SkHubi skHubi =  new HT_SkHubi();
        skHubi.setSyoriCTL(this);
        skHubi.setMosno(this.getMosno());
        getSkHubis().add(skHubi);
        return skHubi;
    }
    public void setSkHubis(List<HT_SkHubi> pHT_SkHubis) {
        this.hT_SkHubis = pHT_SkHubis;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_SkHubi.MOSNO+" ASC ,"+HT_SkHubi.HUBISIKIBETUKEY+" ASC ")
    public  List<HT_SkHubi> getSkHubis() {
        return hT_SkHubis;
    }

    private List<HT_Kokutisyo> hT_Kokutisyos = Lists.newLinkedList();
    public HT_Kokutisyo createKokutisyo() {
        HT_Kokutisyo kokutisyo =  new HT_Kokutisyo();
        kokutisyo.setSyoriCTL(this);
        kokutisyo.setMosno(this.getMosno());
        setKokutisyo(kokutisyo);
        return kokutisyo;
    }
    @Transient
    public  HT_Kokutisyo getKokutisyo() {
        if(getKokutisyos().size() == 0) {
            return null;
        }
        return getKokutisyos().get(0);
    }
    @Transient
    public void setKokutisyo(HT_Kokutisyo pHT_Kokutisyo) {
        if(this.getKokutisyos().size() >0){
            this.getKokutisyos().set(0, pHT_Kokutisyo) ;
        }else{
            this.getKokutisyos().add(pHT_Kokutisyo) ;
        }
    }
    public void setKokutisyos(List<HT_Kokutisyo> pHT_Kokutisyos) {
        this.hT_Kokutisyos = pHT_Kokutisyos;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_Kokutisyo.MOSNO+" ASC ")
    public  List<HT_Kokutisyo> getKokutisyos() {
        return hT_Kokutisyos;
    }

    private List<HT_Houjyou> hT_Houjyous = Lists.newLinkedList();
    public HT_Houjyou createHoujyou() {
        HT_Houjyou houjyou =  new HT_Houjyou();
        houjyou.setSyoriCTL(this);
        houjyou.setMosno(this.getMosno());
        getHoujyous().add(houjyou);
        return houjyou;
    }
    public void setHoujyous(List<HT_Houjyou> pHT_Houjyous) {
        this.hT_Houjyous = pHT_Houjyous;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_Houjyou.MOSNO+" ASC ,"+HT_Houjyou.SYOSAIKBN+" ASC ")
    public  List<HT_Houjyou> getHoujyous() {
        return hT_Houjyous;
    }

    private List<HT_Tokujyou> hT_Tokujyous = Lists.newLinkedList();
    public HT_Tokujyou createTokujyou() {
        HT_Tokujyou tokujyou =  new HT_Tokujyou();
        tokujyou.setSyoriCTL(this);
        tokujyou.setMosno(this.getMosno());
        setTokujyou(tokujyou);
        return tokujyou;
    }
    @Transient
    public  HT_Tokujyou getTokujyou() {
        if(getTokujyous().size() == 0) {
            return null;
        }
        return getTokujyous().get(0);
    }
    @Transient
    public void setTokujyou(HT_Tokujyou pHT_Tokujyou) {
        if(this.getTokujyous().size() >0){
            this.getTokujyous().set(0, pHT_Tokujyou) ;
        }else{
            this.getTokujyous().add(pHT_Tokujyou) ;
        }
    }
    public void setTokujyous(List<HT_Tokujyou> pHT_Tokujyous) {
        this.hT_Tokujyous = pHT_Tokujyous;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_Tokujyou.MOSNO+" ASC ")
    public  List<HT_Tokujyou> getTokujyous() {
        return hT_Tokujyous;
    }

    private List<HT_ImusateiTokujyou> hT_ImusateiTokujyous = Lists.newLinkedList();
    public HT_ImusateiTokujyou createImusateiTokujyou() {
        HT_ImusateiTokujyou imusateiTokujyou =  new HT_ImusateiTokujyou();
        imusateiTokujyou.setSyoriCTL(this);
        imusateiTokujyou.setMosno(this.getMosno());
        getImusateiTokujyous().add(imusateiTokujyou);
        return imusateiTokujyou;
    }
    public void setImusateiTokujyous(List<HT_ImusateiTokujyou> pHT_ImusateiTokujyous) {
        this.hT_ImusateiTokujyous = pHT_ImusateiTokujyous;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_ImusateiTokujyou.MOSNO+" ASC ,"+HT_ImusateiTokujyou.RENNO+" ASC ")
    public  List<HT_ImusateiTokujyou> getImusateiTokujyous() {
        return hT_ImusateiTokujyous;
    }

    private List<HT_SyouhnTokujyou> hT_SyouhnTokujyous = Lists.newLinkedList();
    public HT_SyouhnTokujyou createSyouhnTokujyou() {
        HT_SyouhnTokujyou syouhnTokujyou =  new HT_SyouhnTokujyou();
        syouhnTokujyou.setSyoriCTL(this);
        syouhnTokujyou.setMosno(this.getMosno());
        getSyouhnTokujyous().add(syouhnTokujyou);
        return syouhnTokujyou;
    }
    public void setSyouhnTokujyous(List<HT_SyouhnTokujyou> pHT_SyouhnTokujyous) {
        this.hT_SyouhnTokujyous = pHT_SyouhnTokujyous;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_SyouhnTokujyou.MOSNO+" ASC ,"+HT_SyouhnTokujyou.SYOUHNCD+" ASC ")
    public  List<HT_SyouhnTokujyou> getSyouhnTokujyous() {
        return hT_SyouhnTokujyous;
    }

    private List<HT_ImusateiSyouhnTokujyou> hT_ImusateiSyouhnTokujyous = Lists.newLinkedList();
    public HT_ImusateiSyouhnTokujyou createImusateiSyouhnTokujyou() {
        HT_ImusateiSyouhnTokujyou imusateiSyouhnTokujyou =  new HT_ImusateiSyouhnTokujyou();
        imusateiSyouhnTokujyou.setSyoriCTL(this);
        imusateiSyouhnTokujyou.setMosno(this.getMosno());
        getImusateiSyouhnTokujyous().add(imusateiSyouhnTokujyou);
        return imusateiSyouhnTokujyou;
    }
    public void setImusateiSyouhnTokujyous(List<HT_ImusateiSyouhnTokujyou> pHT_ImusateiSyouhnTokujyous) {
        this.hT_ImusateiSyouhnTokujyous = pHT_ImusateiSyouhnTokujyous;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_ImusateiSyouhnTokujyou.MOSNO+" ASC ,"+HT_ImusateiSyouhnTokujyou.RENNO+" ASC ,"+HT_ImusateiSyouhnTokujyou.SYOUHNCD+" ASC ")
    public  List<HT_ImusateiSyouhnTokujyou> getImusateiSyouhnTokujyous() {
        return hT_ImusateiSyouhnTokujyous;
    }

    private List<HT_DakuhiKettei> hT_DakuhiKetteis = Lists.newLinkedList();
    public HT_DakuhiKettei createDakuhiKettei() {
        HT_DakuhiKettei dakuhiKettei =  new HT_DakuhiKettei();
        dakuhiKettei.setSyoriCTL(this);
        dakuhiKettei.setMosno(this.getMosno());
        getDakuhiKetteis().add(dakuhiKettei);
        return dakuhiKettei;
    }
    public void setDakuhiKetteis(List<HT_DakuhiKettei> pHT_DakuhiKetteis) {
        this.hT_DakuhiKetteis = pHT_DakuhiKetteis;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_DakuhiKettei.MOSNO+" ASC ,"+HT_DakuhiKettei.DAKUHIKTRENNO+" ASC ")
    public  List<HT_DakuhiKettei> getDakuhiKetteis() {
        return hT_DakuhiKetteis;
    }

    private List<HT_ImusateiRireki> hT_ImusateiRirekis = Lists.newLinkedList();
    public HT_ImusateiRireki createImusateiRireki() {
        HT_ImusateiRireki imusateiRireki =  new HT_ImusateiRireki();
        imusateiRireki.setSyoriCTL(this);
        imusateiRireki.setMosno(this.getMosno());
        getImusateiRirekis().add(imusateiRireki);
        return imusateiRireki;
    }
    public void setImusateiRirekis(List<HT_ImusateiRireki> pHT_ImusateiRirekis) {
        this.hT_ImusateiRirekis = pHT_ImusateiRirekis;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_ImusateiRireki.MOSNO+" ASC ,"+HT_ImusateiRireki.RENNO+" ASC ")
    public  List<HT_ImusateiRireki> getImusateiRirekis() {
        return hT_ImusateiRirekis;
    }

    private List<HT_KnksateiRireki> hT_KnksateiRirekis = Lists.newLinkedList();
    public HT_KnksateiRireki createKnksateiRireki() {
        HT_KnksateiRireki knksateiRireki =  new HT_KnksateiRireki();
        knksateiRireki.setSyoriCTL(this);
        knksateiRireki.setMosno(this.getMosno());
        getKnksateiRirekis().add(knksateiRireki);
        return knksateiRireki;
    }
    public void setKnksateiRirekis(List<HT_KnksateiRireki> pHT_KnksateiRirekis) {
        this.hT_KnksateiRirekis = pHT_KnksateiRirekis;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_KnksateiRireki.MOSNO+" ASC ,"+HT_KnksateiRireki.RENNO+" ASC ")
    public  List<HT_KnksateiRireki> getKnksateiRirekis() {
        return hT_KnksateiRirekis;
    }

    private List<HT_MostenkenRireki> hT_MostenkenRirekis = Lists.newLinkedList();
    public HT_MostenkenRireki createMostenkenRireki() {
        HT_MostenkenRireki mostenkenRireki =  new HT_MostenkenRireki();
        mostenkenRireki.setSyoriCTL(this);
        mostenkenRireki.setMosno(this.getMosno());
        getMostenkenRirekis().add(mostenkenRireki);
        return mostenkenRireki;
    }
    public void setMostenkenRirekis(List<HT_MostenkenRireki> pHT_MostenkenRirekis) {
        this.hT_MostenkenRirekis = pHT_MostenkenRirekis;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_MostenkenRireki.MOSNO+" ASC ,"+HT_MostenkenRireki.RENNO+" ASC ")
    public  List<HT_MostenkenRireki> getMostenkenRirekis() {
        return hT_MostenkenRirekis;
    }

    private List<HT_Tokunin> hT_Tokunins = Lists.newLinkedList();
    public HT_Tokunin createTokunin() {
        HT_Tokunin tokunin =  new HT_Tokunin();
        tokunin.setSyoriCTL(this);
        tokunin.setMosno(this.getMosno());
        setTokunin(tokunin);
        return tokunin;
    }
    @Transient
    public  HT_Tokunin getTokunin() {
        if(getTokunins().size() == 0) {
            return null;
        }
        return getTokunins().get(0);
    }
    @Transient
    public void setTokunin(HT_Tokunin pHT_Tokunin) {
        if(this.getTokunins().size() >0){
            this.getTokunins().set(0, pHT_Tokunin) ;
        }else{
            this.getTokunins().add(pHT_Tokunin) ;
        }
    }
    public void setTokunins(List<HT_Tokunin> pHT_Tokunins) {
        this.hT_Tokunins = pHT_Tokunins;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_Tokunin.MOSNO+" ASC ")
    public  List<HT_Tokunin> getTokunins() {
        return hT_Tokunins;
    }

    private List<HT_ImuSonotaTkykJktk> hT_ImuSonotaTkykJktks = Lists.newLinkedList();
    public HT_ImuSonotaTkykJktk createImuSonotaTkykJktk() {
        HT_ImuSonotaTkykJktk imuSonotaTkykJktk =  new HT_ImuSonotaTkykJktk();
        imuSonotaTkykJktk.setSyoriCTL(this);
        imuSonotaTkykJktk.setMosno(this.getMosno());
        getImuSonotaTkykJktks().add(imuSonotaTkykJktk);
        return imuSonotaTkykJktk;
    }
    public void setImuSonotaTkykJktks(List<HT_ImuSonotaTkykJktk> pHT_ImuSonotaTkykJktks) {
        this.hT_ImuSonotaTkykJktks = pHT_ImuSonotaTkykJktks;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_ImuSonotaTkykJktk.MOSNO+" ASC ,"+HT_ImuSonotaTkykJktk.RENNO+" ASC ,"+HT_ImuSonotaTkykJktk.PMNJTKKBN+" ASC ")
    public  List<HT_ImuSonotaTkykJktk> getImuSonotaTkykJktks() {
        return hT_ImuSonotaTkykJktks;
    }

    private List<HT_SonotaTkykJktk> hT_SonotaTkykJktks = Lists.newLinkedList();
    public HT_SonotaTkykJktk createSonotaTkykJktk() {
        HT_SonotaTkykJktk sonotaTkykJktk =  new HT_SonotaTkykJktk();
        sonotaTkykJktk.setSyoriCTL(this);
        sonotaTkykJktk.setMosno(this.getMosno());
        getSonotaTkykJktks().add(sonotaTkykJktk);
        return sonotaTkykJktk;
    }
    public void setSonotaTkykJktks(List<HT_SonotaTkykJktk> pHT_SonotaTkykJktks) {
        this.hT_SonotaTkykJktks = pHT_SonotaTkykJktks;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_SonotaTkykJktk.MOSNO+" ASC ,"+HT_SonotaTkykJktk.PMNJTKKBN+" ASC ")
    public  List<HT_SonotaTkykJktk> getSonotaTkykJktks() {
        return hT_SonotaTkykJktks;
    }

    private List<HT_RuleHanteiMsg> hT_RuleHanteiMsgs = Lists.newLinkedList();
    public HT_RuleHanteiMsg createRuleHanteiMsg() {
        HT_RuleHanteiMsg ruleHanteiMsg =  new HT_RuleHanteiMsg();
        ruleHanteiMsg.setSyoriCTL(this);
        ruleHanteiMsg.setMosno(this.getMosno());
        getRuleHanteiMsgs().add(ruleHanteiMsg);
        return ruleHanteiMsg;
    }
    public void setRuleHanteiMsgs(List<HT_RuleHanteiMsg> pHT_RuleHanteiMsgs) {
        this.hT_RuleHanteiMsgs = pHT_RuleHanteiMsgs;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_RuleHanteiMsg.MOSNO+" ASC ,"+HT_RuleHanteiMsg.RULEHANTEIMSG+" ASC ,"+HT_RuleHanteiMsg.RENNO+" ASC ")
    public  List<HT_RuleHanteiMsg> getRuleHanteiMsgs() {
        return hT_RuleHanteiMsgs;
    }

    private List<HT_KykKak> hT_KykKaks = Lists.newLinkedList();
    public HT_KykKak createKykKak() {
        HT_KykKak kykKak =  new HT_KykKak();
        kykKak.setSyoriCTL(this);
        kykKak.setMosno(this.getMosno());
        getKykKaks().add(kykKak);
        return kykKak;
    }
    public void setKykKaks(List<HT_KykKak> pHT_KykKaks) {
        this.hT_KykKaks = pHT_KykKaks;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_KykKak.MOSNO+" ASC ,"+HT_KykKak.RENNO+" ASC ")
    public  List<HT_KykKak> getKykKaks() {
        return hT_KykKaks;
    }

    private List<HT_Tuusan> hT_Tuusans = Lists.newLinkedList();
    public HT_Tuusan createTuusan() {
        HT_Tuusan tuusan =  new HT_Tuusan();
        tuusan.setSyoriCTL(this);
        tuusan.setMosno(this.getMosno());
        setTuusan(tuusan);
        return tuusan;
    }
    @Transient
    public  HT_Tuusan getTuusan() {
        if(getTuusans().size() == 0) {
            return null;
        }
        return getTuusans().get(0);
    }
    @Transient
    public void setTuusan(HT_Tuusan pHT_Tuusan) {
        if(this.getTuusans().size() >0){
            this.getTuusans().set(0, pHT_Tuusan) ;
        }else{
            this.getTuusans().add(pHT_Tuusan) ;
        }
    }
    public void setTuusans(List<HT_Tuusan> pHT_Tuusans) {
        this.hT_Tuusans = pHT_Tuusans;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_Tuusan.MOSNO+" ASC ")
    public  List<HT_Tuusan> getTuusans() {
        return hT_Tuusans;
    }

    private List<HT_NayoseKekka> hT_NayoseKekkas = Lists.newLinkedList();
    public HT_NayoseKekka createNayoseKekka() {
        HT_NayoseKekka nayoseKekka =  new HT_NayoseKekka();
        nayoseKekka.setSyoriCTL(this);
        nayoseKekka.setMosno(this.getMosno());
        getNayoseKekkas().add(nayoseKekka);
        return nayoseKekka;
    }
    public void setNayoseKekkas(List<HT_NayoseKekka> pHT_NayoseKekkas) {
        this.hT_NayoseKekkas = pHT_NayoseKekkas;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_NayoseKekka.MOSNO+" ASC ,"+HT_NayoseKekka.SNTKINFOTAISYOUSYAKBN+" ASC ,"+HT_NayoseKekka.EDANO+" ASC ")
    public  List<HT_NayoseKekka> getNayoseKekkas() {
        return hT_NayoseKekkas;
    }

    private List<HT_Nyuukin> hT_Nyuukins = Lists.newLinkedList();
    public HT_Nyuukin createNyuukin() {
        HT_Nyuukin nyuukin =  new HT_Nyuukin();
        nyuukin.setSyoriCTL(this);
        nyuukin.setMosno(this.getMosno());
        getNyuukins().add(nyuukin);
        return nyuukin;
    }
    public void setNyuukins(List<HT_Nyuukin> pHT_Nyuukins) {
        this.hT_Nyuukins = pHT_Nyuukins;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_Nyuukin.MOSNO+" ASC ,"+HT_Nyuukin.RENNO+" ASC ")
    public  List<HT_Nyuukin> getNyuukins() {
        return hT_Nyuukins;
    }

    private List<HT_Henkin> hT_Henkins = Lists.newLinkedList();
    public HT_Henkin createHenkin() {
        HT_Henkin henkin =  new HT_Henkin();
        henkin.setSyoriCTL(this);
        henkin.setMosno(this.getMosno());
        getHenkins().add(henkin);
        return henkin;
    }
    public void setHenkins(List<HT_Henkin> pHT_Henkins) {
        this.hT_Henkins = pHT_Henkins;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_Henkin.MOSNO+" ASC ,"+HT_Henkin.RENNO+" ASC ")
    public  List<HT_Henkin> getHenkins() {
        return hT_Henkins;
    }

    private List<HT_MosKihonVrf> hT_MosKihonVrfs = Lists.newLinkedList();
    public HT_MosKihonVrf createMosKihonVrf() {
        HT_MosKihonVrf mosKihonVrf =  new HT_MosKihonVrf();
        mosKihonVrf.setSyoriCTL(this);
        mosKihonVrf.setMosno(this.getMosno());
        setMosKihonVrf(mosKihonVrf);
        return mosKihonVrf;
    }
    @Transient
    public  HT_MosKihonVrf getMosKihonVrf() {
        if(getMosKihonVrfs().size() == 0) {
            return null;
        }
        return getMosKihonVrfs().get(0);
    }
    @Transient
    public void setMosKihonVrf(HT_MosKihonVrf pHT_MosKihonVrf) {
        if(this.getMosKihonVrfs().size() >0){
            this.getMosKihonVrfs().set(0, pHT_MosKihonVrf) ;
        }else{
            this.getMosKihonVrfs().add(pHT_MosKihonVrf) ;
        }
    }
    public void setMosKihonVrfs(List<HT_MosKihonVrf> pHT_MosKihonVrfs) {
        this.hT_MosKihonVrfs = pHT_MosKihonVrfs;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_MosKihonVrf.MOSNO+" ASC ")
    public  List<HT_MosKihonVrf> getMosKihonVrfs() {
        return hT_MosKihonVrfs;
    }

    private List<HT_NrkDif> hT_NrkDifs = Lists.newLinkedList();
    public HT_NrkDif createNrkDif() {
        HT_NrkDif nrkDif =  new HT_NrkDif();
        nrkDif.setSyoriCTL(this);
        nrkDif.setMosno(this.getMosno());
        getNrkDifs().add(nrkDif);
        return nrkDif;
    }
    public void setNrkDifs(List<HT_NrkDif> pHT_NrkDifs) {
        this.hT_NrkDifs = pHT_NrkDifs;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_NrkDif.MOSNO+" ASC ,"+HT_NrkDif.VRFKINOUID+" ASC ,"+HT_NrkDif.RENNO3KETA+" ASC ")
    public  List<HT_NrkDif> getNrkDifs() {
        return hT_NrkDifs;
    }

    private List<HT_UketorininVrf> hT_UketorininVrfs = Lists.newLinkedList();
    public HT_UketorininVrf createUketorininVrf() {
        HT_UketorininVrf uketorininVrf =  new HT_UketorininVrf();
        uketorininVrf.setSyoriCTL(this);
        uketorininVrf.setMosno(this.getMosno());
        getUketorininVrfs().add(uketorininVrf);
        return uketorininVrf;
    }
    public void setUketorininVrfs(List<HT_UketorininVrf> pHT_UketorininVrfs) {
        this.hT_UketorininVrfs = pHT_UketorininVrfs;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_UketorininVrf.MOSNO+" ASC ,"+HT_UketorininVrf.UKTSYUKBN+" ASC ,"+HT_UketorininVrf.UKTSYURENNO+" ASC ")
    public  List<HT_UketorininVrf> getUketorininVrfs() {
        return hT_UketorininVrfs;
    }

    private List<HT_MosDairitenVrf> hT_MosDairitenVrfs = Lists.newLinkedList();
    public HT_MosDairitenVrf createMosDairitenVrf() {
        HT_MosDairitenVrf mosDairitenVrf =  new HT_MosDairitenVrf();
        mosDairitenVrf.setSyoriCTL(this);
        mosDairitenVrf.setMosno(this.getMosno());
        getMosDairitenVrfs().add(mosDairitenVrf);
        return mosDairitenVrf;
    }
    public void setMosDairitenVrfs(List<HT_MosDairitenVrf> pHT_MosDairitenVrfs) {
        this.hT_MosDairitenVrfs = pHT_MosDairitenVrfs;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_MosDairitenVrf.MOSNO+" ASC ,"+HT_MosDairitenVrf.RENNO+" ASC ")
    public  List<HT_MosDairitenVrf> getMosDairitenVrfs() {
        return hT_MosDairitenVrfs;
    }

    private List<HT_MosSyouhnVrf> hT_MosSyouhnVrfs = Lists.newLinkedList();
    public HT_MosSyouhnVrf createMosSyouhnVrf() {
        HT_MosSyouhnVrf mosSyouhnVrf =  new HT_MosSyouhnVrf();
        mosSyouhnVrf.setSyoriCTL(this);
        mosSyouhnVrf.setMosno(this.getMosno());
        getMosSyouhnVrfs().add(mosSyouhnVrf);
        return mosSyouhnVrf;
    }
    public void setMosSyouhnVrfs(List<HT_MosSyouhnVrf> pHT_MosSyouhnVrfs) {
        this.hT_MosSyouhnVrfs = pHT_MosSyouhnVrfs;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_MosSyouhnVrf.MOSNO+" ASC ,"+HT_MosSyouhnVrf.SYOUHNCD+" ASC ")
    public  List<HT_MosSyouhnVrf> getMosSyouhnVrfs() {
        return hT_MosSyouhnVrfs;
    }

    private List<HT_KouzaJyouhouVrf> hT_KouzaJyouhouVrfs = Lists.newLinkedList();
    public HT_KouzaJyouhouVrf createKouzaJyouhouVrf() {
        HT_KouzaJyouhouVrf kouzaJyouhouVrf =  new HT_KouzaJyouhouVrf();
        kouzaJyouhouVrf.setSyoriCTL(this);
        kouzaJyouhouVrf.setMosno(this.getMosno());
        setKouzaJyouhouVrf(kouzaJyouhouVrf);
        return kouzaJyouhouVrf;
    }
    @Transient
    public  HT_KouzaJyouhouVrf getKouzaJyouhouVrf() {
        if(getKouzaJyouhouVrfs().size() == 0) {
            return null;
        }
        return getKouzaJyouhouVrfs().get(0);
    }
    @Transient
    public void setKouzaJyouhouVrf(HT_KouzaJyouhouVrf pHT_KouzaJyouhouVrf) {
        if(this.getKouzaJyouhouVrfs().size() >0){
            this.getKouzaJyouhouVrfs().set(0, pHT_KouzaJyouhouVrf) ;
        }else{
            this.getKouzaJyouhouVrfs().add(pHT_KouzaJyouhouVrf) ;
        }
    }
    public void setKouzaJyouhouVrfs(List<HT_KouzaJyouhouVrf> pHT_KouzaJyouhouVrfs) {
        this.hT_KouzaJyouhouVrfs = pHT_KouzaJyouhouVrfs;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_KouzaJyouhouVrf.MOSNO+" ASC ")
    public  List<HT_KouzaJyouhouVrf> getKouzaJyouhouVrfs() {
        return hT_KouzaJyouhouVrfs;
    }

    private List<HT_UketoriKouzaJyouhouVrf> hT_UketoriKouzaJyouhouVrfs = Lists.newLinkedList();
    public HT_UketoriKouzaJyouhouVrf createUketoriKouzaJyouhouVrf() {
        HT_UketoriKouzaJyouhouVrf uketoriKouzaJyouhouVrf =  new HT_UketoriKouzaJyouhouVrf();
        uketoriKouzaJyouhouVrf.setSyoriCTL(this);
        uketoriKouzaJyouhouVrf.setMosno(this.getMosno());
        getUketoriKouzaJyouhouVrfs().add(uketoriKouzaJyouhouVrf);
        return uketoriKouzaJyouhouVrf;
    }
    public void setUketoriKouzaJyouhouVrfs(List<HT_UketoriKouzaJyouhouVrf> pHT_UketoriKouzaJyouhouVrfs) {
        this.hT_UketoriKouzaJyouhouVrfs = pHT_UketoriKouzaJyouhouVrfs;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_UketoriKouzaJyouhouVrf.MOSNO+" ASC ,"+HT_UketoriKouzaJyouhouVrf.UKTKZSYUBETUKBN+" ASC ")
    public  List<HT_UketoriKouzaJyouhouVrf> getUketoriKouzaJyouhouVrfs() {
        return hT_UketoriKouzaJyouhouVrfs;
    }

    private List<HT_KokutisyoVrf> hT_KokutisyoVrfs = Lists.newLinkedList();
    public HT_KokutisyoVrf createKokutisyoVrf() {
        HT_KokutisyoVrf kokutisyoVrf =  new HT_KokutisyoVrf();
        kokutisyoVrf.setSyoriCTL(this);
        kokutisyoVrf.setMosno(this.getMosno());
        setKokutisyoVrf(kokutisyoVrf);
        return kokutisyoVrf;
    }
    @Transient
    public  HT_KokutisyoVrf getKokutisyoVrf() {
        if(getKokutisyoVrfs().size() == 0) {
            return null;
        }
        return getKokutisyoVrfs().get(0);
    }
    @Transient
    public void setKokutisyoVrf(HT_KokutisyoVrf pHT_KokutisyoVrf) {
        if(this.getKokutisyoVrfs().size() >0){
            this.getKokutisyoVrfs().set(0, pHT_KokutisyoVrf) ;
        }else{
            this.getKokutisyoVrfs().add(pHT_KokutisyoVrf) ;
        }
    }
    public void setKokutisyoVrfs(List<HT_KokutisyoVrf> pHT_KokutisyoVrfs) {
        this.hT_KokutisyoVrfs = pHT_KokutisyoVrfs;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_KokutisyoVrf.MOSNO+" ASC ")
    public  List<HT_KokutisyoVrf> getKokutisyoVrfs() {
        return hT_KokutisyoVrfs;
    }

    private List<HT_SentakuJyouhou> hT_SentakuJyouhous = Lists.newLinkedList();
    public HT_SentakuJyouhou createSentakuJyouhou() {
        HT_SentakuJyouhou sentakuJyouhou =  new HT_SentakuJyouhou();
        sentakuJyouhou.setSyoriCTL(this);
        sentakuJyouhou.setMosno(this.getMosno());
        getSentakuJyouhous().add(sentakuJyouhou);
        return sentakuJyouhou;
    }
    public void setSentakuJyouhous(List<HT_SentakuJyouhou> pHT_SentakuJyouhous) {
        this.hT_SentakuJyouhous = pHT_SentakuJyouhous;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_SentakuJyouhou.MOSNO+" ASC ,"+HT_SentakuJyouhou.SNTKINFOTAISYOUSYAKBN+" ASC ,"+HT_SentakuJyouhou.EDANO+" ASC ,"+HT_SentakuJyouhou.SNTKINFONO+" ASC ")
    public  List<HT_SentakuJyouhou> getSentakuJyouhous() {
        return hT_SentakuJyouhous;
    }

    private List<HT_MosTrkKzk> hT_MosTrkKzks = Lists.newLinkedList();
    public HT_MosTrkKzk createMosTrkKzk() {
        HT_MosTrkKzk mosTrkKzk =  new HT_MosTrkKzk();
        mosTrkKzk.setSyoriCTL(this);
        mosTrkKzk.setMosno(this.getMosno());
        getMosTrkKzks().add(mosTrkKzk);
        return mosTrkKzk;
    }
    public void setMosTrkKzks(List<HT_MosTrkKzk> pHT_MosTrkKzks) {
        this.hT_MosTrkKzks = pHT_MosTrkKzks;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_MosTrkKzk.MOSNO+" ASC ,"+HT_MosTrkKzk.TRKKZKKBN+" ASC ")
    public  List<HT_MosTrkKzk> getMosTrkKzks() {
        return hT_MosTrkKzks;
    }

    private List<HT_MosTrkKzkVrf> hT_MosTrkKzkVrfs = Lists.newLinkedList();
    public HT_MosTrkKzkVrf createMosTrkKzkVrf() {
        HT_MosTrkKzkVrf mosTrkKzkVrf =  new HT_MosTrkKzkVrf();
        mosTrkKzkVrf.setSyoriCTL(this);
        mosTrkKzkVrf.setMosno(this.getMosno());
        getMosTrkKzkVrfs().add(mosTrkKzkVrf);
        return mosTrkKzkVrf;
    }
    public void setMosTrkKzkVrfs(List<HT_MosTrkKzkVrf> pHT_MosTrkKzkVrfs) {
        this.hT_MosTrkKzkVrfs = pHT_MosTrkKzkVrfs;
    }
    @OneToMany (
        mappedBy = "syoriCTL",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_MosTrkKzkVrf.MOSNO+" ASC ,"+HT_MosTrkKzkVrf.TRKKZKKBN+" ASC ")
    public  List<HT_MosTrkKzkVrf> getMosTrkKzkVrfs() {
        return hT_MosTrkKzkVrfs;
    }

    @Transient
    public  List<HT_SkTtdkTyuui> getSkTtdkTyuuisBySkeittdkrenrakukbn(C_SkeittdkrenrakuKbn pSkeittdkrenrakukbn) {
        return new ArrayList<HT_SkTtdkTyuui>(Collections2.filter(getSkTtdkTyuuis(), new FilterSkTtdkTyuuiBySkeittdkrenrakukbn(pSkeittdkrenrakukbn)));
    }
    @Transient
    public  List<HT_HubiMsg> getHubiMsgsByHubimsg(String pHubimsg) {
        return new ArrayList<HT_HubiMsg>(Collections2.filter(getHubiMsgs(),
            new FilterHubiMsgByHubimsg(pHubimsg)));
    }
    @Transient
    public  List<HT_HubiMsg> getHubiMsgsByMessageId(String pMessageId1keta) {
        return new ArrayList<HT_HubiMsg>(Collections2.filter(getHubiMsgs(),
            new FilterHubiMsgByMessageId(pMessageId1keta)));
    }
    @Transient
    public  List<HT_HubiMsg> getHubiMsgsByHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn pHubisyubetusyousaikbn) {
        return new ArrayList<HT_HubiMsg>(Collections2.filter(getHubiMsgs(),
            new FilterHubiMsgByHubisyubetusyousaikbn(pHubisyubetusyousaikbn)));
    }
    @Transient
    public  HT_UketoriKouzaJyouhou getUketoriKouzaJyouhouByUktkzsyubetukbn(C_UketorikouzasyubetuKbn pUktkzsyubetukbn) {
        return Iterables.getFirst(Iterables.filter(getUketoriKouzaJyouhous(),
            new FilterUketoriKouzaJyouhouByUktkzsyubetukbn(pUktkzsyubetukbn)), null);
    }
    @Transient
    public  HT_MosDairiten getMosDairitenByRenno(Integer pRenno) {
        return Iterables.getFirst(Iterables.filter(getMosDairitens(),
            new FilterMosDairitenByRenno(pRenno)), null);
    }
    @Transient
    public  List<HT_Uketorinin> getUketorininsByUktsyukbn(C_UktsyuKbn pUktsyukbn) {
        return new ArrayList<HT_Uketorinin>(Collections2.filter(getUketorinins(),
            new FilterUketorininByUktsyukbn(pUktsyukbn)));
    }
    @Transient
    public  HT_Uketorinin getUketorininByUktsyukbnUktsyurenno(C_UktsyuKbn pUktsyukbn,Integer pUktsyurenno) {
        return Iterables.getFirst(Iterables.filter(getUketorinins(),
            new FilterUketorininByUktsyukbnUktsyurenno(pUktsyukbn, pUktsyurenno)), null);
    }
    @Transient
    public  List<HT_MosSyouhn> getMosSyouhnsByKatakbns(C_KataKbn... pKatakbn) {
        return new ArrayList<HT_MosSyouhn>(Collections2.filter(getMosSyouhns(),
            new FilterMosSyouhnByKatakbns(pKatakbn)));
    }
    @Transient
    public  List<HT_MosSyouhn> getMosSyouhnsBySyutkkbn(C_SyutkKbn pSyutkkbn) {
        return new ArrayList<HT_MosSyouhn>(Collections2.filter(getMosSyouhns(),
            new FilterMosSyouhnBySyutkkbn(pSyutkkbn)));
    }
    @Transient
    public  List<HT_MosSyouhn> getMosSyouhnsBySyouhnZokuseiGanhsyngumu(C_UmuKbn pGanhsyngumu) {
        return new ArrayList<HT_MosSyouhn>(Collections2.filter(getMosSyouhns(),
            new FilterMosSyouhnByGanhsyngumu(pGanhsyngumu)));
    }
    @Transient
    public  HT_MosSyouhn getMosSyouhnBySyouhncd(String pSyouhncd) {
        return Iterables.getFirst(Iterables.filter(getMosSyouhns(),
            new FilterMosSyouhnBySyouhncd(pSyouhncd)), null);
    }
    @Transient
    public  List<HT_SkHubi> getSkHubisByHasinymdNotNullKaisyouymdNull() {
        return new ArrayList<HT_SkHubi>(Collections2.filter(getSkHubis(),
            new FilterSkHubiByHasinymdNotNullKaisyouymdNull()));
    }
    @Transient
    public  HT_SkHubi getSkHubiByHubisikibetukey(String pHubisikibetukey) {
        return Iterables.getFirst(Iterables.filter(getSkHubis(),
            new FilterSkHubiByHubisikibetukey(pHubisikibetukey)), null);
    }
    @Transient
    public  HT_Houjyou getHoujyouBySyosaikbn(C_SyosaiKbn pSyosaikbn) {
        return Iterables.getFirst(Iterables.filter(getHoujyous(),
            new FilterHoujyouBySyosaikbn(pSyosaikbn)), null);
    }

    @Transient
    public  HT_ImusateiTokujyou getImusateiTokujyouByRenno(Integer pRenno) {
        return Iterables.getFirst(Iterables.filter(getImusateiTokujyous(),
            new FilterImusateiTokujyouByRenno(pRenno)), null);
    }
    @Transient
    public  List<HT_ImusateiSyouhnTokujyou> getImusateiSyouhnTokujyousByRenno(Integer pRenno) {
        return new ArrayList<HT_ImusateiSyouhnTokujyou>(Collections2.filter(getImusateiSyouhnTokujyous(),
            new FilterImusateiSyouhnTokujyouByRenno(pRenno)));
    }
    @Transient
    public  List<HT_DakuhiKettei> getDakuhiKetteisByKetkekkacds() {
        return new ArrayList<HT_DakuhiKettei>(Collections2.filter(getDakuhiKetteis(),
            new FilterDakuhiKetteiByKetkekkacds()));
    }
    @Transient
    public  List<HT_DakuhiKettei> getDakuhiKetteisByKetkekkacd(C_Ketkekkacd  pKetkekkacd) {
        return new ArrayList<HT_DakuhiKettei>(Collections2.filter(getDakuhiKetteis(),
            new FilterDakuhiKetteiByKetkekkacd(pKetkekkacd)));
    }
    @Transient
    public  HT_DakuhiKettei getDakuhiKetteiByDakuhiktrenno(Integer pDakuhiktrenno) {
        return Iterables.getFirst(Iterables.filter(getDakuhiKetteis(),
            new FilterDakuhiKetteiByDakuhiktrenno(pDakuhiktrenno)), null);
    }
    @Transient
    public  List<HT_ImusateiRireki> getImusateiRirekisByImusateikekkakbn(C_SyorikekkaKbn pImusateikekkakbn) {
        return new ArrayList<HT_ImusateiRireki>(Collections2.filter(getImusateiRirekis(),
            new FilterImusateiRirekiByImusateikekkakbn(pImusateikekkakbn)));
    }
    @Transient
    public  List<HT_KnksateiRireki> getKnksateiRirekisByKnksateikekkakbn() {

        return new ArrayList<HT_KnksateiRireki>(Collections2.filter(getKnksateiRirekis(),
            new FilterKnksateiRirekiByKnksateikekkakbn()));
    }
    @Transient
    public  List<HT_ImuSonotaTkykJktk> getImuSonotaTkykJktksByRenno(Integer pRenno) {
        return new ArrayList<HT_ImuSonotaTkykJktk>(Collections2.filter(getImuSonotaTkykJktks(),
            new FilterImuSonotaTkykJktkByRenno(pRenno)));
    }
    @Transient
    public  List<HT_RuleHanteiMsg> getRuleHanteiMsgsByRulehanteimsg(C_Rulehanteimsg pRulehanteimsg) {
        return new ArrayList<HT_RuleHanteiMsg>(Collections2.filter(getRuleHanteiMsgs(),
            new FilterRuleHanteiMsgByRulehanteimsg(pRulehanteimsg)));
    }
    @Transient
    public  HT_KykKak getKykKakByRenno(Integer pRenno) {
        return Iterables.getFirst(Iterables.filter(getKykKaks(),
            new FilterKykKakByRenno(pRenno)), null);
    }
    @Transient
    public  HT_NayoseKekka getNayoseKekkaBySntkinfotaisyousyakbnEdano(C_SntkInfoTaisyousyaKbn pSntkinfotaisyousyakbn,Integer pEdano) {
        return Iterables.getFirst(Iterables.filter(getNayoseKekkas(),
            new FilterNayoseKekkaBySntkinfotaisyousyakbnEdano(pSntkinfotaisyousyakbn, pEdano)), null);
    }
    @Transient
    public  List<HT_NayoseKekka> getNayoseKekkasBySntkinfotaisyousyakbn() {
        return new ArrayList<HT_NayoseKekka>(Collections2.filter(getNayoseKekkas(),
            new FilterNayoseKekkaBySntkinfotaisyousyakbn()));
    }
    @Transient
    public  List<HT_NayoseKekka> getNayoseKekkasBySignalsetteiumukbn() {
        return new ArrayList<HT_NayoseKekka>(Collections2.filter(getNayoseKekkas(),
            new FilterNayoseKekkaBySignalsetteiumukbn()));
    }
    @Transient
    public  List<HT_NayoseKekka> getNayoseKekkasBySntkinfotaisyousyakbnNysjissikekkakbn() {
        return new ArrayList<HT_NayoseKekka>(Collections2.filter(getNayoseKekkas(),
            new FilterNayoseKekkaBySntkinfotaisyousyakbnNysjissikekkakbn()));
    }
    @Transient
    public  List<HT_Nyuukin> getNyuukinsByZenhnknkbnNe(C_ZenhnknKbn pZenhnknkbn) {
        return new ArrayList<HT_Nyuukin>(Collections2.filter(getNyuukins(),
            new FilterNyuukinByZenhnknkbnNe(pZenhnknkbn)));
    }
    @Transient
    public  List<HT_Nyuukin> getNyuukinsByZenhnknkbn(C_ZenhnknKbn pZenhnknkbn) {
        return new ArrayList<HT_Nyuukin>(Collections2.filter(getNyuukins(), new FilterNyuukinsByZenhnknkbn(pZenhnknkbn)));
    }
    @Transient
    public  List<HT_Nyuukin> getNyuukinsByZenhnknkbnBlank() {
        return new ArrayList<HT_Nyuukin>(Collections2.filter(getNyuukins(),
            new FilterNyuukinByZenhnknkbnBlank()));
    }
    @Transient
    public  Map<CurrencyType, BizCurrency> getNyuukinSumRyosyugk() {
        List<HT_Nyuukin> nyuukinLst = getNyuukins();

                Map<CurrencyType, BizCurrency> sumRskngk = new HashMap<>();

                BizCurrency rskngkTmp = null;

                CurrencyType type = null;

        for (HT_Nyuukin nyuukin : nyuukinLst) {

                        rskngkTmp = nyuukin.getRsgaku();

            if (rskngkTmp != null) {

                                type = rskngkTmp.getType();

                if (!sumRskngk.containsKey(type)) {

                                        sumRskngk.put(type, rskngkTmp);
                } else {

                                        sumRskngk.put(type, sumRskngk.get(type).add(rskngkTmp));
                }
            }
        }
                return sumRskngk;
    }
    @Transient
    public  List<HT_Nyuukin> getNyuukinsByNyknsyubetu(C_NyknsyubetuKbn pNyknsyubetu) {
        return new ArrayList<HT_Nyuukin>(Collections2.filter(getNyuukins(),
            new FilterNyuukinByNyknsyubetu(pNyknsyubetu)));
    }
    @Transient
    public  List<HT_Nyuukin> getNyuukinByNyknsyubetuNe(C_NyknsyubetuKbn pNyknsyubetu) {
        return new ArrayList<HT_Nyuukin>(Collections2.filter(getNyuukins(),
            new FilterNyuukinByNyknsyubetuNe(pNyknsyubetu)));
    }
    @Transient
    public  Map<CurrencyType, BizCurrency> getNyuukinSumRsgakuByRstuukasyu(C_Tuukasyu pRstuukasyu) {
                List<HT_Nyuukin> nyuukinLst = new ArrayList<HT_Nyuukin>(Collections2.filter(getNyuukins(),
            new FilterNyuukinByRstuukasyu(pRstuukasyu)));

                HashMap<CurrencyType, BizCurrency> sumRsgaku = new HashMap<>();

                BizCurrency rsgakuTmp = null;

                CurrencyType rsgakuType = null;

                for (HT_Nyuukin nyuukin : nyuukinLst) {

                        rsgakuTmp = nyuukin.getRsgaku();

                        if (rsgakuTmp != null) {

                                rsgakuType = rsgakuTmp.getType();

                                                if (!sumRsgaku.containsKey(rsgakuType)) {

                                        sumRsgaku.put(rsgakuType, rsgakuTmp);
                }
                                else {

                                        sumRsgaku.put(rsgakuType, sumRsgaku.get(rsgakuType).add(rsgakuTmp));
                }
            }
        }

        return sumRsgaku;
    }
    @Transient
    public  Map<CurrencyType, BizCurrency> getNyuukinSumRsgakuByNyksyoriymd(BizDate pNyksyoriymd) {
                List<HT_Nyuukin> nyuukinLst = new ArrayList<HT_Nyuukin>(Collections2.filter(getNyuukins(),
            new FilterNyuukinSumRsgakuByNyksyoriymd(pNyksyoriymd)));

                HashMap<CurrencyType, BizCurrency> sumRsgaku = new HashMap<>();

                BizCurrency rsgakuTmp = null;

                CurrencyType rsgakuType = null;

                for (HT_Nyuukin nyuukin : nyuukinLst) {

                        rsgakuTmp = nyuukin.getRsgaku();

                        if (rsgakuTmp != null) {

                                rsgakuType = rsgakuTmp.getType();

                                                if (!sumRsgaku.containsKey(rsgakuType)) {

                                        sumRsgaku.put(rsgakuType, rsgakuTmp);
                }
                                else {

                                        sumRsgaku.put(rsgakuType, sumRsgaku.get(rsgakuType).add(rsgakuTmp));
                }
            }
        }

        return sumRsgaku;
    }

    @Transient
    public Map<CurrencyType, BizCurrency> getNyuukinSumRsgakuByRyosyuymd(BizDate pRyosyuymd) {

                List<HT_Nyuukin> nyuukinLst = new ArrayList<HT_Nyuukin>(Collections2.filter(getNyuukins(),
            new FilterNyuukinSumRsgakuByRyosyuymd(pRyosyuymd)));

                HashMap<CurrencyType, BizCurrency> sumRsgaku = new HashMap<>();

                BizCurrency rsgakuTmp = null;

                CurrencyType rsgakuType = null;

                for (HT_Nyuukin nyuukin : nyuukinLst) {

                        rsgakuTmp = nyuukin.getRsgaku();

                        if (rsgakuTmp != null) {

                                rsgakuType = rsgakuTmp.getType();

                                                if (!sumRsgaku.containsKey(rsgakuType)) {

                                        sumRsgaku.put(rsgakuType, rsgakuTmp);
                }
                                else {

                                        sumRsgaku.put(rsgakuType, sumRsgaku.get(rsgakuType).add(rsgakuTmp));
                }

            }

        }

        return sumRsgaku;
    }

    @Transient
    public  Map<CurrencyType, BizCurrency> getNyuukinSumRsgakuByRstuukasyuNyksyoriymd(C_Tuukasyu pRstuukasyu,BizDate pNyksyoriymd) {
                List<HT_Nyuukin> nyuukinLst = new ArrayList<HT_Nyuukin>(Collections2.filter(getNyuukins(),
            new FilterNyuukinSumRsgakuByRstuukasyuNyksyoriymd(pRstuukasyu, pNyksyoriymd)));

                HashMap<CurrencyType, BizCurrency> sumRsgaku = new HashMap<>();

                BizCurrency rsgakuTmp = null;

                CurrencyType rsgakuType = null;

                for (HT_Nyuukin nyuukin : nyuukinLst) {

                        rsgakuTmp = nyuukin.getRsgaku();

                        if (rsgakuTmp != null) {

                                rsgakuType = rsgakuTmp.getType();

                                                if (!sumRsgaku.containsKey(rsgakuType)) {

                                        sumRsgaku.put(rsgakuType, rsgakuTmp);
                }
                                else {

                                        sumRsgaku.put(rsgakuType, sumRsgaku.get(rsgakuType).add(rsgakuTmp));
                }
            }
        }

        return sumRsgaku;
    }
    @Transient
    public Map<CurrencyType,BizCurrency> getNyuukinSumRyosyugkByNyknsyubetukbn() {
                List<HT_Nyuukin> nyuukinLst = getNyuukins();

                Map<CurrencyType, BizCurrency> sumRsgaku = new HashMap<>();

                BizCurrency rsgakuTmp = null;

                CurrencyType type = null;

                for (HT_Nyuukin nyuukin : nyuukinLst) {

                        if (C_NyknsyubetuKbn.CREDIT.eq(nyuukin.getNyknsyubetu())) {

                                continue;
            }

                        rsgakuTmp = nyuukin.getRsgaku();

                        if (rsgakuTmp != null) {

                                type = rsgakuTmp.getType();

                                                if (!sumRsgaku.containsKey(type)) {

                                        sumRsgaku.put(type, rsgakuTmp);
                }
                                else {

                                        sumRsgaku.put(type, sumRsgaku.get(type).add(rsgakuTmp));
                }
            }
        }

                return sumRsgaku;

    }
    @Transient
    public  BizDate getNyuukinMinRyosyuymdByZenhnknkbn(C_ZenhnknKbn pZenhnknkbn) {
                List<HT_Nyuukin> nyuukinLst = new ArrayList<HT_Nyuukin>(Collections2.filter(getNyuukins(),
            new FilterNyuukinByZenhnknkbn(pZenhnknkbn)));

        BizDate minRyosyuymd = null;
        BizDate ryosyuymd = null;
        for (HT_Nyuukin nyuukin : nyuukinLst) {

            ryosyuymd = nyuukin.getRyosyuymd();
            if (ryosyuymd == null) {

                continue;
            }

            if (minRyosyuymd == null) {

                minRyosyuymd = ryosyuymd;

                continue;
            }

            if (minRyosyuymd.compareTo(ryosyuymd) > 0) {

                minRyosyuymd = ryosyuymd;

                continue;
            }
        }

        return minRyosyuymd;
    }
    @Transient
    public  HT_Nyuukin getNyuukinByRenno(Integer pRenno) {
        return Iterables.getFirst(Iterables.filter(getNyuukins(), new FilterNyuukinByRenno(pRenno)), null);
    }
    @Transient
    public  List<HT_Nyuukin> getNyuukinsByZenhnknrennos(Integer... pZenhnknrenno) {
        return new ArrayList<HT_Nyuukin>(Collections2.filter(getNyuukins(),
            new FilterNyuukinByZenhnknrennos(pZenhnknrenno)));
    }

    @Transient
    public  HT_Henkin getHenkinByRenno(Integer  pRenno) {
        return Iterables.getFirst(Iterables.filter(getHenkins(),
            new FilterHenkinByRenno(pRenno)), null);
    }
    @Transient
    public  List<HT_Henkin> getHenkinsByHnknsyoriymd(BizDate pHnknsyoriymd) {
        return new ArrayList<HT_Henkin>(Collections2.filter(getHenkins(),new FilterHenkinByHnknsyoriymd(pHnknsyoriymd)));
    }
    @Transient
    public  List<HT_Henkin> getHenkinsByHnkninputrenno(String pHnkninputrenno) {
        return new ArrayList<HT_Henkin>(Collections2.filter(getHenkins(),
            new FilterHenkinByHnkninputrenno(pHnkninputrenno)));
    }
    @Transient
    public  List<HT_Henkin> getHenkinsByHnknsyoriymdHnknhoukbns(BizDate pHnknsyoriymd,C_HnknhouKbn... pHnknhoukbn) {
        return new ArrayList<HT_Henkin>(Collections2.filter(getHenkins(),
            new FilterHenkinByHnknsyoriymdHnknhoukbns(pHnknsyoriymd, pHnknhoukbn)));
    }
    @Transient
    public  Map<CurrencyType, BizCurrency> getHenkinSumHnkngk() {
        List<HT_Henkin> henkinLst = getHenkins();

                Map<CurrencyType, BizCurrency> sumHnkngk = new HashMap<>();

                BizCurrency hnkngkTmp = null;

                CurrencyType type = null;

        for (HT_Henkin henkin : henkinLst) {

                        hnkngkTmp = henkin.getHnkngk();

            if (hnkngkTmp != null) {

                                type = hnkngkTmp.getType();

                if (!sumHnkngk.containsKey(type)) {

                                        sumHnkngk.put(type, hnkngkTmp);
                } else {

                                        sumHnkngk.put(type, sumHnkngk.get(type).add(hnkngkTmp));
                }
            }
        }
                return sumHnkngk;
    }
    @Transient
    public  List<HT_Henkin> getHenkinsByHnkntuukasyuHnknsyoriymd(C_Tuukasyu pHnkntuukasyu,BizDate pHnknsyoriymd) {
        return new ArrayList<HT_Henkin>(Collections2.filter(getHenkins(),
            new FilterHenkinByHnkntuukasyuHnknsyoriymd(pHnkntuukasyu, pHnknsyoriymd)));
    }
    @Transient
    public  List<HT_Henkin> getHenkinsByHnknsyoriymdNull() {
        return new ArrayList<HT_Henkin>(Collections2.filter(getHenkins(),
            new FilterHenkinByHnknsyoriymdNull()));
    }
    @Transient
    public  List<HT_Henkin> getHenkinsByHnknsyoriymdNotNull() {
        return new ArrayList<HT_Henkin>(Collections2.filter(getHenkins(),
            new FilterHenkinByHnknsyoriymdNotNull()));
    }
    @Transient
    public  Map<CurrencyType, BizCurrency> getHenkinSumHnkngkByHnkntuukasyu(C_Tuukasyu pHnkntuukasyu) {
        
        List<HT_Henkin> henkinLst = new ArrayList<HT_Henkin>(Collections2.filter(getHenkins(),
            new FilterHenkinByHnkntuukasyu(pHnkntuukasyu)));

                Map<CurrencyType, BizCurrency> sumHnkngk = new HashMap<>();

                BizCurrency hnkngkTmp = null;

                CurrencyType type = null;

        for (HT_Henkin henkin : henkinLst) {

                        hnkngkTmp = henkin.getHnkngk();

            if (hnkngkTmp != null) {

                                type = hnkngkTmp.getType();

                if (!sumHnkngk.containsKey(type)) {

                                        sumHnkngk.put(type, hnkngkTmp);
                } else {

                                        sumHnkngk.put(type, sumHnkngk.get(type).add(hnkngkTmp));
                }
            }
        }
                return sumHnkngk;
    }
    @Transient
    public  Map<CurrencyType, BizCurrency> getHenkinSumHnkngkByHnknsyoriymd() {
        
        List<HT_Henkin> henkinLst = new ArrayList<HT_Henkin>(Collections2.filter(getHenkins(),
            new FilterHenkinByHnknsyoriymdNeNull()));

                Map<CurrencyType, BizCurrency> sumHnkngk = new HashMap<>();

                BizCurrency hnkngkTmp = null;

                CurrencyType type = null;

        for (HT_Henkin henkin : henkinLst) {

                        hnkngkTmp = henkin.getHnkngk();

            if (hnkngkTmp != null) {

                                type = hnkngkTmp.getType();

                if (!sumHnkngk.containsKey(type)) {

                                        sumHnkngk.put(type, hnkngkTmp);
                } else {

                                        sumHnkngk.put(type, sumHnkngk.get(type).add(hnkngkTmp));
                }
            }
        }
                return sumHnkngk;
    }
    @Transient
    public  Map<CurrencyType, BizCurrency> getHenkinSumHnkngkByHnknsyoriymdLe(BizDate pHnknsyoriymd) {
                List<HT_Henkin> henkinLst = new ArrayList<HT_Henkin>(Collections2.filter(getHenkins(),
            new FilterHenkinSumHnkngkByHnknsyoriymdLe(pHnknsyoriymd)));

                Map<CurrencyType, BizCurrency> sumHnkngk = new HashMap<>();

                BizCurrency hnkngkTmp = null;

                CurrencyType type = null;

        for (HT_Henkin henkin : henkinLst) {

                        hnkngkTmp = henkin.getHnkngk();

            if (hnkngkTmp != null) {

                                type = hnkngkTmp.getType();

                if (!sumHnkngk.containsKey(type)) {

                                        sumHnkngk.put(type, hnkngkTmp);
                } else {

                                        sumHnkngk.put(type, sumHnkngk.get(type).add(hnkngkTmp));
                }
            }
        }
                return sumHnkngk;
    }
    @Transient
    public  Map<CurrencyType, BizCurrency> getHenkinSumHnkngkByHnkntuukasyuHnknsyoriymd(C_Tuukasyu pHnkntuukasyu) {
        
        List<HT_Henkin> henkinLst = new ArrayList<HT_Henkin>(Collections2.filter(getHenkins(),
            new FilterHenkinByHnkntuukasyuHnknsyoriymdNeNull(pHnkntuukasyu)));

                Map<CurrencyType, BizCurrency> sumHnkngk = new HashMap<>();

                BizCurrency hnkngkTmp = null;

                CurrencyType type = null;

        for (HT_Henkin henkin : henkinLst) {

                        hnkngkTmp = henkin.getHnkngk();

            if (hnkngkTmp != null) {

                                type = hnkngkTmp.getType();

                if (!sumHnkngk.containsKey(type)) {

                                        sumHnkngk.put(type, hnkngkTmp);
                } else {

                                        sumHnkngk.put(type, sumHnkngk.get(type).add(hnkngkTmp));
                }
            }
        }
                return sumHnkngk;
    }
    @Transient
    public  Map<CurrencyType, BizCurrency> getHenkinSumHnkngkByHnkntuukasyuHnknsyoriymdLe(C_Tuukasyu pHnkntuukasyu,BizDate pHnknsyoriymd) {
                List<HT_Henkin> henkinLst = new ArrayList<HT_Henkin>(Collections2.filter(getHenkins(),
            new FilterHenkinSumHnkngkByHnkntuukasyuHnknsyoriymdLe(pHnkntuukasyu, pHnknsyoriymd)));

                Map<CurrencyType, BizCurrency> sumHnkngk = new HashMap<>();

                BizCurrency hnkngkTmp = null;

                CurrencyType type = null;

        for (HT_Henkin henkin : henkinLst) {

                        hnkngkTmp = henkin.getHnkngk();

            if (hnkngkTmp != null) {

                                type = hnkngkTmp.getType();

                if (!sumHnkngk.containsKey(type)) {

                                        sumHnkngk.put(type, hnkngkTmp);
                } else {

                                        sumHnkngk.put(type, sumHnkngk.get(type).add(hnkngkTmp));
                }
            }
        }
                return sumHnkngk;
    }
    @Transient
    public  Map<CurrencyType, BizCurrency> getHenkinSumHnkngkByPkakinsyoriymd(BizDate pPkakinsyoriymd) {
                List<HT_Henkin> henkinLst = new ArrayList<HT_Henkin>(Collections2.filter(getHenkins(),
            new FilterHenkinSumHnkngkByPkakinsyoriymd(pPkakinsyoriymd)));

                Map<CurrencyType, BizCurrency> sumHnkngk = new HashMap<>();

                BizCurrency hnkngkTmp = null;

                CurrencyType type = null;

        for (HT_Henkin henkin : henkinLst) {

                        hnkngkTmp = henkin.getHnkngk();

            if (hnkngkTmp != null) {

                                type = hnkngkTmp.getType();

                if (!sumHnkngk.containsKey(type)) {

                                        sumHnkngk.put(type, hnkngkTmp);
                } else {

                                        sumHnkngk.put(type, sumHnkngk.get(type).add(hnkngkTmp));
                }
            }
        }
                return sumHnkngk;
    }
    @Transient
    public  Map<CurrencyType, BizCurrency> getHenkinSumHnkngkByHnkntuukasyuPkakinsyoriymd(C_Tuukasyu pHnkntuukasyu,BizDate pPkakinsyoriymd) {
                List<HT_Henkin> henkinLst = new ArrayList<HT_Henkin>(Collections2.filter(getHenkins(),
            new FilterHenkinSumHnkngkByHnkntuukasyuPkakinsyoriymd(pHnkntuukasyu, pPkakinsyoriymd)));

                Map<CurrencyType, BizCurrency> sumHnkngk = new HashMap<>();

                BizCurrency hnkngkTmp = null;

                CurrencyType type = null;

        for (HT_Henkin henkin : henkinLst) {

                        hnkngkTmp = henkin.getHnkngk();

            if (hnkngkTmp != null) {

                                type = hnkngkTmp.getType();

                if (!sumHnkngk.containsKey(type)) {

                                        sumHnkngk.put(type, hnkngkTmp);
                } else {

                                        sumHnkngk.put(type, sumHnkngk.get(type).add(hnkngkTmp));
                }
            }
        }
                return sumHnkngk;
    }
    @Transient
    public  List<BizCurrency> getHenkinSumHnkngkByhnknsyoriymdNull() {

                List<HT_Henkin> hT_Henkins = new ArrayList<HT_Henkin>(Collections2.filter(getHenkins(),
            new FilterHenkinSumHnkngkByhnknsyoriymdNull()));

                Map<CurrencyType, BizCurrency> mapSumHnkngk = new HashMap<CurrencyType, BizCurrency>();

        HT_Henkin hT_Henkin = null;
        BizCurrency hnkngk = null;
        CurrencyType type = null;
        for (int i = 0; i < hT_Henkins.size(); i++) {

            hT_Henkin = hT_Henkins.get(i);
            hnkngk = hT_Henkin.getHnkngk();
            if (hnkngk != null) {

                type = hnkngk.getType();
                if (mapSumHnkngk.containsKey(type)) {

                    mapSumHnkngk.put(type, mapSumHnkngk.get(type).add(hnkngk));
                } else {

                    mapSumHnkngk.put(type, hnkngk);
                }
            }
        }

                return new ArrayList<BizCurrency>(mapSumHnkngk.values());
    }
    @Transient
    public List<HT_Henkin> getHenkinsByHnknsyoriymdHnkntuukasyuZenhenrennoNe(BizDate pHnknsyoriymd,
        C_Tuukasyu pHnkntuukasyu, Integer pZenhnknrenno) {
        return new ArrayList<HT_Henkin>(Collections2.filter(getHenkins(),
            new FilterHenkinByHnknsyoriymdHnkntuukasyuZenhenrennoNe (pHnknsyoriymd, pHnkntuukasyu, pZenhnknrenno)));
    }
    @Transient
    public  List<HT_Henkin> getHenkinsByZenhnknrennos(Integer... pZenhnknrenno) {
        return new ArrayList<HT_Henkin>(Collections2.filter(getHenkins(),
            new FilterHenkinByZenhnknrennos(pZenhnknrenno)));
    }
    @Transient
    public  List<HT_NrkDif> getNrkDifsByVrfkinouid(String pVrfkinouid) {
        return new ArrayList<HT_NrkDif>(Collections2.filter(getNrkDifs(), new FilterNrkDifByVrfkinouid(pVrfkinouid)));
    }
    @Transient
    public  List<HT_UketorininVrf> getUketorininVrfsByUktsyukbn(C_UktsyuKbn pUktsyukbn) {
        return new ArrayList<HT_UketorininVrf>(Collections2.filter(getUketorininVrfs(), new FilterUketorininVrfByUktsyukbn(pUktsyukbn)));
    }
    @Transient
    public  HT_MosDairitenVrf getMosDairitenVrfByRenno(Integer pRenno) {

        return Iterables.getFirst(Iterables.filter(getMosDairitenVrfs(),
            new FilterMosDairitenVrfByRenno(pRenno)), null);
    }

    @Transient
    public  List<HT_MosSyouhnVrf> getMosSyouhnVrfsBySyutkkbn(C_SyutkKbn pSyutkkbn) {
        return new ArrayList<HT_MosSyouhnVrf>(Collections2.filter(getMosSyouhnVrfs(), new FilterMosSyouhnVrfBySyutkkbn(pSyutkkbn)));
    }
    @Transient
    public  HT_UketoriKouzaJyouhouVrf getUketoriKouzaJyouhouVrfByUktkzsyubetukbn(C_UketorikouzasyubetuKbn pUktkzsyubetukbn) {

        return Iterables.getFirst(Iterables.filter(getUketoriKouzaJyouhouVrfs(),
            new FilterUketoriKouzaJyouhouVrfByUktkzsyubetukbn(pUktkzsyubetukbn)), null);
    }
    @Transient
    public  List<HT_SentakuJyouhou> getSentakuJyouhousBySntkinfotaisyousyakbnEdano(C_SntkInfoTaisyousyaKbn pSntkinfotaisyousyakbn,Integer pEdano) {
        return new ArrayList<HT_SentakuJyouhou>(Collections2.filter(getSentakuJyouhous(),
            new FilterSentakuJyouhouBySntkinfotaisyousyakbnEdano(pSntkinfotaisyousyakbn, pEdano)));
    }
}

