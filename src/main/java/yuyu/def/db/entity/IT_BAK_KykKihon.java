package yuyu.def.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_KykKihon;

import com.google.common.collect.Lists;


/**
 * 契約基本バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KykKihon} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KykKihon<br />
 * @see     PKIT_BAK_KykKihon<br />
 * @see     QIT_BAK_KykKihon<br />
 * @see     GenQIT_BAK_KykKihon<br />
 */
@Entity
public class IT_BAK_KykKihon extends GenIT_BAK_KykKihon {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KykKihon() {
    }

    public IT_BAK_KykKihon(String pKbnkey,String pSyono,String pTrkssikibetukey) {
        super(pKbnkey,pSyono,pTrkssikibetukey);
    }

    public IT_BAK_KykKihon(String pSyono,String pTrkssikibetukey) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey);
    }


    private List<IT_BAK_KykSyouhn> iT_BAKKykSyouhns = Lists.newLinkedList();
    public IT_BAK_KykSyouhn createBAKKykSyouhn() {
        IT_BAK_KykSyouhn bAKKykSyouhn =  new IT_BAK_KykSyouhn();
        bAKKykSyouhn.setBAKKykKihon(this);
        bAKKykSyouhn.setKbnkey(this.getKbnkey());
        bAKKykSyouhn.setSyono(this.getSyono());
        bAKKykSyouhn.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKKykSyouhns().add(bAKKykSyouhn);
        return bAKKykSyouhn;
    }
    public void setBAKKykSyouhns(List<IT_BAK_KykSyouhn> pIT_BAK_KykSyouhns) {
        this.iT_BAKKykSyouhns = pIT_BAK_KykSyouhns;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KykSyouhn.SYONO+" ASC ,"+IT_BAK_KykSyouhn.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_KykSyouhn.SYUTKKBN+" ASC ,"+IT_BAK_KykSyouhn.SYOUHNCD+" ASC ,"+IT_BAK_KykSyouhn.SYOUHNSDNO+" ASC ,"+IT_BAK_KykSyouhn.KYKSYOUHNRENNO+" ASC ")
    public  List<IT_BAK_KykSyouhn> getBAKKykSyouhns() {
        return iT_BAKKykSyouhns;
    }

    private List<IT_BAK_KykSya> iT_BAKKykSyas = Lists.newLinkedList();
    public IT_BAK_KykSya createBAKKykSya() {
        IT_BAK_KykSya bAKKykSya =  new IT_BAK_KykSya();
        bAKKykSya.setBAKKykKihon(this);
        bAKKykSya.setKbnkey(this.getKbnkey());
        bAKKykSya.setSyono(this.getSyono());
        bAKKykSya.setTrkssikibetukey(this.getTrkssikibetukey());
        setBAKKykSya(bAKKykSya);
        return bAKKykSya;
    }
    @Transient
    public  IT_BAK_KykSya getBAKKykSya() {
        requiredEntities(getBAKKykSyas(),IT_BAK_KykSya.class);
        if(getBAKKykSyas().size() == 0) {
            return null;
        }
        return getBAKKykSyas().get(0);
    }
    @Transient
    public void setBAKKykSya(IT_BAK_KykSya pIT_BAK_KykSya) {
        if(this.getBAKKykSyas().size() >0){
            this.getBAKKykSyas().set(0, pIT_BAK_KykSya) ;
        }else{
            this.getBAKKykSyas().add(pIT_BAK_KykSya) ;
        }
    }
    public void setBAKKykSyas(List<IT_BAK_KykSya> pIT_BAK_KykSyas) {
        this.iT_BAKKykSyas = pIT_BAK_KykSyas;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KykSya.SYONO+" ASC ,"+IT_BAK_KykSya.TRKSSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_KykSya> getBAKKykSyas() {
        return iT_BAKKykSyas;
    }

    private List<IT_BAK_HhknSya> iT_BAKHhknSyas = Lists.newLinkedList();
    public IT_BAK_HhknSya createBAKHhknSya() {
        IT_BAK_HhknSya bAKHhknSya =  new IT_BAK_HhknSya();
        bAKHhknSya.setBAKKykKihon(this);
        bAKHhknSya.setKbnkey(this.getKbnkey());
        bAKHhknSya.setSyono(this.getSyono());
        bAKHhknSya.setTrkssikibetukey(this.getTrkssikibetukey());
        setBAKHhknSya(bAKHhknSya);
        return bAKHhknSya;
    }
    @Transient
    public  IT_BAK_HhknSya getBAKHhknSya() {
        requiredEntities(getBAKHhknSyas(),IT_BAK_HhknSya.class);
        if(getBAKHhknSyas().size() == 0) {
            return null;
        }
        return getBAKHhknSyas().get(0);
    }
    @Transient
    public void setBAKHhknSya(IT_BAK_HhknSya pIT_BAK_HhknSya) {
        if(this.getBAKHhknSyas().size() >0){
            this.getBAKHhknSyas().set(0, pIT_BAK_HhknSya) ;
        }else{
            this.getBAKHhknSyas().add(pIT_BAK_HhknSya) ;
        }
    }
    public void setBAKHhknSyas(List<IT_BAK_HhknSya> pIT_BAK_HhknSyas) {
        this.iT_BAKHhknSyas = pIT_BAK_HhknSyas;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_HhknSya.SYONO+" ASC ,"+IT_BAK_HhknSya.TRKSSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_HhknSya> getBAKHhknSyas() {
        return iT_BAKHhknSyas;
    }

    private List<IT_BAK_KykSonotaTkyk> iT_BAKKykSonotaTkyks = Lists.newLinkedList();
    public IT_BAK_KykSonotaTkyk createBAKKykSonotaTkyk() {
        IT_BAK_KykSonotaTkyk bAKKykSonotaTkyk =  new IT_BAK_KykSonotaTkyk();
        bAKKykSonotaTkyk.setBAKKykKihon(this);
        bAKKykSonotaTkyk.setKbnkey(this.getKbnkey());
        bAKKykSonotaTkyk.setSyono(this.getSyono());
        bAKKykSonotaTkyk.setTrkssikibetukey(this.getTrkssikibetukey());
        setBAKKykSonotaTkyk(bAKKykSonotaTkyk);
        return bAKKykSonotaTkyk;
    }
    @Transient
    public  IT_BAK_KykSonotaTkyk getBAKKykSonotaTkyk() {
        requiredEntities(getBAKKykSonotaTkyks(),IT_BAK_KykSonotaTkyk.class);
        if(getBAKKykSonotaTkyks().size() == 0) {
            return null;
        }
        return getBAKKykSonotaTkyks().get(0);
    }
    @Transient
    public void setBAKKykSonotaTkyk(IT_BAK_KykSonotaTkyk pIT_BAK_KykSonotaTkyk) {
        if(this.getBAKKykSonotaTkyks().size() >0){
            this.getBAKKykSonotaTkyks().set(0, pIT_BAK_KykSonotaTkyk) ;
        }else{
            this.getBAKKykSonotaTkyks().add(pIT_BAK_KykSonotaTkyk) ;
        }
    }
    public void setBAKKykSonotaTkyks(List<IT_BAK_KykSonotaTkyk> pIT_BAK_KykSonotaTkyks) {
        this.iT_BAKKykSonotaTkyks = pIT_BAK_KykSonotaTkyks;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KykSonotaTkyk.SYONO+" ASC ,"+IT_BAK_KykSonotaTkyk.TRKSSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_KykSonotaTkyk> getBAKKykSonotaTkyks() {
        return iT_BAKKykSonotaTkyks;
    }

    private List<IT_BAK_SyouhnTokujou> iT_BAKSyouhnTokujous = Lists.newLinkedList();
    public IT_BAK_SyouhnTokujou createBAKSyouhnTokujou() {
        IT_BAK_SyouhnTokujou bAKSyouhnTokujou =  new IT_BAK_SyouhnTokujou();
        bAKSyouhnTokujou.setBAKKykKihon(this);
        bAKSyouhnTokujou.setKbnkey(this.getKbnkey());
        bAKSyouhnTokujou.setSyono(this.getSyono());
        bAKSyouhnTokujou.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKSyouhnTokujous().add(bAKSyouhnTokujou);
        return bAKSyouhnTokujou;
    }
    public void setBAKSyouhnTokujous(List<IT_BAK_SyouhnTokujou> pIT_BAK_SyouhnTokujous) {
        this.iT_BAKSyouhnTokujous = pIT_BAK_SyouhnTokujous;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_SyouhnTokujou.SYONO+" ASC ,"+IT_BAK_SyouhnTokujou.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_SyouhnTokujou.SYUTKKBN+" ASC ,"+IT_BAK_SyouhnTokujou.SYOUHNCD+" ASC ,"+IT_BAK_SyouhnTokujou.SYOUHNSDNO+" ASC ,"+IT_BAK_SyouhnTokujou.KYKSYOUHNRENNO+" ASC ")
    public  List<IT_BAK_SyouhnTokujou> getBAKSyouhnTokujous() {
        return iT_BAKSyouhnTokujous;
    }

    private List<IT_BAK_KykUkt> iT_BAKKykUkts = Lists.newLinkedList();
    public IT_BAK_KykUkt createBAKKykUkt() {
        IT_BAK_KykUkt bAKKykUkt =  new IT_BAK_KykUkt();
        bAKKykUkt.setBAKKykKihon(this);
        bAKKykUkt.setKbnkey(this.getKbnkey());
        bAKKykUkt.setSyono(this.getSyono());
        bAKKykUkt.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKKykUkts().add(bAKKykUkt);
        return bAKKykUkt;
    }
    public void setBAKKykUkts(List<IT_BAK_KykUkt> pIT_BAK_KykUkts) {
        this.iT_BAKKykUkts = pIT_BAK_KykUkts;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KykUkt.SYONO+" ASC ,"+IT_BAK_KykUkt.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_KykUkt.UKTSYUKBN+" ASC ,"+IT_BAK_KykUkt.UKTSYURENNO+" ASC ")
    public  List<IT_BAK_KykUkt> getBAKKykUkts() {
        return iT_BAKKykUkts;
    }

    private List<IT_BAK_KhTtdkTyuui> iT_BAKKhTtdkTyuuis = Lists.newLinkedList();
    public IT_BAK_KhTtdkTyuui createBAKKhTtdkTyuui() {
        IT_BAK_KhTtdkTyuui bAKKhTtdkTyuui =  new IT_BAK_KhTtdkTyuui();
        bAKKhTtdkTyuui.setBAKKykKihon(this);
        bAKKhTtdkTyuui.setKbnkey(this.getKbnkey());
        bAKKhTtdkTyuui.setSyono(this.getSyono());
        bAKKhTtdkTyuui.setTrkssikibetukey(this.getTrkssikibetukey());
        setBAKKhTtdkTyuui(bAKKhTtdkTyuui);
        return bAKKhTtdkTyuui;
    }
    @Transient
    public  IT_BAK_KhTtdkTyuui getBAKKhTtdkTyuui() {
        if(getBAKKhTtdkTyuuis().size() == 0) {
            return null;
        }
        return getBAKKhTtdkTyuuis().get(0);
    }
    @Transient
    public void setBAKKhTtdkTyuui(IT_BAK_KhTtdkTyuui pIT_BAK_KhTtdkTyuui) {
        if(this.getBAKKhTtdkTyuuis().size() >0){
            this.getBAKKhTtdkTyuuis().set(0, pIT_BAK_KhTtdkTyuui) ;
        }else{
            this.getBAKKhTtdkTyuuis().add(pIT_BAK_KhTtdkTyuui) ;
        }
    }
    public void setBAKKhTtdkTyuuis(List<IT_BAK_KhTtdkTyuui> pIT_BAK_KhTtdkTyuuis) {
        this.iT_BAKKhTtdkTyuuis = pIT_BAK_KhTtdkTyuuis;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KhTtdkTyuui.SYONO+" ASC ,"+IT_BAK_KhTtdkTyuui.TRKSSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_KhTtdkTyuui> getBAKKhTtdkTyuuis() {
        return iT_BAKKhTtdkTyuuis;
    }

    private List<IT_BAK_HengakuUnit> iT_BAKHengakuUnits = Lists.newLinkedList();
    public IT_BAK_HengakuUnit createBAKHengakuUnit() {
        IT_BAK_HengakuUnit bAKHengakuUnit =  new IT_BAK_HengakuUnit();
        bAKHengakuUnit.setBAKKykKihon(this);
        bAKHengakuUnit.setKbnkey(this.getKbnkey());
        bAKHengakuUnit.setSyono(this.getSyono());
        bAKHengakuUnit.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKHengakuUnits().add(bAKHengakuUnit);
        return bAKHengakuUnit;
    }
    public void setBAKHengakuUnits(List<IT_BAK_HengakuUnit> pIT_BAK_HengakuUnits) {
        this.iT_BAKHengakuUnits = pIT_BAK_HengakuUnits;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_HengakuUnit.SYONO+" ASC ,"+IT_BAK_HengakuUnit.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_HengakuUnit.UNITFUNDKBN+" ASC ")
    public  List<IT_BAK_HengakuUnit> getBAKHengakuUnits() {
        return iT_BAKHengakuUnits;
    }

    private List<IT_BAK_KhLincSousinInfo> iT_BAKKhLincSousinInfos = Lists.newLinkedList();
    public IT_BAK_KhLincSousinInfo createBAKKhLincSousinInfo() {
        IT_BAK_KhLincSousinInfo bAKKhLincSousinInfo =  new IT_BAK_KhLincSousinInfo();
        bAKKhLincSousinInfo.setBAKKykKihon(this);
        bAKKhLincSousinInfo.setKbnkey(this.getKbnkey());
        bAKKhLincSousinInfo.setSyono(this.getSyono());
        bAKKhLincSousinInfo.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKKhLincSousinInfos().add(bAKKhLincSousinInfo);
        return bAKKhLincSousinInfo;
    }
    public void setBAKKhLincSousinInfos(List<IT_BAK_KhLincSousinInfo> pIT_BAK_KhLincSousinInfos) {
        this.iT_BAKKhLincSousinInfos = pIT_BAK_KhLincSousinInfos;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KhLincSousinInfo.LINCSOUJYUSINSYSKBN+" ASC ,"+IT_BAK_KhLincSousinInfo.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_KhLincSousinInfo.SYONO+" ASC ,"+IT_BAK_KhLincSousinInfo.RENNO+" ASC ")
    public  List<IT_BAK_KhLincSousinInfo> getBAKKhLincSousinInfos() {
        return iT_BAKKhLincSousinInfos;
    }

    private List<IT_BAK_KoujyoSymKanri> iT_BAKKoujyoSymKanris = Lists.newLinkedList();
    public IT_BAK_KoujyoSymKanri createBAKKoujyoSymKanri() {
        IT_BAK_KoujyoSymKanri bAKKoujyoSymKanri =  new IT_BAK_KoujyoSymKanri();
        bAKKoujyoSymKanri.setBAKKykKihon(this);
        bAKKoujyoSymKanri.setKbnkey(this.getKbnkey());
        bAKKoujyoSymKanri.setSyono(this.getSyono());
        bAKKoujyoSymKanri.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKKoujyoSymKanris().add(bAKKoujyoSymKanri);
        return bAKKoujyoSymKanri;
    }
    public void setBAKKoujyoSymKanris(List<IT_BAK_KoujyoSymKanri> pIT_BAK_KoujyoSymKanris) {
        this.iT_BAKKoujyoSymKanris = pIT_BAK_KoujyoSymKanris;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KoujyoSymKanri.SYONO+" ASC ,"+IT_BAK_KoujyoSymKanri.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_KoujyoSymKanri.NENDO+" ASC ")
    public  List<IT_BAK_KoujyoSymKanri> getBAKKoujyoSymKanris() {
        return iT_BAKKoujyoSymKanris;
    }

    private List<IT_BAK_YykIdouUktk> iT_BAKYykIdouUktks = Lists.newLinkedList();
    public IT_BAK_YykIdouUktk createBAKYykIdouUktk() {
        IT_BAK_YykIdouUktk bAKYykIdouUktk =  new IT_BAK_YykIdouUktk();
        bAKYykIdouUktk.setBAKKykKihon(this);
        bAKYykIdouUktk.setKbnkey(this.getKbnkey());
        bAKYykIdouUktk.setSyono(this.getSyono());
        bAKYykIdouUktk.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKYykIdouUktks().add(bAKYykIdouUktk);
        return bAKYykIdouUktk;
    }
    public void setBAKYykIdouUktks(List<IT_BAK_YykIdouUktk> pIT_BAK_YykIdouUktks) {
        this.iT_BAKYykIdouUktks = pIT_BAK_YykIdouUktks;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_YykIdouUktk.SYONO+" ASC ,"+IT_BAK_YykIdouUktk.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_YykIdouUktk.HENKOUSIKIBETUKEY+" ASC ,"+IT_BAK_YykIdouUktk.KINOUID+" ASC ")
    public  List<IT_BAK_YykIdouUktk> getBAKYykIdouUktks() {
        return iT_BAKYykIdouUktks;
    }

    private List<IT_BAK_YykIdouNaiyoHrhnk> iT_BAKYykIdouNaiyoHrhnks = Lists.newLinkedList();
    public IT_BAK_YykIdouNaiyoHrhnk createBAKYykIdouNaiyoHrhnk() {
        IT_BAK_YykIdouNaiyoHrhnk bAKYykIdouNaiyoHrhnk =  new IT_BAK_YykIdouNaiyoHrhnk();
        bAKYykIdouNaiyoHrhnk.setBAKKykKihon(this);
        bAKYykIdouNaiyoHrhnk.setKbnkey(this.getKbnkey());
        bAKYykIdouNaiyoHrhnk.setSyono(this.getSyono());
        bAKYykIdouNaiyoHrhnk.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKYykIdouNaiyoHrhnks().add(bAKYykIdouNaiyoHrhnk);
        return bAKYykIdouNaiyoHrhnk;
    }
    public void setBAKYykIdouNaiyoHrhnks(List<IT_BAK_YykIdouNaiyoHrhnk> pIT_BAK_YykIdouNaiyoHrhnks) {
        this.iT_BAKYykIdouNaiyoHrhnks = pIT_BAK_YykIdouNaiyoHrhnks;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_YykIdouNaiyoHrhnk.SYONO+" ASC ,"+IT_BAK_YykIdouNaiyoHrhnk.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_YykIdouNaiyoHrhnk.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_YykIdouNaiyoHrhnk> getBAKYykIdouNaiyoHrhnks() {
        return iT_BAKYykIdouNaiyoHrhnks;
    }

    private List<IT_BAK_YykIdouAnsyuCreditCard> iT_BAKYykIdouAnsyuCreditCards = Lists.newLinkedList();
    public IT_BAK_YykIdouAnsyuCreditCard createBAKYykIdouAnsyuCreditCard() {
        IT_BAK_YykIdouAnsyuCreditCard bAKYykIdouAnsyuCreditCard =  new IT_BAK_YykIdouAnsyuCreditCard();
        bAKYykIdouAnsyuCreditCard.setBAKKykKihon(this);
        bAKYykIdouAnsyuCreditCard.setKbnkey(this.getKbnkey());
        bAKYykIdouAnsyuCreditCard.setSyono(this.getSyono());
        bAKYykIdouAnsyuCreditCard.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKYykIdouAnsyuCreditCards().add(bAKYykIdouAnsyuCreditCard);
        return bAKYykIdouAnsyuCreditCard;
    }
    public void setBAKYykIdouAnsyuCreditCards(List<IT_BAK_YykIdouAnsyuCreditCard> pIT_BAK_YykIdouAnsyuCreditCards) {
        this.iT_BAKYykIdouAnsyuCreditCards = pIT_BAK_YykIdouAnsyuCreditCards;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_YykIdouAnsyuCreditCard.SYONO+" ASC ,"+IT_BAK_YykIdouAnsyuCreditCard.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_YykIdouAnsyuCreditCard.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_YykIdouAnsyuCreditCard> getBAKYykIdouAnsyuCreditCards() {
        return iT_BAKYykIdouAnsyuCreditCards;
    }

    private List<IT_BAK_CreditCard> iT_BAKCreditCards = Lists.newLinkedList();
    public IT_BAK_CreditCard createBAKCreditCard() {
        IT_BAK_CreditCard bAKCreditCard =  new IT_BAK_CreditCard();
        bAKCreditCard.setBAKKykKihon(this);
        bAKCreditCard.setKbnkey(this.getKbnkey());
        bAKCreditCard.setSyono(this.getSyono());
        bAKCreditCard.setTrkssikibetukey(this.getTrkssikibetukey());
        setBAKCreditCard(bAKCreditCard);
        return bAKCreditCard;
    }
    @Transient
    public  IT_BAK_CreditCard getBAKCreditCard() {
        if(getBAKCreditCards().size() == 0) {
            return null;
        }
        return getBAKCreditCards().get(0);
    }
    @Transient
    public void setBAKCreditCard(IT_BAK_CreditCard pIT_BAK_CreditCard) {
        if(this.getBAKCreditCards().size() >0){
            this.getBAKCreditCards().set(0, pIT_BAK_CreditCard) ;
        }else{
            this.getBAKCreditCards().add(pIT_BAK_CreditCard) ;
        }
    }
    public void setBAKCreditCards(List<IT_BAK_CreditCard> pIT_BAK_CreditCards) {
        this.iT_BAKCreditCards = pIT_BAK_CreditCards;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_CreditCard.SYONO+" ASC ,"+IT_BAK_CreditCard.TRKSSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_CreditCard> getBAKCreditCards() {
        return iT_BAKCreditCards;
    }

    private List<IT_BAK_Kouza> iT_BAKKouzas = Lists.newLinkedList();
    public IT_BAK_Kouza createBAKKouza() {
        IT_BAK_Kouza bAKKouza =  new IT_BAK_Kouza();
        bAKKouza.setBAKKykKihon(this);
        bAKKouza.setKbnkey(this.getKbnkey());
        bAKKouza.setSyono(this.getSyono());
        bAKKouza.setTrkssikibetukey(this.getTrkssikibetukey());
        setBAKKouza(bAKKouza);
        return bAKKouza;
    }
    @Transient
    public  IT_BAK_Kouza getBAKKouza() {
        if(getBAKKouzas().size() == 0) {
            return null;
        }
        return getBAKKouzas().get(0);
    }
    @Transient
    public void setBAKKouza(IT_BAK_Kouza pIT_BAK_Kouza) {
        if(this.getBAKKouzas().size() >0){
            this.getBAKKouzas().set(0, pIT_BAK_Kouza) ;
        }else{
            this.getBAKKouzas().add(pIT_BAK_Kouza) ;
        }
    }
    public void setBAKKouzas(List<IT_BAK_Kouza> pIT_BAK_Kouzas) {
        this.iT_BAKKouzas = pIT_BAK_Kouzas;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_Kouza.SYONO+" ASC ,"+IT_BAK_Kouza.TRKSSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_Kouza> getBAKKouzas() {
        return iT_BAKKouzas;
    }

    private List<IT_BAK_TeikikinKouza> iT_BAKTeikikinKouzas = Lists.newLinkedList();
    public IT_BAK_TeikikinKouza createBAKTeikikinKouza() {
        IT_BAK_TeikikinKouza bAKTeikikinKouza =  new IT_BAK_TeikikinKouza();
        bAKTeikikinKouza.setBAKKykKihon(this);
        bAKTeikikinKouza.setKbnkey(this.getKbnkey());
        bAKTeikikinKouza.setSyono(this.getSyono());
        bAKTeikikinKouza.setTrkssikibetukey(this.getTrkssikibetukey());
        setBAKTeikikinKouza(bAKTeikikinKouza);
        return bAKTeikikinKouza;
    }
    @Transient
    public  IT_BAK_TeikikinKouza getBAKTeikikinKouza() {
        if(getBAKTeikikinKouzas().size() == 0) {
            return null;
        }
        return getBAKTeikikinKouzas().get(0);
    }
    @Transient
    public void setBAKTeikikinKouza(IT_BAK_TeikikinKouza pIT_BAK_TeikikinKouza) {
        if(this.getBAKTeikikinKouzas().size() >0){
            this.getBAKTeikikinKouzas().set(0, pIT_BAK_TeikikinKouza) ;
        }else{
            this.getBAKTeikikinKouzas().add(pIT_BAK_TeikikinKouza) ;
        }
    }
    public void setBAKTeikikinKouzas(List<IT_BAK_TeikikinKouza> pIT_BAK_TeikikinKouzas) {
        this.iT_BAKTeikikinKouzas = pIT_BAK_TeikikinKouzas;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_TeikikinKouza.SYONO+" ASC ,"+IT_BAK_TeikikinKouza.TRKSSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_TeikikinKouza> getBAKTeikikinKouzas() {
        return iT_BAKTeikikinKouzas;
    }

    private List<IT_BAK_KykDairiten> iT_BAKKykDairitens = Lists.newLinkedList();
    public IT_BAK_KykDairiten createBAKKykDairiten() {
        IT_BAK_KykDairiten bAKKykDairiten =  new IT_BAK_KykDairiten();
        bAKKykDairiten.setBAKKykKihon(this);
        bAKKykDairiten.setKbnkey(this.getKbnkey());
        bAKKykDairiten.setSyono(this.getSyono());
        bAKKykDairiten.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKKykDairitens().add(bAKKykDairiten);
        return bAKKykDairiten;
    }
    public void setBAKKykDairitens(List<IT_BAK_KykDairiten> pIT_BAK_KykDairitens) {
        this.iT_BAKKykDairitens = pIT_BAK_KykDairitens;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KykDairiten.SYONO+" ASC ,"+IT_BAK_KykDairiten.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_KykDairiten.DRTENRENNO+" ASC ")
    public  List<IT_BAK_KykDairiten> getBAKKykDairitens() {
        return iT_BAKKykDairitens;
    }

    private List<IT_BAK_FatcaInfo> iT_BAKFatcaInfos = Lists.newLinkedList();
    public IT_BAK_FatcaInfo createBAKFatcaInfo() {
        IT_BAK_FatcaInfo bAKFatcaInfo =  new IT_BAK_FatcaInfo();
        bAKFatcaInfo.setBAKKykKihon(this);
        bAKFatcaInfo.setKbnkey(this.getKbnkey());
        bAKFatcaInfo.setSyono(this.getSyono());
        bAKFatcaInfo.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKFatcaInfos().add(bAKFatcaInfo);
        return bAKFatcaInfo;
    }
    public void setBAKFatcaInfos(List<IT_BAK_FatcaInfo> pIT_BAK_FatcaInfos) {
        this.iT_BAKFatcaInfos = pIT_BAK_FatcaInfos;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_FatcaInfo.SYONO+" ASC ,"+IT_BAK_FatcaInfo.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_FatcaInfo.RENNO+" ASC ")
    public  List<IT_BAK_FatcaInfo> getBAKFatcaInfos() {
        return iT_BAKFatcaInfos;
    }

    private List<IT_BAK_Kariukekin> iT_BAKKariukekins = Lists.newLinkedList();
    public IT_BAK_Kariukekin createBAKKariukekin() {
        IT_BAK_Kariukekin bAKKariukekin =  new IT_BAK_Kariukekin();
        bAKKariukekin.setBAKKykKihon(this);
        bAKKariukekin.setKbnkey(this.getKbnkey());
        bAKKariukekin.setSyono(this.getSyono());
        bAKKariukekin.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKKariukekins().add(bAKKariukekin);
        return bAKKariukekin;
    }
    public void setBAKKariukekins(List<IT_BAK_Kariukekin> pIT_BAK_Kariukekins) {
        this.iT_BAKKariukekins = pIT_BAK_Kariukekins;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_Kariukekin.SYONO+" ASC ,"+IT_BAK_Kariukekin.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_Kariukekin.KRKNO+" ASC ")
    public  List<IT_BAK_Kariukekin> getBAKKariukekins() {
        return iT_BAKKariukekins;
    }

    private List<IT_BAK_NyknJissekiRireki> iT_BAKNyknJissekiRirekis = Lists.newLinkedList();
    public IT_BAK_NyknJissekiRireki createBAKNyknJissekiRireki() {
        IT_BAK_NyknJissekiRireki bAKNyknJissekiRireki =  new IT_BAK_NyknJissekiRireki();
        bAKNyknJissekiRireki.setBAKKykKihon(this);
        bAKNyknJissekiRireki.setKbnkey(this.getKbnkey());
        bAKNyknJissekiRireki.setSyono(this.getSyono());
        bAKNyknJissekiRireki.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKNyknJissekiRirekis().add(bAKNyknJissekiRireki);
        return bAKNyknJissekiRireki;
    }
    public void setBAKNyknJissekiRirekis(List<IT_BAK_NyknJissekiRireki> pIT_BAK_NyknJissekiRirekis) {
        this.iT_BAKNyknJissekiRirekis = pIT_BAK_NyknJissekiRirekis;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_NyknJissekiRireki.SYONO+" ASC ,"+IT_BAK_NyknJissekiRireki.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_NyknJissekiRireki.JYUTOUSTARTYM+" ASC ,"+IT_BAK_NyknJissekiRireki.RENNO+" ASC ")
    public  List<IT_BAK_NyknJissekiRireki> getBAKNyknJissekiRirekis() {
        return iT_BAKNyknJissekiRirekis;
    }

    private List<IT_BAK_KoujyoSymNaiyou> iT_BAKKoujyoSymNaiyous = Lists.newLinkedList();
    public IT_BAK_KoujyoSymNaiyou createBAKKoujyoSymNaiyou() {
        IT_BAK_KoujyoSymNaiyou bAKKoujyoSymNaiyou =  new IT_BAK_KoujyoSymNaiyou();
        bAKKoujyoSymNaiyou.setBAKKykKihon(this);
        bAKKoujyoSymNaiyou.setKbnkey(this.getKbnkey());
        bAKKoujyoSymNaiyou.setSyono(this.getSyono());
        bAKKoujyoSymNaiyou.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKKoujyoSymNaiyous().add(bAKKoujyoSymNaiyou);
        return bAKKoujyoSymNaiyou;
    }
    public void setBAKKoujyoSymNaiyous(List<IT_BAK_KoujyoSymNaiyou> pIT_BAK_KoujyoSymNaiyous) {
        this.iT_BAKKoujyoSymNaiyous = pIT_BAK_KoujyoSymNaiyous;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KoujyoSymNaiyou.SYONO+" ASC ,"+IT_BAK_KoujyoSymNaiyou.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_KoujyoSymNaiyou.SYOUHNCD+" ASC ,"+IT_BAK_KoujyoSymNaiyou.RENNO3KETA+" ASC ")
    public  List<IT_BAK_KoujyoSymNaiyou> getBAKKoujyoSymNaiyous() {
        return iT_BAKKoujyoSymNaiyous;
    }

    private List<IT_BAK_KihrkmpSeisanRireki> iT_BAKKihrkmpSeisanRirekis = Lists.newLinkedList();
    public IT_BAK_KihrkmpSeisanRireki createBAKKihrkmpSeisanRireki() {
        IT_BAK_KihrkmpSeisanRireki bAKKihrkmpSeisanRireki =  new IT_BAK_KihrkmpSeisanRireki();
        bAKKihrkmpSeisanRireki.setBAKKykKihon(this);
        bAKKihrkmpSeisanRireki.setKbnkey(this.getKbnkey());
        bAKKihrkmpSeisanRireki.setSyono(this.getSyono());
        bAKKihrkmpSeisanRireki.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKKihrkmpSeisanRirekis().add(bAKKihrkmpSeisanRireki);
        return bAKKihrkmpSeisanRireki;
    }
    public void setBAKKihrkmpSeisanRirekis(List<IT_BAK_KihrkmpSeisanRireki> pIT_BAK_KihrkmpSeisanRirekis) {
        this.iT_BAKKihrkmpSeisanRirekis = pIT_BAK_KihrkmpSeisanRirekis;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KihrkmpSeisanRireki.SYONO+" ASC ,"+IT_BAK_KihrkmpSeisanRireki.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_KihrkmpSeisanRireki.RENNO+" ASC ")
    public  List<IT_BAK_KihrkmpSeisanRireki> getBAKKihrkmpSeisanRirekis() {
        return iT_BAKKihrkmpSeisanRirekis;
    }

    private List<IT_BAK_KhTtdkRireki> iT_BAKKhTtdkRirekis = Lists.newLinkedList();
    public IT_BAK_KhTtdkRireki createBAKKhTtdkRireki() {
        IT_BAK_KhTtdkRireki bAKKhTtdkRireki =  new IT_BAK_KhTtdkRireki();
        bAKKhTtdkRireki.setBAKKykKihon(this);
        bAKKhTtdkRireki.setKbnkey(this.getKbnkey());
        bAKKhTtdkRireki.setSyono(this.getSyono());
        bAKKhTtdkRireki.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKKhTtdkRirekis().add(bAKKhTtdkRireki);
        return bAKKhTtdkRireki;
    }
    public void setBAKKhTtdkRirekis(List<IT_BAK_KhTtdkRireki> pIT_BAK_KhTtdkRirekis) {
        this.iT_BAKKhTtdkRirekis = pIT_BAK_KhTtdkRirekis;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KhTtdkRireki.SYONO+" ASC ,"+IT_BAK_KhTtdkRireki.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_KhTtdkRireki.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_KhTtdkRireki> getBAKKhTtdkRirekis() {
        return iT_BAKKhTtdkRirekis;
    }

    private List<IT_BAK_Tesuuryou> iT_BAKTesuuryous = Lists.newLinkedList();
    public IT_BAK_Tesuuryou createBAKTesuuryou() {
        IT_BAK_Tesuuryou bAKTesuuryou =  new IT_BAK_Tesuuryou();
        bAKTesuuryou.setBAKKykKihon(this);
        bAKTesuuryou.setKbnkey(this.getKbnkey());
        bAKTesuuryou.setSyono(this.getSyono());
        bAKTesuuryou.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKTesuuryous().add(bAKTesuuryou);
        return bAKTesuuryou;
    }
    public void setBAKTesuuryous(List<IT_BAK_Tesuuryou> pIT_BAK_Tesuuryous) {
        this.iT_BAKTesuuryous = pIT_BAK_Tesuuryous;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_Tesuuryou.SYONO+" ASC ,"+IT_BAK_Tesuuryou.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_Tesuuryou.TSRYSYORIKBN+" ASC ,"+IT_BAK_Tesuuryou.RENNO+" ASC ")
    public  List<IT_BAK_Tesuuryou> getBAKTesuuryous() {
        return iT_BAKTesuuryous;
    }

    private List<IT_BAK_KoujyoSym> iT_BAKKoujyoSyms = Lists.newLinkedList();
    public IT_BAK_KoujyoSym createBAKKoujyoSym() {
        IT_BAK_KoujyoSym bAKKoujyoSym =  new IT_BAK_KoujyoSym();
        bAKKoujyoSym.setBAKKykKihon(this);
        bAKKoujyoSym.setKbnkey(this.getKbnkey());
        bAKKoujyoSym.setSyono(this.getSyono());
        bAKKoujyoSym.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKKoujyoSyms().add(bAKKoujyoSym);
        return bAKKoujyoSym;
    }
    public void setBAKKoujyoSyms(List<IT_BAK_KoujyoSym> pIT_BAK_KoujyoSyms) {
        this.iT_BAKKoujyoSyms = pIT_BAK_KoujyoSyms;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KoujyoSym.SYONO+" ASC ,"+IT_BAK_KoujyoSym.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_KoujyoSym.NENDO+" ASC ,"+IT_BAK_KoujyoSym.TYOUHYOUYMD+" ASC ,"+IT_BAK_KoujyoSym.RENNO+" ASC ")
    public  List<IT_BAK_KoujyoSym> getBAKKoujyoSyms() {
        return iT_BAKKoujyoSyms;
    }

    private List<IT_BAK_Suiihyou> iT_BAKSuiihyous = Lists.newLinkedList();
    public IT_BAK_Suiihyou createBAKSuiihyou() {
        IT_BAK_Suiihyou bAKSuiihyou =  new IT_BAK_Suiihyou();
        bAKSuiihyou.setBAKKykKihon(this);
        bAKSuiihyou.setKbnkey(this.getKbnkey());
        bAKSuiihyou.setSyono(this.getSyono());
        bAKSuiihyou.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKSuiihyous().add(bAKSuiihyou);
        return bAKSuiihyou;
    }
    public void setBAKSuiihyous(List<IT_BAK_Suiihyou> pIT_BAK_Suiihyous) {
        this.iT_BAKSuiihyous = pIT_BAK_Suiihyous;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_Suiihyou.SYONO+" ASC ,"+IT_BAK_Suiihyou.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_Suiihyou.TYOUHYOUYMD+" ASC ,"+IT_BAK_Suiihyou.KEIKANENSUU+" ASC ")
    public  List<IT_BAK_Suiihyou> getBAKSuiihyous() {
        return iT_BAKSuiihyous;
    }

    private List<IT_BAK_TtdkKan> iT_BAKTtdkKans = Lists.newLinkedList();
    public IT_BAK_TtdkKan createBAKTtdkKan() {
        IT_BAK_TtdkKan bAKTtdkKan =  new IT_BAK_TtdkKan();
        bAKTtdkKan.setBAKKykKihon(this);
        bAKTtdkKan.setKbnkey(this.getKbnkey());
        bAKTtdkKan.setSyono(this.getSyono());
        bAKTtdkKan.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKTtdkKans().add(bAKTtdkKan);
        return bAKTtdkKan;
    }
    public void setBAKTtdkKans(List<IT_BAK_TtdkKan> pIT_BAK_TtdkKans) {
        this.iT_BAKTtdkKans = pIT_BAK_TtdkKans;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_TtdkKan.SYONO+" ASC ,"+IT_BAK_TtdkKan.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_TtdkKan.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_TtdkKan> getBAKTtdkKans() {
        return iT_BAKTtdkKans;
    }

    private List<IT_BAK_HokenSyouken> iT_BAKHokenSyoukens = Lists.newLinkedList();
    public IT_BAK_HokenSyouken createBAKHokenSyouken() {
        IT_BAK_HokenSyouken bAKHokenSyouken =  new IT_BAK_HokenSyouken();
        bAKHokenSyouken.setBAKKykKihon(this);
        bAKHokenSyouken.setKbnkey(this.getKbnkey());
        bAKHokenSyouken.setSyono(this.getSyono());
        bAKHokenSyouken.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKHokenSyoukens().add(bAKHokenSyouken);
        return bAKHokenSyouken;
    }
    public void setBAKHokenSyoukens(List<IT_BAK_HokenSyouken> pIT_BAK_HokenSyoukens) {
        this.iT_BAKHokenSyoukens = pIT_BAK_HokenSyoukens;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_HokenSyouken.SYONO+" ASC ,"+IT_BAK_HokenSyouken.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_HokenSyouken.TYOUHYOUYMD+" ASC ")
    public  List<IT_BAK_HokenSyouken> getBAKHokenSyoukens() {
        return iT_BAKHokenSyoukens;
    }

    private List<IT_BAK_AeoiInfo> iT_BAKAeoiInfos = Lists.newLinkedList();
    public IT_BAK_AeoiInfo createBAKAeoiInfo() {
        IT_BAK_AeoiInfo bAKAeoiInfo =  new IT_BAK_AeoiInfo();
        bAKAeoiInfo.setBAKKykKihon(this);
        bAKAeoiInfo.setKbnkey(this.getKbnkey());
        bAKAeoiInfo.setSyono(this.getSyono());
        bAKAeoiInfo.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKAeoiInfos().add(bAKAeoiInfo);
        return bAKAeoiInfo;
    }
    public void setBAKAeoiInfos(List<IT_BAK_AeoiInfo> pIT_BAK_AeoiInfos) {
        this.iT_BAKAeoiInfos = pIT_BAK_AeoiInfos;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_AeoiInfo.SYONO+" ASC ,"+IT_BAK_AeoiInfo.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_AeoiInfo.RENNO+" ASC ")
    public  List<IT_BAK_AeoiInfo> getBAKAeoiInfos() {
        return iT_BAKAeoiInfos;
    }

    private List<IT_BAK_KhHenreikin> iT_BAKKhHenreikins = Lists.newLinkedList();
    public IT_BAK_KhHenreikin createBAKKhHenreikin() {
        IT_BAK_KhHenreikin bAKKhHenreikin =  new IT_BAK_KhHenreikin();
        bAKKhHenreikin.setBAKKykKihon(this);
        bAKKhHenreikin.setKbnkey(this.getKbnkey());
        bAKKhHenreikin.setSyono(this.getSyono());
        bAKKhHenreikin.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKKhHenreikins().add(bAKKhHenreikin);
        return bAKKhHenreikin;
    }
    public void setBAKKhHenreikins(List<IT_BAK_KhHenreikin> pIT_BAK_KhHenreikins) {
        this.iT_BAKKhHenreikins = pIT_BAK_KhHenreikins;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KhHenreikin.SYONO+" ASC ,"+IT_BAK_KhHenreikin.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_KhHenreikin.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_KhHenreikin> getBAKKhHenreikins() {
        return iT_BAKKhHenreikins;
    }

    private List<IT_BAK_KhSisuurendoTmttkn> iT_BAKKhSisuurendoTmttkns = Lists.newLinkedList();
    public IT_BAK_KhSisuurendoTmttkn createBAKKhSisuurendoTmttkn() {
        IT_BAK_KhSisuurendoTmttkn bAKKhSisuurendoTmttkn =  new IT_BAK_KhSisuurendoTmttkn();
        bAKKhSisuurendoTmttkn.setBAKKykKihon(this);
        bAKKhSisuurendoTmttkn.setKbnkey(this.getKbnkey());
        bAKKhSisuurendoTmttkn.setSyono(this.getSyono());
        bAKKhSisuurendoTmttkn.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKKhSisuurendoTmttkns().add(bAKKhSisuurendoTmttkn);
        return bAKKhSisuurendoTmttkn;
    }
    public void setBAKKhSisuurendoTmttkns(List<IT_BAK_KhSisuurendoTmttkn> pIT_BAK_KhSisuurendoTmttkns) {
        this.iT_BAKKhSisuurendoTmttkns = pIT_BAK_KhSisuurendoTmttkns;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KhSisuurendoTmttkn.SYONO+" ASC ,"+IT_BAK_KhSisuurendoTmttkn.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_KhSisuurendoTmttkn.TMTTKNTAISYOUYM+" ASC ,"+IT_BAK_KhSisuurendoTmttkn.RENNO+" ASC ")
    public  List<IT_BAK_KhSisuurendoTmttkn> getBAKKhSisuurendoTmttkns() {
        return iT_BAKKhSisuurendoTmttkns;
    }

    private List<IT_BAK_Azukarikin> iT_BAKAzukarikins = Lists.newLinkedList();
    public IT_BAK_Azukarikin createBAKAzukarikin() {
        IT_BAK_Azukarikin bAKAzukarikin =  new IT_BAK_Azukarikin();
        bAKAzukarikin.setBAKKykKihon(this);
        bAKAzukarikin.setKbnkey(this.getKbnkey());
        bAKAzukarikin.setSyono(this.getSyono());
        bAKAzukarikin.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKAzukarikins().add(bAKAzukarikin);
        return bAKAzukarikin;
    }
    public void setBAKAzukarikins(List<IT_BAK_Azukarikin> pIT_BAK_Azukarikins) {
        this.iT_BAKAzukarikins = pIT_BAK_Azukarikins;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_Azukarikin.SYONO+" ASC ,"+IT_BAK_Azukarikin.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_Azukarikin.HENKOUSIKIBETUKEY+" ASC ,"+IT_BAK_Azukarikin.TUUKASYU+" ASC ")
    public  List<IT_BAK_Azukarikin> getBAKAzukarikins() {
        return iT_BAKAzukarikins;
    }

    private List<IT_BAK_HokenryouTmttkn> iT_BAKHokenryouTmttkns = Lists.newLinkedList();
    public IT_BAK_HokenryouTmttkn createBAKHokenryouTmttkn() {
        IT_BAK_HokenryouTmttkn bAKHokenryouTmttkn =  new IT_BAK_HokenryouTmttkn();
        bAKHokenryouTmttkn.setBAKKykKihon(this);
        bAKHokenryouTmttkn.setKbnkey(this.getKbnkey());
        bAKHokenryouTmttkn.setSyono(this.getSyono());
        bAKHokenryouTmttkn.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKHokenryouTmttkns().add(bAKHokenryouTmttkn);
        return bAKHokenryouTmttkn;
    }
    public void setBAKHokenryouTmttkns(List<IT_BAK_HokenryouTmttkn> pIT_BAK_HokenryouTmttkns) {
        this.iT_BAKHokenryouTmttkns = pIT_BAK_HokenryouTmttkns;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_HokenryouTmttkn.SYONO+" ASC ,"+IT_BAK_HokenryouTmttkn.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_HokenryouTmttkn.TMTTKNTAISYOUYM+" ASC ,"+IT_BAK_HokenryouTmttkn.RENNO+" ASC ")
    public  List<IT_BAK_HokenryouTmttkn> getBAKHokenryouTmttkns() {
        return iT_BAKHokenryouTmttkns;
    }
    private List<IT_BAK_HrhnTtdkKan> iT_BAKHrhnTtdkKans = Lists.newLinkedList();
    public IT_BAK_HrhnTtdkKan createBAKHrhnTtdkKan() {
        IT_BAK_HrhnTtdkKan bAKHrhnTtdkKan =  new IT_BAK_HrhnTtdkKan();
        bAKHrhnTtdkKan.setBAKKykKihon(this);
        bAKHrhnTtdkKan.setKbnkey(this.getKbnkey());
        bAKHrhnTtdkKan.setSyono(this.getSyono());
        bAKHrhnTtdkKan.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKHrhnTtdkKans().add(bAKHrhnTtdkKan);
        return bAKHrhnTtdkKan;
    }
    public void setBAKHrhnTtdkKans(List<IT_BAK_HrhnTtdkKan> pIT_BAK_HrhnTtdkKans) {
        this.iT_BAKHrhnTtdkKans = pIT_BAK_HrhnTtdkKans;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_HrhnTtdkKan.SYONO+" ASC ,"+IT_BAK_HrhnTtdkKan.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_HrhnTtdkKan.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_HrhnTtdkKan> getBAKHrhnTtdkKans() {
        return iT_BAKHrhnTtdkKans;
    }

    private List<IT_BAK_HurikaeYousi> iT_BAKHurikaeYousis = Lists.newLinkedList();
    public IT_BAK_HurikaeYousi createBAKHurikaeYousi() {
        IT_BAK_HurikaeYousi bAKHurikaeYousi =  new IT_BAK_HurikaeYousi();
        bAKHurikaeYousi.setBAKKykKihon(this);
        bAKHurikaeYousi.setKbnkey(this.getKbnkey());
        bAKHurikaeYousi.setSyono(this.getSyono());
        bAKHurikaeYousi.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKHurikaeYousis().add(bAKHurikaeYousi);
        return bAKHurikaeYousi;
    }
    public void setBAKHurikaeYousis(List<IT_BAK_HurikaeYousi> pIT_BAK_HurikaeYousis) {
        this.iT_BAKHurikaeYousis = pIT_BAK_HurikaeYousis;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_HurikaeYousi.SYONO+" ASC ,"+IT_BAK_HurikaeYousi.HENKOUSIKIBETUKEY+" ASC ,"+IT_BAK_HurikaeYousi.TRKSSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_HurikaeYousi> getBAKHurikaeYousis() {
        return iT_BAKHurikaeYousis;
    }

    private List<IT_BAK_KouzaHnknTuuti> iT_BAKKouzaHnknTuutis = Lists.newLinkedList();
    public IT_BAK_KouzaHnknTuuti createBAKKouzaHnknTuuti() {
        IT_BAK_KouzaHnknTuuti bAKKouzaHnknTuuti =  new IT_BAK_KouzaHnknTuuti();
        bAKKouzaHnknTuuti.setBAKKykKihon(this);
        bAKKouzaHnknTuuti.setKbnkey(this.getKbnkey());
        bAKKouzaHnknTuuti.setSyono(this.getSyono());
        bAKKouzaHnknTuuti.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKKouzaHnknTuutis().add(bAKKouzaHnknTuuti);
        return bAKKouzaHnknTuuti;
    }
    public void setBAKKouzaHnknTuutis(List<IT_BAK_KouzaHnknTuuti> pIT_BAK_KouzaHnknTuutis) {
        this.iT_BAKKouzaHnknTuutis = pIT_BAK_KouzaHnknTuutis;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KouzaHnknTuuti.SYONO+" ASC ,"+IT_BAK_KouzaHnknTuuti.DENRENNO+" ASC ,"+IT_BAK_KouzaHnknTuuti.EDANO+" ASC ,"+IT_BAK_KouzaHnknTuuti.TRKSSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_KouzaHnknTuuti> getBAKKouzaHnknTuutis() {
        return iT_BAKKouzaHnknTuutis;
    }

    private List<IT_BAK_KouzaHrkmTuuti> iT_BAKKouzaHrkmTuutis = Lists.newLinkedList();
    public IT_BAK_KouzaHrkmTuuti createBAKKouzaHrkmTuuti() {
        IT_BAK_KouzaHrkmTuuti bAKKouzaHrkmTuuti =  new IT_BAK_KouzaHrkmTuuti();
        bAKKouzaHrkmTuuti.setBAKKykKihon(this);
        bAKKouzaHrkmTuuti.setKbnkey(this.getKbnkey());
        bAKKouzaHrkmTuuti.setSyono(this.getSyono());
        bAKKouzaHrkmTuuti.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKKouzaHrkmTuutis().add(bAKKouzaHrkmTuuti);
        return bAKKouzaHrkmTuuti;
    }
    public void setBAKKouzaHrkmTuutis(List<IT_BAK_KouzaHrkmTuuti> pIT_BAK_KouzaHrkmTuutis) {
        this.iT_BAKKouzaHrkmTuutis = pIT_BAK_KouzaHrkmTuutis;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KouzaHrkmTuuti.SYONO+" ASC ,"+IT_BAK_KouzaHrkmTuuti.KRKNO+" ASC ,"+IT_BAK_KouzaHrkmTuuti.TRKSSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_KouzaHrkmTuuti> getBAKKouzaHrkmTuutis() {
        return iT_BAKKouzaHrkmTuutis;
    }

    private List<IT_BAK_PMinyuuSyoumetuInfo> iT_BAKPMinyuuSyoumetuInfos = Lists.newLinkedList();
    public IT_BAK_PMinyuuSyoumetuInfo createBAKPMinyuuSyoumetuInfo() {
        IT_BAK_PMinyuuSyoumetuInfo bAKPMinyuuSyoumetuInfo =  new IT_BAK_PMinyuuSyoumetuInfo();
        bAKPMinyuuSyoumetuInfo.setBAKKykKihon(this);
        bAKPMinyuuSyoumetuInfo.setKbnkey(this.getKbnkey());
        bAKPMinyuuSyoumetuInfo.setSyono(this.getSyono());
        bAKPMinyuuSyoumetuInfo.setTrkssikibetukey(this.getTrkssikibetukey());
        setBAKPMinyuuSyoumetuInfo(bAKPMinyuuSyoumetuInfo);
        return bAKPMinyuuSyoumetuInfo;
    }
    @Transient
    public  IT_BAK_PMinyuuSyoumetuInfo getBAKPMinyuuSyoumetuInfo() {
        if(getBAKPMinyuuSyoumetuInfos().size() == 0) {
            return null;
        }
        return getBAKPMinyuuSyoumetuInfos().get(0);
    }
    @Transient
    public void setBAKPMinyuuSyoumetuInfo(IT_BAK_PMinyuuSyoumetuInfo pIT_BAK_PMinyuuSyoumetuInfo) {
        if(this.getBAKPMinyuuSyoumetuInfos().size() >0){
            this.getBAKPMinyuuSyoumetuInfos().set(0, pIT_BAK_PMinyuuSyoumetuInfo) ;
        }else{
            this.getBAKPMinyuuSyoumetuInfos().add(pIT_BAK_PMinyuuSyoumetuInfo) ;
        }
    }
    public void setBAKPMinyuuSyoumetuInfos(List<IT_BAK_PMinyuuSyoumetuInfo> pIT_BAK_PMinyuuSyoumetuInfos) {
        this.iT_BAKPMinyuuSyoumetuInfos = pIT_BAK_PMinyuuSyoumetuInfos;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_PMinyuuSyoumetuInfo.SYONO+" ASC ,"+IT_BAK_PMinyuuSyoumetuInfo.TRKSSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_PMinyuuSyoumetuInfo> getBAKPMinyuuSyoumetuInfos() {
        return iT_BAKPMinyuuSyoumetuInfos;
    }

    private List<IT_BAK_TrkKzk> iT_BAKTrkKzks = Lists.newLinkedList();
    public IT_BAK_TrkKzk createBAKTrkKzk() {
        IT_BAK_TrkKzk bAKTrkKzk =  new IT_BAK_TrkKzk();
        bAKTrkKzk.setBAKKykKihon(this);
        bAKTrkKzk.setKbnkey(this.getKbnkey());
        bAKTrkKzk.setSyono(this.getSyono());
        bAKTrkKzk.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKTrkKzks().add(bAKTrkKzk);
        return bAKTrkKzk;
    }
    public void setBAKTrkKzks(List<IT_BAK_TrkKzk> pIT_BAK_TrkKzks) {
        this.iT_BAKTrkKzks = pIT_BAK_TrkKzks;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_TrkKzk.SYONO+" ASC ,"+IT_BAK_TrkKzk.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_TrkKzk.TRKKZKKBN+" ASC ")
    public  List<IT_BAK_TrkKzk> getBAKTrkKzks() {
        return iT_BAKTrkKzks;
    }

    private List<IT_BAK_CreditCardInfo> iT_BAKCreditCardInfos = Lists.newLinkedList();
    public IT_BAK_CreditCardInfo createBAKCreditCardInfo() {
        IT_BAK_CreditCardInfo bAKCreditCardInfo =  new IT_BAK_CreditCardInfo();
        bAKCreditCardInfo.setBAKKykKihon(this);
        bAKCreditCardInfo.setKbnkey(this.getKbnkey());
        bAKCreditCardInfo.setSyono(this.getSyono());
        bAKCreditCardInfo.setTrkssikibetukey(this.getTrkssikibetukey());
        setBAKCreditCardInfo(bAKCreditCardInfo);
        return bAKCreditCardInfo;
    }
    @Transient
    public  IT_BAK_CreditCardInfo getBAKCreditCardInfo() {
        if(getBAKCreditCardInfos().size() == 0) {
            return null;
        }
        return getBAKCreditCardInfos().get(0);
    }
    @Transient
    public void setBAKCreditCardInfo(IT_BAK_CreditCardInfo pIT_BAK_CreditCardInfo) {
        if(this.getBAKCreditCardInfos().size() >0){
            this.getBAKCreditCardInfos().set(0, pIT_BAK_CreditCardInfo) ;
        }else{
            this.getBAKCreditCardInfos().add(pIT_BAK_CreditCardInfo) ;
        }
    }
    public void setBAKCreditCardInfos(List<IT_BAK_CreditCardInfo> pIT_BAK_CreditCardInfos) {
        this.iT_BAKCreditCardInfos = pIT_BAK_CreditCardInfos;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_CreditCardInfo.SYONO+" ASC ,"+IT_BAK_CreditCardInfo.TRKSSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_CreditCardInfo> getBAKCreditCardInfos() {
        return iT_BAKCreditCardInfos;
    }

    private List<IT_BAK_KoujyoSymNaiyouD> iT_BAKKoujyoSymNaiyouDs = Lists.newLinkedList();
    public IT_BAK_KoujyoSymNaiyouD createBAKKoujyoSymNaiyouD() {
        IT_BAK_KoujyoSymNaiyouD bAKKoujyoSymNaiyouD =  new IT_BAK_KoujyoSymNaiyouD();
        bAKKoujyoSymNaiyouD.setBAKKykKihon(this);
        bAKKoujyoSymNaiyouD.setKbnkey(this.getKbnkey());
        bAKKoujyoSymNaiyouD.setSyono(this.getSyono());
        bAKKoujyoSymNaiyouD.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKKoujyoSymNaiyouDs().add(bAKKoujyoSymNaiyouD);
        return bAKKoujyoSymNaiyouD;
    }
    public void setBAKKoujyoSymNaiyouDs(List<IT_BAK_KoujyoSymNaiyouD> pIT_BAK_KoujyoSymNaiyouDs) {
        this.iT_BAKKoujyoSymNaiyouDs = pIT_BAK_KoujyoSymNaiyouDs;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KoujyoSymNaiyouD.SYONO+" ASC ,"+IT_BAK_KoujyoSymNaiyouD.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_KoujyoSymNaiyouD.SYOUHNCD+" ASC ,"+IT_BAK_KoujyoSymNaiyouD.RENNO3KETA+" ASC ")
    public  List<IT_BAK_KoujyoSymNaiyouD> getBAKKoujyoSymNaiyouDs() {
        return iT_BAKKoujyoSymNaiyouDs;
    }

    private List<IT_BAK_KhLincKihon> iT_BAKKhLincKihons = Lists.newLinkedList();
    public IT_BAK_KhLincKihon createBAKKhLincKihon() {
        IT_BAK_KhLincKihon bAKKhLincKihon =  new IT_BAK_KhLincKihon();
        bAKKhLincKihon.setBAKKykKihon(this);
        bAKKhLincKihon.setKbnkey(this.getKbnkey());
        bAKKhLincKihon.setSyono(this.getSyono());
        bAKKhLincKihon.setTrkssikibetukey(this.getTrkssikibetukey());
        setBAKKhLincKihon(bAKKhLincKihon);
        return bAKKhLincKihon;
    }
    @Transient
    public  IT_BAK_KhLincKihon getBAKKhLincKihon() {
        if(getBAKKhLincKihons().size() == 0) {
            return null;
        }
        return getBAKKhLincKihons().get(0);
    }
    @Transient
    public void setBAKKhLincKihon(IT_BAK_KhLincKihon pIT_BAK_KhLincKihon) {
        if(this.getBAKKhLincKihons().size() >0){
            this.getBAKKhLincKihons().set(0, pIT_BAK_KhLincKihon) ;
        }else{
            this.getBAKKhLincKihons().add(pIT_BAK_KhLincKihon) ;
        }
    }
    public void setBAKKhLincKihons(List<IT_BAK_KhLincKihon> pIT_BAK_KhLincKihons) {
        this.iT_BAKKhLincKihons = pIT_BAK_KhLincKihons;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KhLincKihon.SYONO+" ASC ,"+IT_BAK_KhLincKihon.TRKSSIKIBETUKEY+" ASC ")
    public  List<IT_BAK_KhLincKihon> getBAKKhLincKihons() {
        return iT_BAKKhLincKihons;
    }

    private List<IT_BAK_KhLincSousinData> iT_BAKKhLincSousinDatas = Lists.newLinkedList();
    public IT_BAK_KhLincSousinData createBAKKhLincSousinData() {
        IT_BAK_KhLincSousinData bAKKhLincSousinData =  new IT_BAK_KhLincSousinData();
        bAKKhLincSousinData.setBAKKykKihon(this);
        bAKKhLincSousinData.setKbnkey(this.getKbnkey());
        bAKKhLincSousinData.setSyono(this.getSyono());
        bAKKhLincSousinData.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKKhLincSousinDatas().add(bAKKhLincSousinData);
        return bAKKhLincSousinData;
    }
    public void setBAKKhLincSousinDatas(List<IT_BAK_KhLincSousinData> pIT_BAK_KhLincSousinDatas) {
        this.iT_BAKKhLincSousinDatas = pIT_BAK_KhLincSousinDatas;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_KhLincSousinData.SYONO+" ASC ,"+IT_BAK_KhLincSousinData.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_KhLincSousinData.SYORIYMD+" ASC ,"+IT_BAK_KhLincSousinData.RENNO+" ASC ")
    public  List<IT_BAK_KhLincSousinData> getBAKKhLincSousinDatas() {
        return iT_BAKKhLincSousinDatas;
    }

    private List<IT_BAK_CreditHnknTuuti> iT_BAKCreditHnknTuutis = Lists.newLinkedList();
    public IT_BAK_CreditHnknTuuti createBAKCreditHnknTuuti() {
        IT_BAK_CreditHnknTuuti bAKCreditHnknTuuti =  new IT_BAK_CreditHnknTuuti();
        bAKCreditHnknTuuti.setBAKKykKihon(this);
        bAKCreditHnknTuuti.setKbnkey(this.getKbnkey());
        bAKCreditHnknTuuti.setSyono(this.getSyono());
        bAKCreditHnknTuuti.setTrkssikibetukey(this.getTrkssikibetukey());
        getBAKCreditHnknTuutis().add(bAKCreditHnknTuuti);
        return bAKCreditHnknTuuti;
    }
    public void setBAKCreditHnknTuutis(List<IT_BAK_CreditHnknTuuti> pIT_BAK_CreditHnknTuutis) {
        this.iT_BAKCreditHnknTuutis = pIT_BAK_CreditHnknTuutis;
    }
    @OneToMany (
        mappedBy = "BAKKykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_BAK_CreditHnknTuuti.SYONO+" ASC ,"+IT_BAK_CreditHnknTuuti.TRKSSIKIBETUKEY+" ASC ,"+IT_BAK_CreditHnknTuuti.DENRENNO+" ASC ,"+IT_BAK_CreditHnknTuuti.EDANO+" ASC ")
    public  List<IT_BAK_CreditHnknTuuti> getBAKCreditHnknTuutis() {
        return iT_BAKCreditHnknTuutis;
    }
}

