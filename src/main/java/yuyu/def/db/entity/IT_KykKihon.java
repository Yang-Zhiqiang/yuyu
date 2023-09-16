package yuyu.def.db.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_MisyuumikeikaKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.classification.C_YykidousyoriKbn;
import yuyu.def.db.mapping.GenIT_KykKihon;
import yuyu.def.hozen.predicate.FilterAeoiInfoByRenno;
import yuyu.def.hozen.predicate.FilterFatcaInfoByRenno;
import yuyu.def.hozen.predicate.FilterHokenSyoukenByTyouhyouymd;
import yuyu.def.hozen.predicate.FilterKariukekinByKrkseisanzumiflg;
import yuyu.def.hozen.predicate.FilterKariukekinByKrkseisanzumiflgNyknaiyoukbn;
import yuyu.def.hozen.predicate.FilterKhLincSousinDataBySyoriYmdRenno;
import yuyu.def.hozen.predicate.FilterKhLincSousinDatasBySyoriYmd;
import yuyu.def.hozen.predicate.FilterKhTtdkRirekiByGyoumuKousinKinou;
import yuyu.def.hozen.predicate.FilterKhTtdkRirekiByGyoumuKousinKinouNe;
import yuyu.def.hozen.predicate.FilterKhTtdkRirekiByHenkousikibetukey;
import yuyu.def.hozen.predicate.FilterKhTtdkRirekiByHenkousikibetukeyGt;
import yuyu.def.hozen.predicate.FilterKhTtdkRirekiBySyoriYmdGyoumuKousinKinou;
import yuyu.def.hozen.predicate.FilterKoujyoSymByNendoRenno;
import yuyu.def.hozen.predicate.FilterKoujyoSymByNnendoTyouhyouymdRennoEq;
import yuyu.def.hozen.predicate.FilterKoujyoSymKanriByNendo;
import yuyu.def.hozen.predicate.FilterKoujyoSymNaiyouByKoujyosyoumeinndKjsmhakkouzumiflg;
import yuyu.def.hozen.predicate.FilterKykDairitenByDrtenrenno;
import yuyu.def.hozen.predicate.FilterKykSyouhnByKouryokuhasseiymdGt;
import yuyu.def.hozen.predicate.FilterKykSyouhnBySyouhncdSyouhnsdno;
import yuyu.def.hozen.predicate.FilterKykSyouhnBySyutkkbn;
import yuyu.def.hozen.predicate.FilterKykSyouhnBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno;
import yuyu.def.hozen.predicate.FilterKykSyouhnByYuukousyoumetukbnKykjyoutai;
import yuyu.def.hozen.predicate.FilterKykUktByUktsyukbn;
import yuyu.def.hozen.predicate.FilterKykUktByUktsyukbnUktsyurenno;
import yuyu.def.hozen.predicate.FilterNyknJissekiRirekiByHrkkymJkipjytymNyktrksflg;
import yuyu.def.hozen.predicate.FilterNyknJissekiRirekiByJyutouendymJyutoustartymNyktrksflg;
import yuyu.def.hozen.predicate.FilterNyknJissekiRirekiByJyutoustartym;
import yuyu.def.hozen.predicate.FilterNyknJissekiRirekiByJyutoustartymNyktrksflg;
import yuyu.def.hozen.predicate.FilterNyknJissekiRirekiByJyutoustartymRenno;
import yuyu.def.hozen.predicate.FilterNyknJissekiRirekiByJyutouymNyktrksflg;
import yuyu.def.hozen.predicate.FilterNyknJissekiRirekiByNykkeiro;
import yuyu.def.hozen.predicate.FilterNyknJissekiRirekiByNykkeiroNyktrksflg;
import yuyu.def.hozen.predicate.FilterNyknJissekiRirekiByNyktrksflg;
import yuyu.def.hozen.predicate.FilterNyknJissekiRirekiByNyktrksflgEq;
import yuyu.def.hozen.predicate.FilterNyknJissekiRirekiByTukitanityokugooutoymNyktrksflg;
import yuyu.def.hozen.predicate.FilterSuiihyouByTyouhyouymd;
import yuyu.def.hozen.predicate.FilterSyouhnTokujouBySyutkkbn;
import yuyu.def.hozen.predicate.FilterSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno;
import yuyu.def.hozen.predicate.FilterTesuuryouByTsrysyorikbnRenno;
import yuyu.def.hozen.predicate.FilterTrkKzkByTrkKzkKbn;
import yuyu.def.hozen.predicate.FilterTtdkKanByHenkousikibetukey;
import yuyu.def.hozen.predicate.FilterTtdkKanByTyouhyouymd;
import yuyu.def.hozen.predicate.FilterYykIdouNaiyoHrhnkByHenkousikibetukey;
import yuyu.def.hozen.predicate.FilterYykIdouUktkByYykidousyorikbn;
import yuyu.def.hozen.result.bean.NyknJissekiRirekiByNyktrksflgBean;
import yuyu.def.hozen.result.bean.SumKihrkmpSeisanRirekiBean;
import yuyu.def.hozen.result.bean.SumNyknJissekiRirekiBean;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


/**
 * 契約基本テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KykKihon} の JavaDoc を参照してください。<br />
 * @see     GenIT_KykKihon<br />
 * @see     PKIT_KykKihon<br />
 * @see     QIT_KykKihon<br />
 * @see     GenQIT_KykKihon<br />
 */
@Entity
public class IT_KykKihon extends GenIT_KykKihon {

    private static final long serialVersionUID = 1L;

    public IT_KykKihon() {
    }

    public IT_KykKihon(String pKbnkey,String pSyono) {
        super(pKbnkey,pSyono);
    }

    public IT_KykKihon(String pSyono) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono);
    }


    private List<IT_KykSyouhn> iT_KykSyouhns = Lists.newLinkedList();
    public IT_KykSyouhn createKykSyouhn() {
        IT_KykSyouhn kykSyouhn =  new IT_KykSyouhn();
        kykSyouhn.setKykKihon(this);
        kykSyouhn.setKbnkey(this.getKbnkey());
        kykSyouhn.setSyono(this.getSyono());
        getKykSyouhns().add(kykSyouhn);
        return kykSyouhn;
    }
    public void setKykSyouhns(List<IT_KykSyouhn> pIT_KykSyouhns) {
        this.iT_KykSyouhns = pIT_KykSyouhns;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KykSyouhn.SYONO+" ASC ,"+IT_KykSyouhn.SYUTKKBN+" ASC ,"+IT_KykSyouhn.SYOUHNCD+" ASC ,"+IT_KykSyouhn.SYOUHNSDNO+" ASC ,"+IT_KykSyouhn.KYKSYOUHNRENNO+" ASC ")
    public  List<IT_KykSyouhn> getKykSyouhns() {
        return iT_KykSyouhns;
    }

    private List<IT_KykSya> iT_KykSyas = Lists.newLinkedList();
    public IT_KykSya createKykSya() {
        IT_KykSya kykSya =  new IT_KykSya();
        kykSya.setKykKihon(this);
        kykSya.setKbnkey(this.getKbnkey());
        kykSya.setSyono(this.getSyono());
        setKykSya(kykSya);
        return kykSya;
    }
    @Transient
    public  IT_KykSya getKykSya() {
        requiredEntities(getKykSyas(),IT_KykSya.class);
        if(getKykSyas().size() == 0) {
            return null;
        }
        return getKykSyas().get(0);
    }
    @Transient
    public void setKykSya(IT_KykSya pIT_KykSya) {
        if(this.getKykSyas().size() >0){
            this.getKykSyas().set(0, pIT_KykSya) ;
        }else{
            this.getKykSyas().add(pIT_KykSya) ;
        }
    }
    public void setKykSyas(List<IT_KykSya> pIT_KykSyas) {
        this.iT_KykSyas = pIT_KykSyas;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KykSya.SYONO+" ASC ")
    public  List<IT_KykSya> getKykSyas() {
        return iT_KykSyas;
    }

    private List<IT_HhknSya> iT_HhknSyas = Lists.newLinkedList();
    public IT_HhknSya createHhknSya() {
        IT_HhknSya hhknSya =  new IT_HhknSya();
        hhknSya.setKykKihon(this);
        hhknSya.setKbnkey(this.getKbnkey());
        hhknSya.setSyono(this.getSyono());
        setHhknSya(hhknSya);
        return hhknSya;
    }
    @Transient
    public  IT_HhknSya getHhknSya() {
        requiredEntities(getHhknSyas(),IT_HhknSya.class);
        if(getHhknSyas().size() == 0) {
            return null;
        }
        return getHhknSyas().get(0);
    }
    @Transient
    public void setHhknSya(IT_HhknSya pIT_HhknSya) {
        if(this.getHhknSyas().size() >0){
            this.getHhknSyas().set(0, pIT_HhknSya) ;
        }else{
            this.getHhknSyas().add(pIT_HhknSya) ;
        }
    }
    public void setHhknSyas(List<IT_HhknSya> pIT_HhknSyas) {
        this.iT_HhknSyas = pIT_HhknSyas;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_HhknSya.SYONO+" ASC ")
    public  List<IT_HhknSya> getHhknSyas() {
        return iT_HhknSyas;
    }

    private List<IT_KykSonotaTkyk> iT_KykSonotaTkyks = Lists.newLinkedList();
    public IT_KykSonotaTkyk createKykSonotaTkyk() {
        IT_KykSonotaTkyk kykSonotaTkyk =  new IT_KykSonotaTkyk();
        kykSonotaTkyk.setKykKihon(this);
        kykSonotaTkyk.setKbnkey(this.getKbnkey());
        kykSonotaTkyk.setSyono(this.getSyono());
        setKykSonotaTkyk(kykSonotaTkyk);
        return kykSonotaTkyk;
    }
    @Transient
    public  IT_KykSonotaTkyk getKykSonotaTkyk() {
        requiredEntities(getKykSonotaTkyks(),IT_KykSonotaTkyk.class);
        if(getKykSonotaTkyks().size() == 0) {
            return null;
        }
        return getKykSonotaTkyks().get(0);
    }
    @Transient
    public void setKykSonotaTkyk(IT_KykSonotaTkyk pIT_KykSonotaTkyk) {
        if(this.getKykSonotaTkyks().size() >0){
            this.getKykSonotaTkyks().set(0, pIT_KykSonotaTkyk) ;
        }else{
            this.getKykSonotaTkyks().add(pIT_KykSonotaTkyk) ;
        }
    }
    public void setKykSonotaTkyks(List<IT_KykSonotaTkyk> pIT_KykSonotaTkyks) {
        this.iT_KykSonotaTkyks = pIT_KykSonotaTkyks;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KykSonotaTkyk.SYONO+" ASC ")
    public  List<IT_KykSonotaTkyk> getKykSonotaTkyks() {
        return iT_KykSonotaTkyks;
    }

    private List<IT_SyouhnTokujou> iT_SyouhnTokujous = Lists.newLinkedList();
    public IT_SyouhnTokujou createSyouhnTokujou() {
        IT_SyouhnTokujou syouhnTokujou =  new IT_SyouhnTokujou();
        syouhnTokujou.setKykKihon(this);
        syouhnTokujou.setKbnkey(this.getKbnkey());
        syouhnTokujou.setSyono(this.getSyono());
        getSyouhnTokujous().add(syouhnTokujou);
        return syouhnTokujou;
    }
    public void setSyouhnTokujous(List<IT_SyouhnTokujou> pIT_SyouhnTokujous) {
        this.iT_SyouhnTokujous = pIT_SyouhnTokujous;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_SyouhnTokujou.SYONO+" ASC ,"+IT_SyouhnTokujou.SYUTKKBN+" ASC ,"+IT_SyouhnTokujou.SYOUHNCD+" ASC ,"+IT_SyouhnTokujou.SYOUHNSDNO+" ASC ,"+IT_SyouhnTokujou.KYKSYOUHNRENNO+" ASC ")
    public  List<IT_SyouhnTokujou> getSyouhnTokujous() {
        return iT_SyouhnTokujous;
    }

    private List<IT_KykUkt> iT_KykUkts = Lists.newLinkedList();
    public IT_KykUkt createKykUkt() {
        IT_KykUkt kykUkt =  new IT_KykUkt();
        kykUkt.setKykKihon(this);
        kykUkt.setKbnkey(this.getKbnkey());
        kykUkt.setSyono(this.getSyono());
        getKykUkts().add(kykUkt);
        return kykUkt;
    }
    public void setKykUkts(List<IT_KykUkt> pIT_KykUkts) {
        this.iT_KykUkts = pIT_KykUkts;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KykUkt.SYONO+" ASC ,"+IT_KykUkt.UKTSYUKBN+" ASC ,"+IT_KykUkt.UKTSYURENNO+" ASC ")
    public  List<IT_KykUkt> getKykUkts() {
        return iT_KykUkts;
    }

    private List<IT_KhTtdkTyuui> iT_KhTtdkTyuuis = Lists.newLinkedList();
    public IT_KhTtdkTyuui createKhTtdkTyuui() {
        IT_KhTtdkTyuui khTtdkTyuui =  new IT_KhTtdkTyuui();
        khTtdkTyuui.setKykKihon(this);
        khTtdkTyuui.setKbnkey(this.getKbnkey());
        khTtdkTyuui.setSyono(this.getSyono());
        setKhTtdkTyuui(khTtdkTyuui);
        return khTtdkTyuui;
    }
    @Transient
    public  IT_KhTtdkTyuui getKhTtdkTyuui() {
        if(getKhTtdkTyuuis().size() == 0) {
            return null;
        }
        return getKhTtdkTyuuis().get(0);
    }
    @Transient
    public void setKhTtdkTyuui(IT_KhTtdkTyuui pIT_KhTtdkTyuui) {
        if(this.getKhTtdkTyuuis().size() >0){
            this.getKhTtdkTyuuis().set(0, pIT_KhTtdkTyuui) ;
        }else{
            this.getKhTtdkTyuuis().add(pIT_KhTtdkTyuui) ;
        }
    }
    public void setKhTtdkTyuuis(List<IT_KhTtdkTyuui> pIT_KhTtdkTyuuis) {
        this.iT_KhTtdkTyuuis = pIT_KhTtdkTyuuis;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KhTtdkTyuui.SYONO+" ASC ")
    public  List<IT_KhTtdkTyuui> getKhTtdkTyuuis() {
        return iT_KhTtdkTyuuis;
    }

    private List<IT_HengakuUnit> iT_HengakuUnits = Lists.newLinkedList();
    public IT_HengakuUnit createHengakuUnit() {
        IT_HengakuUnit hengakuUnit =  new IT_HengakuUnit();
        hengakuUnit.setKykKihon(this);
        hengakuUnit.setKbnkey(this.getKbnkey());
        hengakuUnit.setSyono(this.getSyono());
        getHengakuUnits().add(hengakuUnit);
        return hengakuUnit;
    }
    public void setHengakuUnits(List<IT_HengakuUnit> pIT_HengakuUnits) {
        this.iT_HengakuUnits = pIT_HengakuUnits;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_HengakuUnit.SYONO+" ASC ,"+IT_HengakuUnit.UNITFUNDKBN+" ASC ")
    public  List<IT_HengakuUnit> getHengakuUnits() {
        return iT_HengakuUnits;
    }

    private List<IT_KhLincSousinInfo> iT_KhLincSousinInfos = Lists.newLinkedList();
    public IT_KhLincSousinInfo createKhLincSousinInfo() {
        IT_KhLincSousinInfo khLincSousinInfo =  new IT_KhLincSousinInfo();
        khLincSousinInfo.setKykKihon(this);
        khLincSousinInfo.setKbnkey(this.getKbnkey());
        khLincSousinInfo.setSyono(this.getSyono());
        getKhLincSousinInfos().add(khLincSousinInfo);
        return khLincSousinInfo;
    }
    public void setKhLincSousinInfos(List<IT_KhLincSousinInfo> pIT_KhLincSousinInfos) {
        this.iT_KhLincSousinInfos = pIT_KhLincSousinInfos;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KhLincSousinInfo.LINCSOUJYUSINSYSKBN+" ASC ,"+IT_KhLincSousinInfo.SYONO+" ASC ,"+IT_KhLincSousinInfo.RENNO+" ASC ")
    public  List<IT_KhLincSousinInfo> getKhLincSousinInfos() {
        return iT_KhLincSousinInfos;
    }

    private List<IT_KoujyoSymKanri> iT_KoujyoSymKanris = Lists.newLinkedList();
    public IT_KoujyoSymKanri createKoujyoSymKanri() {
        IT_KoujyoSymKanri koujyoSymKanri =  new IT_KoujyoSymKanri();
        koujyoSymKanri.setKykKihon(this);
        koujyoSymKanri.setKbnkey(this.getKbnkey());
        koujyoSymKanri.setSyono(this.getSyono());
        getKoujyoSymKanris().add(koujyoSymKanri);
        return koujyoSymKanri;
    }
    public void setKoujyoSymKanris(List<IT_KoujyoSymKanri> pIT_KoujyoSymKanris) {
        this.iT_KoujyoSymKanris = pIT_KoujyoSymKanris;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KoujyoSymKanri.SYONO+" ASC ,"+IT_KoujyoSymKanri.NENDO+" ASC ")
    public  List<IT_KoujyoSymKanri> getKoujyoSymKanris() {
        return iT_KoujyoSymKanris;
    }

    private List<IT_YykIdouUktk> iT_YykIdouUktks = Lists.newLinkedList();
    public IT_YykIdouUktk createYykIdouUktk() {
        IT_YykIdouUktk yykIdouUktk =  new IT_YykIdouUktk();
        yykIdouUktk.setKykKihon(this);
        yykIdouUktk.setKbnkey(this.getKbnkey());
        yykIdouUktk.setSyono(this.getSyono());
        getYykIdouUktks().add(yykIdouUktk);
        return yykIdouUktk;
    }
    public void setYykIdouUktks(List<IT_YykIdouUktk> pIT_YykIdouUktks) {
        this.iT_YykIdouUktks = pIT_YykIdouUktks;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_YykIdouUktk.SYONO+" ASC ,"+IT_YykIdouUktk.HENKOUSIKIBETUKEY+" ASC ,"+IT_YykIdouUktk.KINOUID+" ASC ")
    public  List<IT_YykIdouUktk> getYykIdouUktks() {
        return iT_YykIdouUktks;
    }

    private List<IT_YykIdouNaiyoHrhnk> iT_YykIdouNaiyoHrhnks = Lists.newLinkedList();
    public IT_YykIdouNaiyoHrhnk createYykIdouNaiyoHrhnk() {
        IT_YykIdouNaiyoHrhnk yykIdouNaiyoHrhnk =  new IT_YykIdouNaiyoHrhnk();
        yykIdouNaiyoHrhnk.setKykKihon(this);
        yykIdouNaiyoHrhnk.setKbnkey(this.getKbnkey());
        yykIdouNaiyoHrhnk.setSyono(this.getSyono());
        getYykIdouNaiyoHrhnks().add(yykIdouNaiyoHrhnk);
        return yykIdouNaiyoHrhnk;
    }
    public void setYykIdouNaiyoHrhnks(List<IT_YykIdouNaiyoHrhnk> pIT_YykIdouNaiyoHrhnks) {
        this.iT_YykIdouNaiyoHrhnks = pIT_YykIdouNaiyoHrhnks;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_YykIdouNaiyoHrhnk.SYONO+" ASC ,"+IT_YykIdouNaiyoHrhnk.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_YykIdouNaiyoHrhnk> getYykIdouNaiyoHrhnks() {
        return iT_YykIdouNaiyoHrhnks;
    }

    private List<IT_YykIdouAnsyuCreditCard> iT_YykIdouAnsyuCreditCards = Lists.newLinkedList();
    public IT_YykIdouAnsyuCreditCard createYykIdouAnsyuCreditCard() {
        IT_YykIdouAnsyuCreditCard yykIdouAnsyuCreditCard =  new IT_YykIdouAnsyuCreditCard();
        yykIdouAnsyuCreditCard.setKykKihon(this);
        yykIdouAnsyuCreditCard.setKbnkey(this.getKbnkey());
        yykIdouAnsyuCreditCard.setSyono(this.getSyono());
        getYykIdouAnsyuCreditCards().add(yykIdouAnsyuCreditCard);
        return yykIdouAnsyuCreditCard;
    }
    public void setYykIdouAnsyuCreditCards(List<IT_YykIdouAnsyuCreditCard> pIT_YykIdouAnsyuCreditCards) {
        this.iT_YykIdouAnsyuCreditCards = pIT_YykIdouAnsyuCreditCards;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_YykIdouAnsyuCreditCard.SYONO+" ASC ,"+IT_YykIdouAnsyuCreditCard.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_YykIdouAnsyuCreditCard> getYykIdouAnsyuCreditCards() {
        return iT_YykIdouAnsyuCreditCards;
    }

    private List<IT_CreditCard> iT_CreditCards = Lists.newLinkedList();
    public IT_CreditCard createCreditCard() {
        IT_CreditCard creditCard =  new IT_CreditCard();
        creditCard.setKykKihon(this);
        creditCard.setKbnkey(this.getKbnkey());
        creditCard.setSyono(this.getSyono());
        setCreditCard(creditCard);
        return creditCard;
    }
    @Transient
    public  IT_CreditCard getCreditCard() {
        if(getCreditCards().size() == 0) {
            return null;
        }
        return getCreditCards().get(0);
    }
    @Transient
    public void setCreditCard(IT_CreditCard pIT_CreditCard) {
        if(this.getCreditCards().size() >0){
            this.getCreditCards().set(0, pIT_CreditCard) ;
        }else{
            this.getCreditCards().add(pIT_CreditCard) ;
        }
    }
    public void setCreditCards(List<IT_CreditCard> pIT_CreditCards) {
        this.iT_CreditCards = pIT_CreditCards;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_CreditCard.SYONO+" ASC ")
    public  List<IT_CreditCard> getCreditCards() {
        return iT_CreditCards;
    }

    private List<IT_Kouza> iT_Kouzas = Lists.newLinkedList();
    public IT_Kouza createKouza() {
        IT_Kouza kouza =  new IT_Kouza();
        kouza.setKykKihon(this);
        kouza.setKbnkey(this.getKbnkey());
        kouza.setSyono(this.getSyono());
        setKouza(kouza);
        return kouza;
    }
    @Transient
    public  IT_Kouza getKouza() {
        if(getKouzas().size() == 0) {
            return null;
        }
        return getKouzas().get(0);
    }
    @Transient
    public void setKouza(IT_Kouza pIT_Kouza) {
        if(this.getKouzas().size() >0){
            this.getKouzas().set(0, pIT_Kouza) ;
        }else{
            this.getKouzas().add(pIT_Kouza) ;
        }
    }
    public void setKouzas(List<IT_Kouza> pIT_Kouzas) {
        this.iT_Kouzas = pIT_Kouzas;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_Kouza.SYONO+" ASC ")
    public  List<IT_Kouza> getKouzas() {
        return iT_Kouzas;
    }

    private List<IT_TeikikinKouza> iT_TeikikinKouzas = Lists.newLinkedList();
    public IT_TeikikinKouza createTeikikinKouza() {
        IT_TeikikinKouza teikikinKouza =  new IT_TeikikinKouza();
        teikikinKouza.setKykKihon(this);
        teikikinKouza.setKbnkey(this.getKbnkey());
        teikikinKouza.setSyono(this.getSyono());
        setTeikikinKouza(teikikinKouza);
        return teikikinKouza;
    }
    @Transient
    public  IT_TeikikinKouza getTeikikinKouza() {
        if(getTeikikinKouzas().size() == 0) {
            return null;
        }
        return getTeikikinKouzas().get(0);
    }
    @Transient
    public void setTeikikinKouza(IT_TeikikinKouza pIT_TeikikinKouza) {
        if(this.getTeikikinKouzas().size() >0){
            this.getTeikikinKouzas().set(0, pIT_TeikikinKouza) ;
        }else{
            this.getTeikikinKouzas().add(pIT_TeikikinKouza) ;
        }
    }
    public void setTeikikinKouzas(List<IT_TeikikinKouza> pIT_TeikikinKouzas) {
        this.iT_TeikikinKouzas = pIT_TeikikinKouzas;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_TeikikinKouza.SYONO+" ASC ")
    public  List<IT_TeikikinKouza> getTeikikinKouzas() {
        return iT_TeikikinKouzas;
    }

    private List<IT_KykDairiten> iT_KykDairitens = Lists.newLinkedList();
    public IT_KykDairiten createKykDairiten() {
        IT_KykDairiten kykDairiten =  new IT_KykDairiten();
        kykDairiten.setKykKihon(this);
        kykDairiten.setKbnkey(this.getKbnkey());
        kykDairiten.setSyono(this.getSyono());
        getKykDairitens().add(kykDairiten);
        return kykDairiten;
    }
    public void setKykDairitens(List<IT_KykDairiten> pIT_KykDairitens) {
        this.iT_KykDairitens = pIT_KykDairitens;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KykDairiten.SYONO+" ASC ,"+IT_KykDairiten.DRTENRENNO+" ASC ")
    public  List<IT_KykDairiten> getKykDairitens() {
        return iT_KykDairitens;
    }

    private List<IT_FatcaInfo> iT_FatcaInfos = Lists.newLinkedList();
    public IT_FatcaInfo createFatcaInfo() {
        IT_FatcaInfo fatcaInfo =  new IT_FatcaInfo();
        fatcaInfo.setKykKihon(this);
        fatcaInfo.setKbnkey(this.getKbnkey());
        fatcaInfo.setSyono(this.getSyono());
        getFatcaInfos().add(fatcaInfo);
        return fatcaInfo;
    }
    public void setFatcaInfos(List<IT_FatcaInfo> pIT_FatcaInfos) {
        this.iT_FatcaInfos = pIT_FatcaInfos;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_FatcaInfo.SYONO+" ASC ,"+IT_FatcaInfo.RENNO+" ASC ")
    public  List<IT_FatcaInfo> getFatcaInfos() {
        return iT_FatcaInfos;
    }

    private List<IT_Kariukekin> iT_Kariukekins = Lists.newLinkedList();
    public IT_Kariukekin createKariukekin() {
        IT_Kariukekin kariukekin =  new IT_Kariukekin();
        kariukekin.setKykKihon(this);
        kariukekin.setKbnkey(this.getKbnkey());
        kariukekin.setSyono(this.getSyono());
        getKariukekins().add(kariukekin);
        return kariukekin;
    }
    public void setKariukekins(List<IT_Kariukekin> pIT_Kariukekins) {
        this.iT_Kariukekins = pIT_Kariukekins;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_Kariukekin.SYONO+" ASC ,"+IT_Kariukekin.KRKNO+" ASC ")
    public  List<IT_Kariukekin> getKariukekins() {
        return iT_Kariukekins;
    }

    private List<IT_NyknJissekiRireki> iT_NyknJissekiRirekis = Lists.newLinkedList();
    public IT_NyknJissekiRireki createNyknJissekiRireki() {
        IT_NyknJissekiRireki nyknJissekiRireki =  new IT_NyknJissekiRireki();
        nyknJissekiRireki.setKykKihon(this);
        nyknJissekiRireki.setKbnkey(this.getKbnkey());
        nyknJissekiRireki.setSyono(this.getSyono());
        getNyknJissekiRirekis().add(nyknJissekiRireki);
        return nyknJissekiRireki;
    }
    public void setNyknJissekiRirekis(List<IT_NyknJissekiRireki> pIT_NyknJissekiRirekis) {
        this.iT_NyknJissekiRirekis = pIT_NyknJissekiRirekis;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_NyknJissekiRireki.SYONO+" ASC ,"+IT_NyknJissekiRireki.JYUTOUSTARTYM+" ASC ,"+IT_NyknJissekiRireki.RENNO+" ASC ")
    public  List<IT_NyknJissekiRireki> getNyknJissekiRirekis() {
        return iT_NyknJissekiRirekis;
    }

    private List<IT_KoujyoSymNaiyou> iT_KoujyoSymNaiyous = Lists.newLinkedList();
    public IT_KoujyoSymNaiyou createKoujyoSymNaiyou() {
        IT_KoujyoSymNaiyou koujyoSymNaiyou =  new IT_KoujyoSymNaiyou();
        koujyoSymNaiyou.setKykKihon(this);
        koujyoSymNaiyou.setKbnkey(this.getKbnkey());
        koujyoSymNaiyou.setSyono(this.getSyono());
        getKoujyoSymNaiyous().add(koujyoSymNaiyou);
        return koujyoSymNaiyou;
    }
    public void setKoujyoSymNaiyous(List<IT_KoujyoSymNaiyou> pIT_KoujyoSymNaiyous) {
        this.iT_KoujyoSymNaiyous = pIT_KoujyoSymNaiyous;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KoujyoSymNaiyou.SYONO+" ASC ,"+IT_KoujyoSymNaiyou.SYOUHNCD+" ASC ,"+IT_KoujyoSymNaiyou.RENNO3KETA+" ASC ")
    public  List<IT_KoujyoSymNaiyou> getKoujyoSymNaiyous() {
        return iT_KoujyoSymNaiyous;
    }

    private List<IT_KihrkmpSeisanRireki> iT_KihrkmpSeisanRirekis = Lists.newLinkedList();
    public IT_KihrkmpSeisanRireki createKihrkmpSeisanRireki() {
        IT_KihrkmpSeisanRireki kihrkmpSeisanRireki =  new IT_KihrkmpSeisanRireki();
        kihrkmpSeisanRireki.setKykKihon(this);
        kihrkmpSeisanRireki.setKbnkey(this.getKbnkey());
        kihrkmpSeisanRireki.setSyono(this.getSyono());
        getKihrkmpSeisanRirekis().add(kihrkmpSeisanRireki);
        return kihrkmpSeisanRireki;
    }
    public void setKihrkmpSeisanRirekis(List<IT_KihrkmpSeisanRireki> pIT_KihrkmpSeisanRirekis) {
        this.iT_KihrkmpSeisanRirekis = pIT_KihrkmpSeisanRirekis;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KihrkmpSeisanRireki.SYONO+" ASC ,"+IT_KihrkmpSeisanRireki.RENNO+" ASC ")
    public  List<IT_KihrkmpSeisanRireki> getKihrkmpSeisanRirekis() {
        return iT_KihrkmpSeisanRirekis;
    }

    private List<IT_KhTtdkRireki> iT_KhTtdkRirekis = Lists.newLinkedList();
    public IT_KhTtdkRireki createKhTtdkRireki() {
        IT_KhTtdkRireki khTtdkRireki =  new IT_KhTtdkRireki();
        khTtdkRireki.setKykKihon(this);
        khTtdkRireki.setKbnkey(this.getKbnkey());
        khTtdkRireki.setSyono(this.getSyono());
        getKhTtdkRirekis().add(khTtdkRireki);
        return khTtdkRireki;
    }
    public void setKhTtdkRirekis(List<IT_KhTtdkRireki> pIT_KhTtdkRirekis) {
        this.iT_KhTtdkRirekis = pIT_KhTtdkRirekis;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KhTtdkRireki.SYONO+" ASC ,"+IT_KhTtdkRireki.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_KhTtdkRireki> getKhTtdkRirekis() {
        return iT_KhTtdkRirekis;
    }

    private List<IT_Tesuuryou> iT_Tesuuryous = Lists.newLinkedList();
    public IT_Tesuuryou createTesuuryou() {
        IT_Tesuuryou tesuuryou =  new IT_Tesuuryou();
        tesuuryou.setKykKihon(this);
        tesuuryou.setKbnkey(this.getKbnkey());
        tesuuryou.setSyono(this.getSyono());
        getTesuuryous().add(tesuuryou);
        return tesuuryou;
    }
    public void setTesuuryous(List<IT_Tesuuryou> pIT_Tesuuryous) {
        this.iT_Tesuuryous = pIT_Tesuuryous;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_Tesuuryou.SYONO+" ASC ,"+IT_Tesuuryou.TSRYSYORIKBN+" ASC ,"+IT_Tesuuryou.RENNO+" ASC ")
    public  List<IT_Tesuuryou> getTesuuryous() {
        return iT_Tesuuryous;
    }

    private List<IT_KoujyoSym> iT_KoujyoSyms = Lists.newLinkedList();
    public IT_KoujyoSym createKoujyoSym() {
        IT_KoujyoSym koujyoSym =  new IT_KoujyoSym();
        koujyoSym.setKykKihon(this);
        koujyoSym.setKbnkey(this.getKbnkey());
        koujyoSym.setSyono(this.getSyono());
        getKoujyoSyms().add(koujyoSym);
        return koujyoSym;
    }
    public void setKoujyoSyms(List<IT_KoujyoSym> pIT_KoujyoSyms) {
        this.iT_KoujyoSyms = pIT_KoujyoSyms;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KoujyoSym.SYONO+" ASC ,"+IT_KoujyoSym.NENDO+" ASC ,"+IT_KoujyoSym.TYOUHYOUYMD+" ASC ,"+IT_KoujyoSym.RENNO+" ASC ")
    public  List<IT_KoujyoSym> getKoujyoSyms() {
        return iT_KoujyoSyms;
    }

    private List<IT_Suiihyou> iT_Suiihyous = Lists.newLinkedList();
    public IT_Suiihyou createSuiihyou() {
        IT_Suiihyou suiihyou =  new IT_Suiihyou();
        suiihyou.setKykKihon(this);
        suiihyou.setKbnkey(this.getKbnkey());
        suiihyou.setSyono(this.getSyono());
        getSuiihyous().add(suiihyou);
        return suiihyou;
    }
    public void setSuiihyous(List<IT_Suiihyou> pIT_Suiihyous) {
        this.iT_Suiihyous = pIT_Suiihyous;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_Suiihyou.SYONO+" ASC ,"+IT_Suiihyou.TYOUHYOUYMD+" ASC ,"+IT_Suiihyou.KEIKANENSUU+" ASC ")
    public  List<IT_Suiihyou> getSuiihyous() {
        return iT_Suiihyous;
    }

    private List<IT_TtdkKan> iT_TtdkKans = Lists.newLinkedList();
    public IT_TtdkKan createTtdkKan() {
        IT_TtdkKan ttdkKan =  new IT_TtdkKan();
        ttdkKan.setKykKihon(this);
        ttdkKan.setKbnkey(this.getKbnkey());
        ttdkKan.setSyono(this.getSyono());
        getTtdkKans().add(ttdkKan);
        return ttdkKan;
    }
    public void setTtdkKans(List<IT_TtdkKan> pIT_TtdkKans) {
        this.iT_TtdkKans = pIT_TtdkKans;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_TtdkKan.SYONO+" ASC ,"+IT_TtdkKan.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_TtdkKan> getTtdkKans() {
        return iT_TtdkKans;
    }

    private List<IT_HokenSyouken> iT_HokenSyoukens = Lists.newLinkedList();
    public IT_HokenSyouken createHokenSyouken() {
        IT_HokenSyouken hokenSyouken =  new IT_HokenSyouken();
        hokenSyouken.setKykKihon(this);
        hokenSyouken.setKbnkey(this.getKbnkey());
        hokenSyouken.setSyono(this.getSyono());
        getHokenSyoukens().add(hokenSyouken);
        return hokenSyouken;
    }
    public void setHokenSyoukens(List<IT_HokenSyouken> pIT_HokenSyoukens) {
        this.iT_HokenSyoukens = pIT_HokenSyoukens;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_HokenSyouken.SYONO+" ASC ,"+IT_HokenSyouken.TYOUHYOUYMD+" ASC ")
    public  List<IT_HokenSyouken> getHokenSyoukens() {
        return iT_HokenSyoukens;
    }

    private AS_Kinou aS_Kinou ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=IT_KykKihon.GYOUMUKOUSINKINOU  , referencedColumnName=AS_Kinou.KINOUID, insertable=false, updatable=false)
    })
    public  AS_Kinou getKinou() {
        return aS_Kinou;
    }

    public void setKinou(AS_Kinou pAS_Kinou) {
        this.aS_Kinou = pAS_Kinou;
    }

    private List<IT_AeoiInfo> iT_AeoiInfos = Lists.newLinkedList();
    public IT_AeoiInfo createAeoiInfo() {
        IT_AeoiInfo aeoiInfo =  new IT_AeoiInfo();
        aeoiInfo.setKykKihon(this);
        aeoiInfo.setKbnkey(this.getKbnkey());
        aeoiInfo.setSyono(this.getSyono());
        getAeoiInfos().add(aeoiInfo);
        return aeoiInfo;
    }
    public void setAeoiInfos(List<IT_AeoiInfo> pIT_AeoiInfos) {
        this.iT_AeoiInfos = pIT_AeoiInfos;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_AeoiInfo.SYONO+" ASC ,"+IT_AeoiInfo.RENNO+" ASC ")
    public  List<IT_AeoiInfo> getAeoiInfos() {
        return iT_AeoiInfos;
    }

    private List<IT_KhHenreikin> iT_KhHenreikins = Lists.newLinkedList();
    public IT_KhHenreikin createKhHenreikin() {
        IT_KhHenreikin khHenreikin =  new IT_KhHenreikin();
        khHenreikin.setKykKihon(this);
        khHenreikin.setKbnkey(this.getKbnkey());
        khHenreikin.setSyono(this.getSyono());
        getKhHenreikins().add(khHenreikin);
        return khHenreikin;
    }
    public void setKhHenreikins(List<IT_KhHenreikin> pIT_KhHenreikins) {
        this.iT_KhHenreikins = pIT_KhHenreikins;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KhHenreikin.SYONO+" ASC ,"+IT_KhHenreikin.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_KhHenreikin> getKhHenreikins() {
        return iT_KhHenreikins;
    }

    private List<IT_KhSisuurendoTmttkn> iT_KhSisuurendoTmttkns = Lists.newLinkedList();
    public IT_KhSisuurendoTmttkn createKhSisuurendoTmttkn() {
        IT_KhSisuurendoTmttkn khSisuurendoTmttkn =  new IT_KhSisuurendoTmttkn();
        khSisuurendoTmttkn.setKykKihon(this);
        khSisuurendoTmttkn.setKbnkey(this.getKbnkey());
        khSisuurendoTmttkn.setSyono(this.getSyono());
        getKhSisuurendoTmttkns().add(khSisuurendoTmttkn);
        return khSisuurendoTmttkn;
    }
    public void setKhSisuurendoTmttkns(List<IT_KhSisuurendoTmttkn> pIT_KhSisuurendoTmttkns) {
        this.iT_KhSisuurendoTmttkns = pIT_KhSisuurendoTmttkns;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KhSisuurendoTmttkn.SYONO+" ASC ,"+IT_KhSisuurendoTmttkn.TMTTKNTAISYOUYM+" ASC ,"+IT_KhSisuurendoTmttkn.RENNO+" ASC ")
    public  List<IT_KhSisuurendoTmttkn> getKhSisuurendoTmttkns() {
        return iT_KhSisuurendoTmttkns;
    }

    private List<IT_Azukarikin> iT_Azukarikins = Lists.newLinkedList();
    public IT_Azukarikin createAzukarikin() {
        IT_Azukarikin azukarikin =  new IT_Azukarikin();
        azukarikin.setKykKihon(this);
        azukarikin.setKbnkey(this.getKbnkey());
        azukarikin.setSyono(this.getSyono());
        getAzukarikins().add(azukarikin);
        return azukarikin;
    }
    public void setAzukarikins(List<IT_Azukarikin> pIT_Azukarikins) {
        this.iT_Azukarikins = pIT_Azukarikins;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_Azukarikin.SYONO+" ASC ,"+IT_Azukarikin.HENKOUSIKIBETUKEY+" ASC ,"+IT_Azukarikin.TUUKASYU+" ASC ")
    public  List<IT_Azukarikin> getAzukarikins() {
        return iT_Azukarikins;
    }

    private List<IT_HokenryouTmttkn> iT_HokenryouTmttkns = Lists.newLinkedList();
    public IT_HokenryouTmttkn createHokenryouTmttkn() {
        IT_HokenryouTmttkn hokenryouTmttkn =  new IT_HokenryouTmttkn();
        hokenryouTmttkn.setKykKihon(this);
        hokenryouTmttkn.setKbnkey(this.getKbnkey());
        hokenryouTmttkn.setSyono(this.getSyono());
        getHokenryouTmttkns().add(hokenryouTmttkn);
        return hokenryouTmttkn;
    }
    public void setHokenryouTmttkns(List<IT_HokenryouTmttkn> pIT_HokenryouTmttkns) {
        this.iT_HokenryouTmttkns = pIT_HokenryouTmttkns;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_HokenryouTmttkn.SYONO+" ASC ,"+IT_HokenryouTmttkn.TMTTKNTAISYOUYM+" ASC ,"+IT_HokenryouTmttkn.RENNO+" ASC ")
    public  List<IT_HokenryouTmttkn> getHokenryouTmttkns() {
        return iT_HokenryouTmttkns;
    }

    private List<IT_PMinyuuSyoumetuInfo> iT_PMinyuuSyoumetuInfos = Lists.newLinkedList();
    public IT_PMinyuuSyoumetuInfo createPMinyuuSyoumetuInfo() {
        IT_PMinyuuSyoumetuInfo pMinyuuSyoumetuInfo =  new IT_PMinyuuSyoumetuInfo();
        pMinyuuSyoumetuInfo.setKykKihon(this);
        pMinyuuSyoumetuInfo.setKbnkey(this.getKbnkey());
        pMinyuuSyoumetuInfo.setSyono(this.getSyono());
        setPMinyuuSyoumetuInfo(pMinyuuSyoumetuInfo);
        return pMinyuuSyoumetuInfo;
    }
    @Transient
    public  IT_PMinyuuSyoumetuInfo getPMinyuuSyoumetuInfo() {
        if(getPMinyuuSyoumetuInfos().size() == 0) {
            return null;
        }
        return getPMinyuuSyoumetuInfos().get(0);
    }
    @Transient
    public void setPMinyuuSyoumetuInfo(IT_PMinyuuSyoumetuInfo pIT_PMinyuuSyoumetuInfo) {
        if(this.getPMinyuuSyoumetuInfos().size() >0){
            this.getPMinyuuSyoumetuInfos().set(0, pIT_PMinyuuSyoumetuInfo) ;
        }else{
            this.getPMinyuuSyoumetuInfos().add(pIT_PMinyuuSyoumetuInfo) ;
        }
    }
    public void setPMinyuuSyoumetuInfos(List<IT_PMinyuuSyoumetuInfo> pIT_PMinyuuSyoumetuInfos) {
        this.iT_PMinyuuSyoumetuInfos = pIT_PMinyuuSyoumetuInfos;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_PMinyuuSyoumetuInfo.SYONO+" ASC ")
    public  List<IT_PMinyuuSyoumetuInfo> getPMinyuuSyoumetuInfos() {
        return iT_PMinyuuSyoumetuInfos;
    }

    private List<IT_TrkKzk> iT_TrkKzks = Lists.newLinkedList();
    public IT_TrkKzk createTrkKzk() {
        IT_TrkKzk trkKzk =  new IT_TrkKzk();
        trkKzk.setKykKihon(this);
        trkKzk.setKbnkey(this.getKbnkey());
        trkKzk.setSyono(this.getSyono());
        getTrkKzks().add(trkKzk);
        return trkKzk;
    }
    public void setTrkKzks(List<IT_TrkKzk> pIT_TrkKzks) {
        this.iT_TrkKzks = pIT_TrkKzks;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_TrkKzk.SYONO+" ASC ,"+IT_TrkKzk.TRKKZKKBN+" ASC ")
    public  List<IT_TrkKzk> getTrkKzks() {
        return iT_TrkKzks;
    }

    private List<IT_CreditCardInfo> iT_CreditCardInfos = Lists.newLinkedList();
    public IT_CreditCardInfo createCreditCardInfo() {
        IT_CreditCardInfo creditCardInfo =  new IT_CreditCardInfo();
        creditCardInfo.setKykKihon(this);
        creditCardInfo.setKbnkey(this.getKbnkey());
        creditCardInfo.setSyono(this.getSyono());
        setCreditCardInfo(creditCardInfo);
        return creditCardInfo;
    }
    @Transient
    public  IT_CreditCardInfo getCreditCardInfo() {
        if(getCreditCardInfos().size() == 0) {
            return null;
        }
        return getCreditCardInfos().get(0);
    }
    @Transient
    public void setCreditCardInfo(IT_CreditCardInfo pIT_CreditCardInfo) {
        if(this.getCreditCardInfos().size() >0){
            this.getCreditCardInfos().set(0, pIT_CreditCardInfo) ;
        }else{
            this.getCreditCardInfos().add(pIT_CreditCardInfo) ;
        }
    }
    public void setCreditCardInfos(List<IT_CreditCardInfo> pIT_CreditCardInfos) {
        this.iT_CreditCardInfos = pIT_CreditCardInfos;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_CreditCardInfo.SYONO+" ASC ")
    public  List<IT_CreditCardInfo> getCreditCardInfos() {
        return iT_CreditCardInfos;
    }

    private List<IT_KoujyoSymNaiyouD> iT_KoujyoSymNaiyouDs = Lists.newLinkedList();
    public IT_KoujyoSymNaiyouD createKoujyoSymNaiyouD() {
        IT_KoujyoSymNaiyouD koujyoSymNaiyouD =  new IT_KoujyoSymNaiyouD();
        koujyoSymNaiyouD.setKykKihon(this);
        koujyoSymNaiyouD.setKbnkey(this.getKbnkey());
        koujyoSymNaiyouD.setSyono(this.getSyono());
        getKoujyoSymNaiyouDs().add(koujyoSymNaiyouD);
        return koujyoSymNaiyouD;
    }
    public void setKoujyoSymNaiyouDs(List<IT_KoujyoSymNaiyouD> pIT_KoujyoSymNaiyouDs) {
        this.iT_KoujyoSymNaiyouDs = pIT_KoujyoSymNaiyouDs;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KoujyoSymNaiyouD.SYONO+" ASC ,"+IT_KoujyoSymNaiyouD.SYOUHNCD+" ASC ,"+IT_KoujyoSymNaiyouD.RENNO3KETA+" ASC ")
    public  List<IT_KoujyoSymNaiyouD> getKoujyoSymNaiyouDs() {
        return iT_KoujyoSymNaiyouDs;
    }

    private List<IT_KhLincKihon> iT_KhLincKihons = Lists.newLinkedList();
    public IT_KhLincKihon createKhLincKihon() {
        IT_KhLincKihon khLincKihon =  new IT_KhLincKihon();
        khLincKihon.setKykKihon(this);
        khLincKihon.setKbnkey(this.getKbnkey());
        khLincKihon.setSyono(this.getSyono());
        setKhLincKihon(khLincKihon);
        return khLincKihon;
    }
    @Transient
    public  IT_KhLincKihon getKhLincKihon() {
        if(getKhLincKihons().size() == 0) {
            return null;
        }
        return getKhLincKihons().get(0);
    }
    @Transient
    public void setKhLincKihon(IT_KhLincKihon pIT_KhLincKihon) {
        if(this.getKhLincKihons().size() >0){
            this.getKhLincKihons().set(0, pIT_KhLincKihon) ;
        }else{
            this.getKhLincKihons().add(pIT_KhLincKihon) ;
        }
    }
    public void setKhLincKihons(List<IT_KhLincKihon> pIT_KhLincKihons) {
        this.iT_KhLincKihons = pIT_KhLincKihons;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KhLincKihon.SYONO+" ASC ")
    public  List<IT_KhLincKihon> getKhLincKihons() {
        return iT_KhLincKihons;
    }

    private List<IT_KhLincSousinData> iT_KhLincSousinDatas = Lists.newLinkedList();
    public IT_KhLincSousinData createKhLincSousinData() {
        IT_KhLincSousinData khLincSousinData =  new IT_KhLincSousinData();
        khLincSousinData.setKykKihon(this);
        khLincSousinData.setKbnkey(this.getKbnkey());
        khLincSousinData.setSyono(this.getSyono());
        getKhLincSousinDatas().add(khLincSousinData);
        return khLincSousinData;
    }
    public void setKhLincSousinDatas(List<IT_KhLincSousinData> pIT_KhLincSousinDatas) {
        this.iT_KhLincSousinDatas = pIT_KhLincSousinDatas;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KhLincSousinData.SYONO+" ASC ,"+IT_KhLincSousinData.SYORIYMD+" ASC ,"+IT_KhLincSousinData.RENNO+" ASC ")
    public  List<IT_KhLincSousinData> getKhLincSousinDatas() {
        return iT_KhLincSousinDatas;
    }

    @Transient
    public List<IT_KhLincSousinData> getKhLincSousinDatas(BizDate pSyoriYmd) {
        return new ArrayList<IT_KhLincSousinData>(Collections2.filter(getKhLincSousinDatas(),
            new FilterKhLincSousinDatasBySyoriYmd(pSyoriYmd)));
    }

    @Transient
    public IT_KhLincSousinData getKhLincSousinDataBySyoriYmdRenno(BizDate pSyoriYmd, Integer pRenno) {
        return Iterables.getFirst(Iterables.filter(getKhLincSousinDatas(),
            new FilterKhLincSousinDataBySyoriYmdRenno(pSyoriYmd, pRenno)), null);
    }

    @Transient
    public  IT_KykSyouhn getKykSyouhnByPK(C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        return Iterables.getFirst(Iterables.filter(getKykSyouhns(),
            new FilterKykSyouhnBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(pSyutkkbn, pSyouhncd, pSyouhnsdno,
                pKyksyouhnrenno)), null);
    }
    @Transient
    public  List<IT_KykSyouhn> getKykSyouhnsByKouryokuhasseiymdGt(BizDate pKouryokuhasseiymd) {
        return new ArrayList<IT_KykSyouhn>(Collections2.filter(getKykSyouhns(),
            new FilterKykSyouhnByKouryokuhasseiymdGt(pKouryokuhasseiymd)));
    }
    @Transient
    public  List<IT_KykSyouhn> getKykSyouhnsBySyouhncdSyouhnsdno(String pSyouhncd,Integer pSyouhnsdno) {
        return new ArrayList<IT_KykSyouhn>(Collections2.filter(getKykSyouhns(),
            new FilterKykSyouhnBySyouhncdSyouhnsdno(pSyouhncd, pSyouhnsdno)));
    }
    @Transient
    public  List<Object[]> getKoujyosyoumeipkbnKykSyouhnSumHokenryouSyouhnTokujouSumTkjyps() {
                Map<C_KoujyosyoumeipKbn, Map<CurrencyType, BizCurrency>> kykSyouhnHokenryouMap = new HashMap<>();
                Map<C_KoujyosyoumeipKbn, Map<CurrencyType, BizCurrency>> syouhnTokujouTkjypMap = new HashMap<>();

                BizCurrency valHokenryou = null;
                CurrencyType typeHokenryou = null;

                BizCurrency valTkjyp = null;
                CurrencyType typeTkjyp = null;

                        List<Object[]> objLst = new ArrayList<>();

                List<IT_KykSyouhn> kykSyouhnLst = getKykSyouhns();

                for (IT_KykSyouhn kykSyouhn : kykSyouhnLst) {

            IT_SyouhnTokujou syouhnTokujou = kykSyouhn.getKykKihon().getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                kykSyouhn.getSyutkkbn(), kykSyouhn.getSyouhncd(), kykSyouhn.getSyouhnsdno(), kykSyouhn.getKyksyouhnrenno());
                        C_KoujyosyoumeipKbn koujyosyoumeipKbn = kykSyouhn.getSyouhnZokusei().getKoujyosyoumeipkbn();

                        valTkjyp = syouhnTokujou.getTkjyp();
                        Map<CurrencyType, BizCurrency> sumTkjyp = new HashMap<>();

                        valHokenryou = kykSyouhn.getHokenryou();
                        Map<CurrencyType, BizCurrency> sumHokenryou = new HashMap<>();
                        if (koujyosyoumeipKbn != null) {

                                if (!syouhnTokujouTkjypMap.containsKey(koujyosyoumeipKbn)) {

                                        if (syouhnTokujou.getTkjyp() != null) {

                                                typeTkjyp = syouhnTokujou.getTkjyp().getType();
                                                sumTkjyp.put(typeTkjyp, syouhnTokujou.getTkjyp());

                    }
                                        syouhnTokujouTkjypMap.put(koujyosyoumeipKbn, sumTkjyp);

                                        if (kykSyouhn.getHokenryou() != null) {

                                                typeHokenryou = kykSyouhn.getHokenryou().getType();
                                                sumHokenryou.put(typeHokenryou, kykSyouhn.getHokenryou());

                    }
                                        kykSyouhnHokenryouMap.put(koujyosyoumeipKbn, sumHokenryou);

                }
                else {

                                        sumTkjyp = syouhnTokujouTkjypMap.get(koujyosyoumeipKbn);
                                        valTkjyp = syouhnTokujou.getTkjyp();
                                        if (valTkjyp != null) {
                                                typeTkjyp = syouhnTokujou.getTkjyp().getType();
                                                if (!sumTkjyp.containsKey(typeTkjyp)) {
                                                        sumTkjyp.put(typeTkjyp, valTkjyp);

                        } else {
                                                        sumTkjyp.put(typeTkjyp, sumTkjyp.get(typeTkjyp).add(valTkjyp));
                        }
                                                syouhnTokujouTkjypMap.put(koujyosyoumeipKbn, sumTkjyp);
                    }
                                        sumHokenryou = kykSyouhnHokenryouMap.get(koujyosyoumeipKbn);
                                        valHokenryou = kykSyouhn.getHokenryou();
                                        if (valHokenryou != null) {
                                                typeHokenryou = kykSyouhn.getHokenryou().getType();
                                                if (!sumHokenryou.containsKey(typeHokenryou)) {
                                                        sumHokenryou.put(typeHokenryou, valHokenryou);

                        } else {
                                                        sumHokenryou.put(typeHokenryou, sumHokenryou.get(typeHokenryou).add(valHokenryou));
                        }
                                                kykSyouhnHokenryouMap.put(koujyosyoumeipKbn, sumHokenryou);
                    }
                }
            }
        }
        for (C_KoujyosyoumeipKbn koujyosyoumeipKbn : kykSyouhnHokenryouMap.keySet()) {
                        objLst.add(new Object[] { koujyosyoumeipKbn, kykSyouhnHokenryouMap.get(koujyosyoumeipKbn),
                syouhnTokujouTkjypMap.get(koujyosyoumeipKbn) });
        }
        return objLst;
    }
    @Transient
    public  List<IT_KykSyouhn> getKykSyouhnsBySyutkkbn(C_SyutkKbn pSyutkkbn) {
        return new ArrayList<IT_KykSyouhn>(Collections2.filter(getKykSyouhns(),
            new FilterKykSyouhnBySyutkkbn(pSyutkkbn)));
    }
    @Transient
    public  IT_SyouhnTokujou getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        return Iterables.getFirst(Iterables.filter(getSyouhnTokujous(),
            new FilterSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(pSyutkkbn, pSyouhncd, pSyouhnsdno,
                pKyksyouhnrenno)), null);
    }
    @Transient
    public  List<IT_SyouhnTokujou> getSyouhnTokujousBySyutkkbn(C_SyutkKbn pSyutkkbn) {
        return new ArrayList<IT_SyouhnTokujou>(Collections2.filter(getSyouhnTokujous(),
            new FilterSyouhnTokujouBySyutkkbn(pSyutkkbn)));
    }
    @Transient
    public  IT_KykUkt getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn pUktsyukbn,Integer pUktsyurenno) {
        return Iterables.getFirst(Iterables.filter(getKykUkts(),
            new FilterKykUktByUktsyukbnUktsyurenno(pUktsyukbn, pUktsyurenno)), null);
    }
    @Transient
    public  List<IT_KykUkt> getKykUktsByUktsyukbn(C_UktsyuKbn pUktsyukbn) {
        return new ArrayList<IT_KykUkt>(Collections2.filter(getKykUkts(),
            new FilterKykUktByUktsyukbn(pUktsyukbn)));
    }
    @Transient
    public  IT_KoujyoSymKanri getKoujyoSymKanriByNendo(String pNendo) {
        return Iterables.getFirst(Iterables.filter(getKoujyoSymKanris(),
            new FilterKoujyoSymKanriByNendo(pNendo)), null);
    }
    @Transient
    public  List<IT_YykIdouUktk> getYykIdouUktksByYykidousyorikbn(C_YykidousyoriKbn pYykidousyorikbn) {
        return new ArrayList<IT_YykIdouUktk>(Collections2.filter(getYykIdouUktks(),
            new FilterYykIdouUktkByYykidousyorikbn(pYykidousyorikbn)));
    }
    @Transient
    public  IT_YykIdouNaiyoHrhnk getYykIdouNaiyoHrhnkByHenkousikibetukey(String pHenkousikibetukey) {
        return Iterables.getFirst(Iterables.filter(getYykIdouNaiyoHrhnks(),
            new FilterYykIdouNaiyoHrhnkByHenkousikibetukey(pHenkousikibetukey)), null);
    }
    @Transient
    public  IT_KykDairiten getKykDairitenByDrtenrenno(Integer pDrtenrenno) {
        return Iterables.getFirst(Iterables.filter(getKykDairitens(), new FilterKykDairitenByDrtenrenno(pDrtenrenno)), null);
    }
    @Transient
    public  IT_FatcaInfo getFatcaInfoByRenno(Integer pRenno) {
        return Iterables.getFirst(Iterables.filter(getFatcaInfos(), new FilterFatcaInfoByRenno(pRenno)), null);
    }
    @Transient
    public  Map<CurrencyType, BizCurrency> getKariukekinSumKrkgkByKrkseisanzumiflg(C_Krkseisanzumiflg pKrkseisanzumiflg) {
        
        List<IT_Kariukekin> kariukekinLst = new ArrayList<IT_Kariukekin>(Collections2.filter(getKariukekins(),
            new FilterKariukekinByKrkseisanzumiflg(pKrkseisanzumiflg)));

                Map<CurrencyType, BizCurrency> sumKrkgk = new HashMap<>();

                BizCurrency krkgkTmp = null;

                CurrencyType type = null;

        for (IT_Kariukekin kariukekin : kariukekinLst) {

                        krkgkTmp = kariukekin.getKrkgk();

            if (krkgkTmp != null) {

                                type = krkgkTmp.getType();

                if (!sumKrkgk.containsKey(type)) {

                                        sumKrkgk.put(type, krkgkTmp);
                } else {

                                        sumKrkgk.put(type, sumKrkgk.get(type).add(krkgkTmp));
                }
            }
        }
                return sumKrkgk;
    }
    @Transient
    public  NyknJissekiRirekiByNyktrksflgBean getNyknJissekiRirekiByNyktrksflg(C_Nyktrksflg pNyktrksflg) {
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = new ArrayList<IT_NyknJissekiRireki>(Collections2.filter(
            getNyknJissekiRirekis(), new FilterNyknJissekiRirekiByNyktrksflgEq(pNyktrksflg)));
                NyknJissekiRirekiByNyktrksflgBean nyknJissekiRirekiByNyktrksflgBean = new NyknJissekiRirekiByNyktrksflgBean();
                Map<CurrencyType, BizCurrency> sumRsgakuMap = new HashMap<>();
                Map<CurrencyType, BizCurrency> sumYenkansannyknkingkMap = new HashMap<>();
                BizCurrency rsgakuTmp = null;
                BizCurrency yenkansannyknkingkTmp = null;
                CurrencyType type = null;
                String syono = "";

        for (IT_NyknJissekiRireki nyknJissekiRireki : nyknJissekiRirekiLst) {
                        syono = nyknJissekiRireki.getSyono();

                        rsgakuTmp = nyknJissekiRireki.getRsgaku();
                        if (rsgakuTmp != null) {

                                type = rsgakuTmp.getType();

                                if (!sumRsgakuMap.containsKey(type)) {

                                        sumRsgakuMap.put(type, rsgakuTmp);
                } else {

                                        sumRsgakuMap.put(type, sumRsgakuMap.get(type).add(rsgakuTmp));
                }
            }

                        yenkansannyknkingkTmp = nyknJissekiRireki.getYenkansannyknkingk();
                        if (yenkansannyknkingkTmp != null) {

                                type = yenkansannyknkingkTmp.getType();

                                if (!sumYenkansannyknkingkMap.containsKey(type)) {

                                        sumYenkansannyknkingkMap.put(type, yenkansannyknkingkTmp);
                } else {

                                        sumYenkansannyknkingkMap.put(type, sumYenkansannyknkingkMap.get(type).add(yenkansannyknkingkTmp));
                }
            }

        }
                nyknJissekiRirekiByNyktrksflgBean.setSyono(syono);

                nyknJissekiRirekiByNyktrksflgBean.setSumRsgaku(sumRsgakuMap);

                nyknJissekiRirekiByNyktrksflgBean.setSumYenkansannyknkingk(sumYenkansannyknkingkMap);

        return nyknJissekiRirekiByNyktrksflgBean;
    }
    @Transient
    public  IT_NyknJissekiRireki getNyknJissekiRirekiByJyutoustartymRenno(BizDateYM pJyutoustartym,Integer pRenno) {
        return Iterables.getFirst(Iterables.filter(getNyknJissekiRirekis(),
            new FilterNyknJissekiRirekiByJyutoustartymRenno(pJyutoustartym, pRenno)), null);
    }
    @Transient
    public  List<IT_NyknJissekiRireki> getNyknJissekiRirekisByNykkeiroNyktrksflg(C_Nykkeiro pNykkeiro,C_Nyktrksflg pNyktrksflg) {
        return new ArrayList<IT_NyknJissekiRireki>(Collections2.filter(getNyknJissekiRirekis(),
            new FilterNyknJissekiRirekiByNykkeiroNyktrksflg(pNykkeiro, pNyktrksflg)));
    }
    @Transient
    public  List<IT_NyknJissekiRireki> getNyknJissekiRirekisByJyutoustartym(BizDateYM pJyutoustartym) {
        return new ArrayList<IT_NyknJissekiRireki>(Collections2.filter(getNyknJissekiRirekis(),
            new FilterNyknJissekiRirekiByJyutoustartym(pJyutoustartym)));
    }
    @Transient
    public  List<IT_NyknJissekiRireki> getNyknJissekiRirekisByJyutouymNyktrksflg(BizDateYM pKeisannkizyunnbi,C_Nyktrksflg pNyktrksflg) {
        return new ArrayList<IT_NyknJissekiRireki>(Collections2.filter(getNyknJissekiRirekis(),
            new FilterNyknJissekiRirekiByJyutouymNyktrksflg(pKeisannkizyunnbi, pNyktrksflg)));
    }
    @Transient
    public  List<IT_NyknJissekiRireki> getNyknJissekiRirekisByJyutoustartymNyktrksflg(BizDateYM pJyutoustartym) {
        return new ArrayList<IT_NyknJissekiRireki>(Collections2.filter(getNyknJissekiRirekis(),
            new FilterNyknJissekiRirekiByJyutoustartymNyktrksflg(pJyutoustartym)));
    }
    @Transient
    public  List<IT_NyknJissekiRireki> getNyknJissekiRirekisByNyktrksflg(C_Nyktrksflg pNyktrksflg) {
        return new ArrayList<IT_NyknJissekiRireki>(Collections2.filter(getNyknJissekiRirekis(),
            new FilterNyknJissekiRirekiByNyktrksflg(pNyktrksflg)));
    }
    @Transient
    public  List<IT_Kariukekin> getKariukekinsByKrkseisanzumiflgNyknaiyoukbn(C_Krkseisanzumiflg pKrkseisanzumiflg,C_NyknaiyouKbn pNyknaiyoukbn) {
        return new ArrayList<IT_Kariukekin>(Collections2.filter(getKariukekins(),
            new FilterKariukekinByKrkseisanzumiflgNyknaiyoukbn(pKrkseisanzumiflg, pNyknaiyoukbn)));
    }
    @Transient
    public  List<IT_NyknJissekiRireki> getNyknJissekiRirekisByNykkeiro(C_Nykkeiro pNykkeiro) {
        return new ArrayList<IT_NyknJissekiRireki>(Collections2.filter(getNyknJissekiRirekis(),
            new FilterNyknJissekiRirekiByNykkeiro(pNykkeiro)));
    }
    @Transient
    public  List<IT_NyknJissekiRireki> getNyknJissekiRirekisByTukitanityokugooutoymNyktrksflg(BizDateYM pTukitanityokugooutoym) {
        return new ArrayList<IT_NyknJissekiRireki>(Collections2.filter(getNyknJissekiRirekis(),
            new FilterNyknJissekiRirekiByTukitanityokugooutoymNyktrksflg(pTukitanityokugooutoym)));
    }
    @Transient
    public  List<IT_NyknJissekiRireki> getNyknJissekiRirekisByJyutouendymJyutoustartymNyktrksflg(BizDateYM pJyutouendym,BizDateYM pJyutoustartym,C_Nyktrksflg pNyktrksflg) {
        return new ArrayList<IT_NyknJissekiRireki>(Collections2.filter(getNyknJissekiRirekis(),
            new FilterNyknJissekiRirekiByJyutouendymJyutoustartymNyktrksflg(pJyutouendym, pJyutoustartym, pNyktrksflg)));
    }
    @Transient
    public  SumNyknJissekiRirekiBean getSumNyknJissekiRirekiBeanByNyktrksflgNe(C_Nyktrksflg pNyktrksflg) {
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = new ArrayList<IT_NyknJissekiRireki>(Collections2.filter(getNyknJissekiRirekis(),
            new FilterNyknJissekiRirekiByNyktrksflg(pNyktrksflg)));

                SumNyknJissekiRirekiBean sumNyknJissekiRirekiBean = new SumNyknJissekiRirekiBean();
                Map<CurrencyType, BizCurrency> sumHrkp = new HashMap<>();
                Map<CurrencyType, BizCurrency> sumYenkansannyknkingk = new HashMap<>();
                Map<CurrencyType, BizCurrency> sumRsgaku = new HashMap<>();
                BizCurrency hrkpTmp = null;
                BizCurrency yenkansannyknkingkTmp = null;
                BizCurrency rsgakuTmp = null;
                CurrencyType type = null;

        for (IT_NyknJissekiRireki nyknJissekiRireki : nyknJissekiRirekiLst) {

                        hrkpTmp = nyknJissekiRireki.getHrkp();
                        if (hrkpTmp != null) {

                                type = hrkpTmp.getType();

                                if (!sumHrkp.containsKey(type)) {

                                        sumHrkp.put(type, hrkpTmp);
                } else {

                                        sumHrkp.put(type, sumHrkp.get(type).add(hrkpTmp));
                }
            }

                        yenkansannyknkingkTmp = nyknJissekiRireki.getYenkansannyknkingk();
                        if (yenkansannyknkingkTmp != null) {

                                type = yenkansannyknkingkTmp.getType();

                                if (!sumYenkansannyknkingk.containsKey(type)) {

                                        sumYenkansannyknkingk.put(type, yenkansannyknkingkTmp);
                } else {

                                        sumYenkansannyknkingk.put(type, sumYenkansannyknkingk.get(type).add(yenkansannyknkingkTmp));
                }
            }

                        rsgakuTmp = nyknJissekiRireki.getRsgaku();
                        if (rsgakuTmp != null) {

                                type = rsgakuTmp.getType();

                                if (!sumRsgaku.containsKey(type)) {

                                        sumRsgaku.put(type, rsgakuTmp);
                } else {

                                        sumRsgaku.put(type, sumRsgaku.get(type).add(rsgakuTmp));
                }
            }
        }

                sumNyknJissekiRirekiBean.setSumHrkp(sumHrkp);

                sumNyknJissekiRirekiBean.setSumYenkansannyknkingk(sumYenkansannyknkingk);

                sumNyknJissekiRirekiBean.setSumRsgaku(sumRsgaku);

        return sumNyknJissekiRirekiBean;
    }
    @Transient
    public  List<SumKihrkmpSeisanRirekiBean> getSumKihrkmpSeisanRirekiBeans() {
                List<IT_KihrkmpSeisanRireki> kihrkmpSeisanRirekiLst = getKihrkmpSeisanRirekis();

        List<SumKihrkmpSeisanRirekiBean> sumKihrkmpSeisanRirekiBeanLst = new ArrayList<>();

                Map<C_MisyuumikeikaKbn, Map<CurrencyType, BizCurrency>> seisanpgoukeiMap = new HashMap<>();

                Map<C_MisyuumikeikaKbn, Map<CurrencyType, BizCurrency>> yenkansansspgoukeiMap = new HashMap<>();

                BizCurrency seisanpgoukeiTmp = null;
                BizCurrency yenkansansspgoukeiTmp = null;
                CurrencyType type = null;

        for (IT_KihrkmpSeisanRireki kihrkmpSeisanRireki : kihrkmpSeisanRirekiLst) {

                        C_MisyuumikeikaKbn misyuumikeikakbn = kihrkmpSeisanRireki.getMisyuumikeikakbn();

                        Map<CurrencyType, BizCurrency> sumSeisanpgoukei = new HashMap<>();
                        Map<CurrencyType, BizCurrency> sumYenkansansspgoukei = new HashMap<>();
                        if (misyuumikeikakbn != null) {

                                if (!seisanpgoukeiMap.containsKey(misyuumikeikakbn)) {

                                        if (kihrkmpSeisanRireki.getSeisanpgoukei() != null) {

                                                type = kihrkmpSeisanRireki.getSeisanpgoukei().getType();
                                                sumSeisanpgoukei.put(type, kihrkmpSeisanRireki.getSeisanpgoukei());

                    }
                                        seisanpgoukeiMap.put(misyuumikeikakbn, sumSeisanpgoukei);

                                        if (kihrkmpSeisanRireki.getYenkansansspgoukei() != null) {

                                                type = kihrkmpSeisanRireki.getYenkansansspgoukei().getType();

                                                sumYenkansansspgoukei.put(type, kihrkmpSeisanRireki.getYenkansansspgoukei());

                    }
                                        yenkansansspgoukeiMap.put(misyuumikeikakbn, sumYenkansansspgoukei);

                }
                else {

                                        sumSeisanpgoukei = seisanpgoukeiMap.get(misyuumikeikakbn);
                                        seisanpgoukeiTmp = kihrkmpSeisanRireki.getSeisanpgoukei();
                                        if (seisanpgoukeiTmp != null) {
                                                type = kihrkmpSeisanRireki.getSeisanpgoukei().getType();
                                                if (!sumSeisanpgoukei.containsKey(type)) {
                                                        sumSeisanpgoukei.put(type, seisanpgoukeiTmp);

                        } else {
                                                        sumSeisanpgoukei.put(type, sumSeisanpgoukei.get(type).add(seisanpgoukeiTmp));
                        }
                                                seisanpgoukeiMap.put(misyuumikeikakbn, sumSeisanpgoukei);
                    }

                                        sumYenkansansspgoukei = yenkansansspgoukeiMap.get(misyuumikeikakbn);
                                        yenkansansspgoukeiTmp = kihrkmpSeisanRireki.getYenkansansspgoukei();
                                        if (yenkansansspgoukeiTmp != null) {
                                                type = kihrkmpSeisanRireki.getYenkansansspgoukei().getType();
                                                if (!sumYenkansansspgoukei.containsKey(type)) {
                                                        sumYenkansansspgoukei.put(type, yenkansansspgoukeiTmp);

                        } else {
                                                        sumYenkansansspgoukei.put(type, sumYenkansansspgoukei.get(type)
                                .add(yenkansansspgoukeiTmp));
                        }
                                                yenkansansspgoukeiMap.put(misyuumikeikakbn, sumYenkansansspgoukei);
                    }

                }

            }
        }

        for (C_MisyuumikeikaKbn misyuumikeikaKbn : seisanpgoukeiMap.keySet()) {

                        SumKihrkmpSeisanRirekiBean sumKihrkmpSeisanRirekiBean = new SumKihrkmpSeisanRirekiBean();
                        sumKihrkmpSeisanRirekiBean.setMisyuumikeikakbn(misyuumikeikaKbn);
                        sumKihrkmpSeisanRirekiBean.setSumSeisanpgoukei(seisanpgoukeiMap.get(misyuumikeikaKbn));
                        sumKihrkmpSeisanRirekiBean.setSumYenkansansspgoukei(yenkansansspgoukeiMap.get(misyuumikeikaKbn));

            sumKihrkmpSeisanRirekiBeanLst.add(sumKihrkmpSeisanRirekiBean);

        }

        return sumKihrkmpSeisanRirekiBeanLst;
    }
    @Transient
    public  SumKihrkmpSeisanRirekiBean getSumKihrkmpSeisanRirekiBean() {
        List<IT_KihrkmpSeisanRireki> kihrkmpSeisanRirekiLst = getKihrkmpSeisanRirekis();
                SumKihrkmpSeisanRirekiBean sumKihrkmpSeisanRirekiBean = new SumKihrkmpSeisanRirekiBean();
                Map<CurrencyType, BizCurrency> sumYenkansanhenkankin = new HashMap<>();
                BizCurrency yenkansanhenkankinTmp = null;
                Map<CurrencyType, BizCurrency> sumYenkansantuityoukin = new HashMap<>();
                BizCurrency yenkansantuityoukinTmp = null;
                CurrencyType type = null;

        for (IT_KihrkmpSeisanRireki kihrkmpSeisanRireki : kihrkmpSeisanRirekiLst) {

                        yenkansanhenkankinTmp = kihrkmpSeisanRireki.getYenkansanhenkankin();
                        if (yenkansanhenkankinTmp != null) {

                                type = yenkansanhenkankinTmp.getType();

                                if (!sumYenkansanhenkankin.containsKey(type)) {

                                        sumYenkansanhenkankin.put(type, yenkansanhenkankinTmp);
                } else {

                                        sumYenkansanhenkankin.put(type, sumYenkansanhenkankin.get(type).add(yenkansanhenkankinTmp));
                }
            }

                        yenkansantuityoukinTmp = kihrkmpSeisanRireki.getYenkansantuityoukin();
                        if (yenkansantuityoukinTmp != null) {

                                type = yenkansantuityoukinTmp.getType();

                                if (!sumYenkansantuityoukin.containsKey(type)) {

                                        sumYenkansantuityoukin.put(type, yenkansantuityoukinTmp);
                } else {

                                        sumYenkansantuityoukin.put(type, sumYenkansantuityoukin.get(type).add(yenkansantuityoukinTmp));
                }

            }

        }

                sumKihrkmpSeisanRirekiBean.setSumYenkansanhenkankin(sumYenkansanhenkankin);
                sumKihrkmpSeisanRirekiBean.setSumYenkansantuityoukin(sumYenkansantuityoukin);

        return sumKihrkmpSeisanRirekiBean;
    }
    @Transient
    public  List<IT_KoujyoSymNaiyou> getKoujyoSymNaiyousByKoujyosyoumeinndKjsmhakkouzumiflg(String pKoujyosyoumeinnd,C_Kjsmhakkouzumiflg pKjsmhakkouzumiflg) {
        return new ArrayList<IT_KoujyoSymNaiyou>(Collections2.filter(getKoujyoSymNaiyous(),
            new FilterKoujyoSymNaiyouByKoujyosyoumeinndKjsmhakkouzumiflg(pKoujyosyoumeinnd, pKjsmhakkouzumiflg)));
    }
    @Transient
    public  List<Object[]> getKoujyoSymNaiyouKoujyosyoumeipkbnSumKoujyosyoumeigks() {
                        List<Object[]> objLst = new ArrayList<>();

                List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = getKoujyoSymNaiyous();

                Map<C_KoujyosyoumeipKbn, Map<CurrencyType, BizCurrency>> koujyosyoumeigkMap = new HashMap<>();

                BizCurrency koujyosyoumeigkTmp = null;
                CurrencyType type = null;

                for (IT_KoujyoSymNaiyou koujyoSymNaiyou : koujyoSymNaiyouLst) {

                        C_KoujyosyoumeipKbn koujyosyoumeipKbn = koujyoSymNaiyou.getKoujyosyoumeipkbn();
                        Map<CurrencyType, BizCurrency> sumKoujyosyoumeigk = new HashMap<>();
                        if (koujyosyoumeipKbn != null) {

                                if (!koujyosyoumeigkMap.containsKey(koujyosyoumeipKbn)) {

                                        if (koujyoSymNaiyou.getKoujyosyoumeigk() != null) {

                                                type = koujyoSymNaiyou.getKoujyosyoumeigk().getType();
                                                sumKoujyosyoumeigk.put(type, koujyoSymNaiyou.getKoujyosyoumeigk());

                    }
                                        koujyosyoumeigkMap.put(koujyosyoumeipKbn, sumKoujyosyoumeigk);

                } else {

                                        sumKoujyosyoumeigk = koujyosyoumeigkMap.get(koujyosyoumeipKbn);
                                        koujyosyoumeigkTmp = koujyoSymNaiyou.getKoujyosyoumeigk();
                                        if (koujyosyoumeigkTmp != null) {
                                                type = koujyoSymNaiyou.getKoujyosyoumeigk().getType();
                                                if (!sumKoujyosyoumeigk.containsKey(type)) {
                                                        sumKoujyosyoumeigk.put(type, koujyosyoumeigkTmp);

                        } else {
                                                        sumKoujyosyoumeigk.put(type, sumKoujyosyoumeigk.get(type).add(koujyosyoumeigkTmp));
                        }
                                                koujyosyoumeigkMap.put(koujyosyoumeipKbn, sumKoujyosyoumeigk);
                    }
                }
            }
        }

        for (C_KoujyosyoumeipKbn koujyosyoumeipKbn1 : koujyosyoumeigkMap.keySet()) {
                        objLst.add(new Object[] { koujyosyoumeipKbn1, koujyosyoumeigkMap.get(koujyosyoumeipKbn1) });

        }
        return objLst;
    }
    @Transient
    public  List<IT_KhTtdkRireki> getKhTtdkRirekisByGyoumuKousinKinou(String pGyoumuKousinKinou) {
        return new ArrayList<IT_KhTtdkRireki>(Collections2.filter(getKhTtdkRirekis(),
            new FilterKhTtdkRirekiByGyoumuKousinKinou(pGyoumuKousinKinou)));
    }
    @Transient
    public  List<IT_KhTtdkRireki> getKhTtdkRirekisByGyoumuKousinKinouNe(String pGyoumuKousinKinou) {
        return new ArrayList<IT_KhTtdkRireki>(Collections2.filter(getKhTtdkRirekis(),
            new FilterKhTtdkRirekiByGyoumuKousinKinouNe(pGyoumuKousinKinou)));
    }
    @Transient
    public  IT_KhTtdkRireki getKhTtdkRirekiByHenkousikibetukey(String pHenkousikibetukey) {
        return Iterables.getFirst(Iterables.filter(getKhTtdkRirekis(),
            new FilterKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey)), null);
    }
    @Transient
    public  List<IT_KhTtdkRireki> getKhTtdkRirekisBySyoriYmdGyoumuKousinKinou(BizDate pSyoriYmd,String pGyoumuKousinKinou) {
        return new ArrayList<IT_KhTtdkRireki>(Collections2.filter(getKhTtdkRirekis(),
            new FilterKhTtdkRirekiBySyoriYmdGyoumuKousinKinou(pSyoriYmd, pGyoumuKousinKinou)));
    }
    @Transient
    public  List<IT_KhTtdkRireki> getKhTtdkRirekisByHenkousikibetukey(String pHenkousikibetukey) {
        return new ArrayList<IT_KhTtdkRireki>(Collections2.filter(getKhTtdkRirekis(),
            new FilterKhTtdkRirekiByHenkousikibetukeyGt(pHenkousikibetukey)));
    }
    @Transient
    public  List<IT_Tesuuryou> getTesuuryousByTsrysyorikbnRenno(C_TsrysyoriKbn pTsrysyorikbn,Integer pRenno) {
        return new ArrayList<IT_Tesuuryou>(Collections2.filter(getTesuuryous(),
            new FilterTesuuryouByTsrysyorikbnRenno(pTsrysyorikbn, pRenno)));
    }
    @Transient
    public  IT_KoujyoSym getKoujyoSymByNnendoTyouhyouymdRennoEq(String pNendo,BizDate pTyouhyouymd) {
        return Iterables.getFirst(Iterables.filter(getKoujyoSyms(), new FilterKoujyoSymByNnendoTyouhyouymdRennoEq(pNendo, pTyouhyouymd)), null);
    }
    @Transient
    public  List<IT_KoujyoSym> getKoujyoSymsByNendoRenno(String pNendo,Integer pRenno) {
        return new ArrayList<IT_KoujyoSym>(Collections2.filter(getKoujyoSyms(),
            new FilterKoujyoSymByNendoRenno(pNendo, pRenno)));
    }
    @Transient
    public  List<IT_TtdkKan> getTtdkKansByTyouhyouymd(BizDate pTyouhyouymd) {
        return new ArrayList<IT_TtdkKan>(Collections2.filter(getTtdkKans(),
            new FilterTtdkKanByTyouhyouymd(pTyouhyouymd)));
    }
    @Transient
    public  IT_TtdkKan getTtdkKanByHenkousikibetukey(String pHenkousikibetukey) {
        return Iterables.getFirst(Iterables.filter(getTtdkKans(),
            new FilterTtdkKanByHenkousikibetukey(pHenkousikibetukey)), null);
    }
    @Transient
    public  IT_HokenSyouken getHokenSyoukenByTyouhyouymd(BizDate pTyouhyouymd) {
        return Iterables.getFirst(Iterables.filter(getHokenSyoukens(),
            new FilterHokenSyoukenByTyouhyouymd(pTyouhyouymd)), null);
    }
    @Transient
    public  List<IT_Suiihyou> getSuiihyousByTyouhyouymd(BizDate pTyouhyouymd) {
        return new ArrayList<IT_Suiihyou>(Collections2.filter(getSuiihyous(),
            new FilterSuiihyouByTyouhyouymd(pTyouhyouymd)));
    }
    @Transient
    public  List<IT_KykSyouhn> getKykSyouhnsByYuukousyoumetukbnKykjyoutai(C_YuukousyoumetuKbn pYuukousyoumetukbn,C_Kykjyoutai pKykjyoutai) {
        return new ArrayList<IT_KykSyouhn>(Collections2.filter(getKykSyouhns(),
            new FilterKykSyouhnByYuukousyoumetukbnKykjyoutai(pYuukousyoumetukbn, pKykjyoutai)));
    }
    @Transient
    public  List<IT_NyknJissekiRireki> getNyknJissekiRirekisByJyutouendymNyktrksflg(BizDateYM pHrkkym,BizDateYM pJkipjytym,C_Nyktrksflg pNyktrksflg) {
        return new ArrayList<IT_NyknJissekiRireki>(Collections2.filter(getNyknJissekiRirekis(),
            new FilterNyknJissekiRirekiByHrkkymJkipjytymNyktrksflg(pHrkkym, pJkipjytym, pNyktrksflg)));
    }
    @Transient
    public  IT_AeoiInfo getAeoiInfoByRenno(Integer pRenno) {
        return Iterables.getFirst(Iterables.filter(getAeoiInfos(),
            new FilterAeoiInfoByRenno(pRenno)), null);
    }

    private List<IT_HrhnTtdkKan> iT_HrhnTtdkKans = Lists.newLinkedList();
    public IT_HrhnTtdkKan createHrhnTtdkKan() {
        IT_HrhnTtdkKan hrhnTtdkKan =  new IT_HrhnTtdkKan();
        hrhnTtdkKan.setKykKihon(this);
        hrhnTtdkKan.setKbnkey(this.getKbnkey());
        hrhnTtdkKan.setSyono(this.getSyono());
        getHrhnTtdkKans().add(hrhnTtdkKan);
        return hrhnTtdkKan;
    }
    public void setHrhnTtdkKans(List<IT_HrhnTtdkKan> pIT_HrhnTtdkKans) {
        this.iT_HrhnTtdkKans = pIT_HrhnTtdkKans;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_HrhnTtdkKan.SYONO+" ASC ,"+IT_HrhnTtdkKan.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_HrhnTtdkKan> getHrhnTtdkKans() {
        return iT_HrhnTtdkKans;
    }

    private List<IT_HurikaeYousi> iT_HurikaeYousis = Lists.newLinkedList();
    public IT_HurikaeYousi createHurikaeYousi() {
        IT_HurikaeYousi hurikaeYousi =  new IT_HurikaeYousi();
        hurikaeYousi.setKykKihon(this);
        hurikaeYousi.setKbnkey(this.getKbnkey());
        hurikaeYousi.setSyono(this.getSyono());
        getHurikaeYousis().add(hurikaeYousi);
        return hurikaeYousi;
    }
    public void setHurikaeYousis(List<IT_HurikaeYousi> pIT_HurikaeYousis) {
        this.iT_HurikaeYousis = pIT_HurikaeYousis;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_HurikaeYousi.SYONO+" ASC ,"+IT_HurikaeYousi.HENKOUSIKIBETUKEY+" ASC ")
    public  List<IT_HurikaeYousi> getHurikaeYousis() {
        return iT_HurikaeYousis;
    }

    private List<IT_KouzaHnknTuuti> iT_KouzaHnknTuutis = Lists.newLinkedList();
    public IT_KouzaHnknTuuti createKouzaHnknTuuti() {
        IT_KouzaHnknTuuti kouzaHnknTuuti =  new IT_KouzaHnknTuuti();
        kouzaHnknTuuti.setKykKihon(this);
        kouzaHnknTuuti.setKbnkey(this.getKbnkey());
        kouzaHnknTuuti.setSyono(this.getSyono());
        getKouzaHnknTuutis().add(kouzaHnknTuuti);
        return kouzaHnknTuuti;
    }
    public void setKouzaHnknTuutis(List<IT_KouzaHnknTuuti> pIT_KouzaHnknTuutis) {
        this.iT_KouzaHnknTuutis = pIT_KouzaHnknTuutis;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KouzaHnknTuuti.SYONO+" ASC ,"+IT_KouzaHnknTuuti.DENRENNO+" ASC ,"+IT_KouzaHnknTuuti.EDANO+" ASC ")
    public  List<IT_KouzaHnknTuuti> getKouzaHnknTuutis() {
        return iT_KouzaHnknTuutis;
    }

    private List<IT_KouzaHrkmTuuti> iT_KouzaHrkmTuutis = Lists.newLinkedList();
    public IT_KouzaHrkmTuuti createKouzaHrkmTuuti() {
        IT_KouzaHrkmTuuti kouzaHrkmTuuti =  new IT_KouzaHrkmTuuti();
        kouzaHrkmTuuti.setKykKihon(this);
        kouzaHrkmTuuti.setKbnkey(this.getKbnkey());
        kouzaHrkmTuuti.setSyono(this.getSyono());
        getKouzaHrkmTuutis().add(kouzaHrkmTuuti);
        return kouzaHrkmTuuti;
    }
    public void setKouzaHrkmTuutis(List<IT_KouzaHrkmTuuti> pIT_KouzaHrkmTuutis) {
        this.iT_KouzaHrkmTuutis = pIT_KouzaHrkmTuutis;
    }
    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_KouzaHrkmTuuti.SYONO+" ASC ,"+IT_KouzaHrkmTuuti.KRKNO+" ASC ")
    public  List<IT_KouzaHrkmTuuti> getKouzaHrkmTuutis() {
        return iT_KouzaHrkmTuutis;
    }

    @Transient
    public  IT_TrkKzk getTrkKzkByTrkKzkKbn(C_TrkKzkKbn pTrkkzkkbn) {
        return Iterables.getFirst(Iterables.filter(getTrkKzks(),
            new FilterTrkKzkByTrkKzkKbn(pTrkkzkkbn)), null);
    }

    private List<IT_CreditHnknTuuti> iT_CreditHnknTuutis = Lists.newLinkedList();

    public IT_CreditHnknTuuti createCreditHnknTuuti() {
        IT_CreditHnknTuuti creditHnknTuuti =  new IT_CreditHnknTuuti();
        creditHnknTuuti.setKykKihon(this);
        creditHnknTuuti.setKbnkey(this.getKbnkey());
        creditHnknTuuti.setSyono(this.getSyono());
        getCreditHnknTuutis().add(creditHnknTuuti);
        return creditHnknTuuti;
    }

    public void setCreditHnknTuutis(List<IT_CreditHnknTuuti> pIT_CreditHnknTuutis) {
        this.iT_CreditHnknTuutis = pIT_CreditHnknTuutis;
    }

    @OneToMany (
        mappedBy = "kykKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(IT_CreditHnknTuuti.SYONO+" ASC ,"+IT_CreditHnknTuuti.DENRENNO+" ASC ,"+IT_CreditHnknTuuti.EDANO+" ASC ")
    public  List<IT_CreditHnknTuuti> getCreditHnknTuutis() {
        return iT_CreditHnknTuutis;
    }

}

