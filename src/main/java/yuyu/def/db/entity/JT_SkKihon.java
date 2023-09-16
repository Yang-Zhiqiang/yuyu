package yuyu.def.db.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.mapping.GenJT_SkKihon;
import yuyu.def.siharai.predicate.FilterSateiSyouninRirekiByKossyorisscdSyorikekkakbns;
import yuyu.def.siharai.predicate.FilterSateiSyouninRirekiBySateisyouninskbtkey;
import yuyu.def.siharai.predicate.FilterSateiSyouninRirekiBySeikyuurirekino;
import yuyu.def.siharai.predicate.FilterSateiSyouninRirekiBySyorikekkakbnKossyorisscd;
import yuyu.def.siharai.predicate.FilterSateiSyouninRirekiBySyorikekkakbnKossyorisscds;
import yuyu.def.siharai.predicate.FilterSiRirekiBySeikyuurirekino;
import yuyu.def.siharai.predicate.FilterSiRirekiByShrsikibetukey;
import yuyu.def.siharai.predicate.FilterSiRirekiByShrsyoriymd;
import yuyu.def.siharai.predicate.FilterSibouKariuketsukeByTorikesiflg;
import yuyu.def.siharai.predicate.FilterSkBySeikyuurirekino;
import yuyu.def.siharai.predicate.FilterTtdkRirekiByShrsikibetukey;
import yuyu.def.siharai.predicate.FilterTtdkRirekiByTtdkrrkskbtkey;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


/**
 * 請求基本テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SkKihon} の JavaDoc を参照してください。<br />
 * @see     GenJT_SkKihon<br />
 * @see     PKJT_SkKihon<br />
 * @see     QJT_SkKihon<br />
 * @see     GenQJT_SkKihon<br />
 */
@Entity
public class JT_SkKihon extends GenJT_SkKihon {

    private static final long serialVersionUID = 1L;

    public JT_SkKihon() {
    }

    public JT_SkKihon(String pSkno,String pSyono) {
        super(pSkno,pSyono);
    }



    private List<JT_Sk> jT_Sks = Lists.newLinkedList();
    public JT_Sk createSk() {
        JT_Sk sk =  new JT_Sk();
        sk.setSkKihon(this);
        sk.setSkno(this.getSkno());
        sk.setSyono(this.getSyono());
        getSks().add(sk);
        return sk;
    }
    public void setSks(List<JT_Sk> pJT_Sks) {
        this.jT_Sks = pJT_Sks;
    }
    @OneToMany (
        mappedBy = "skKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_Sk.SKNO+" ASC ,"+JT_Sk.SYONO+" ASC ,"+JT_Sk.SEIKYUURIREKINO+" ASC ")
    public  List<JT_Sk> getSks() {
        return jT_Sks;
    }

    private List<JT_Mouside> jT_Mousides = Lists.newLinkedList();
    public JT_Mouside createMouside() {
        JT_Mouside mouside =  new JT_Mouside();
        mouside.setSkKihon(this);
        mouside.setSkno(this.getSkno());
        mouside.setSyono(this.getSyono());
        setMouside(mouside);
        return mouside;
    }
    @Transient
    public  JT_Mouside getMouside() {
        if(getMousides().size() == 0) {
            return null;
        }
        return getMousides().get(0);
    }
    @Transient
    public void setMouside(JT_Mouside pJT_Mouside) {
        if(this.getMousides().size() >0){
            this.getMousides().set(0, pJT_Mouside) ;
        }else{
            this.getMousides().add(pJT_Mouside) ;
        }
    }
    public void setMousides(List<JT_Mouside> pJT_Mousides) {
        this.jT_Mousides = pJT_Mousides;
    }
    @OneToMany (
        mappedBy = "skKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_Mouside.SKNO+" ASC ,"+JT_Mouside.SYONO+" ASC ")
    public  List<JT_Mouside> getMousides() {
        return jT_Mousides;
    }

    private List<JT_SiRireki> jT_SiRirekis = Lists.newLinkedList();
    public JT_SiRireki createSiRireki() {
        JT_SiRireki siRireki =  new JT_SiRireki();
        siRireki.setSkKihon(this);
        siRireki.setSkno(this.getSkno());
        siRireki.setSyono(this.getSyono());
        getSiRirekis().add(siRireki);
        return siRireki;
    }
    public void setSiRirekis(List<JT_SiRireki> pJT_SiRirekis) {
        this.jT_SiRirekis = pJT_SiRirekis;
    }
    @OneToMany (
        mappedBy = "skKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_SiRireki.SKNO+" ASC ,"+JT_SiRireki.SYONO+" ASC ,"+JT_SiRireki.SHRSIKIBETUKEY+" ASC ")
    public  List<JT_SiRireki> getSiRirekis() {
        return jT_SiRirekis;
    }

    private List<JT_TtdkRireki> jT_TtdkRirekis = Lists.newLinkedList();
    public JT_TtdkRireki createTtdkRireki() {
        JT_TtdkRireki ttdkRireki =  new JT_TtdkRireki();
        ttdkRireki.setSkKihon(this);
        ttdkRireki.setSkno(this.getSkno());
        ttdkRireki.setSyono(this.getSyono());
        getTtdkRirekis().add(ttdkRireki);
        return ttdkRireki;
    }
    public void setTtdkRirekis(List<JT_TtdkRireki> pJT_TtdkRirekis) {
        this.jT_TtdkRirekis = pJT_TtdkRirekis;
    }
    @OneToMany (
        mappedBy = "skKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_TtdkRireki.SKNO+" ASC ,"+JT_TtdkRireki.SYONO+" ASC ,"+JT_TtdkRireki.TTDKRRKSKBTKEY+" ASC ")
    public  List<JT_TtdkRireki> getTtdkRirekis() {
        return jT_TtdkRirekis;
    }

    private List<JT_SateiSyouninRireki> jT_SateiSyouninRirekis = Lists.newLinkedList();
    public JT_SateiSyouninRireki createSateiSyouninRireki() {
        JT_SateiSyouninRireki sateiSyouninRireki =  new JT_SateiSyouninRireki();
        sateiSyouninRireki.setSkKihon(this);
        sateiSyouninRireki.setSkno(this.getSkno());
        sateiSyouninRireki.setSyono(this.getSyono());
        getSateiSyouninRirekis().add(sateiSyouninRireki);
        return sateiSyouninRireki;
    }
    public void setSateiSyouninRirekis(List<JT_SateiSyouninRireki> pJT_SateiSyouninRirekis) {
        this.jT_SateiSyouninRirekis = pJT_SateiSyouninRirekis;
    }
    @OneToMany (
        mappedBy = "skKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_SateiSyouninRireki.SKNO+" ASC ,"+JT_SateiSyouninRireki.SYONO+" ASC ,"+JT_SateiSyouninRireki.SATEISYOUNINSKBTKEY+" ASC ")
    public  List<JT_SateiSyouninRireki> getSateiSyouninRirekis() {
        return jT_SateiSyouninRirekis;
    }

    private List<JT_SibouKariuketsuke> jT_SibouKariuketsukes = Lists.newLinkedList();
    public JT_SibouKariuketsuke createSibouKariuketsuke() {
        JT_SibouKariuketsuke sibouKariuketsuke =  new JT_SibouKariuketsuke();
        sibouKariuketsuke.setSkKihon(this);
        sibouKariuketsuke.setSkno(this.getSkno());
        sibouKariuketsuke.setSyono(this.getSyono());
        setSibouKariuketsuke(sibouKariuketsuke);
        return sibouKariuketsuke;
    }
    @Transient
    public  JT_SibouKariuketsuke getSibouKariuketsuke() {
        if(getSibouKariuketsukes().size() == 0) {
            return null;
        }
        return getSibouKariuketsukes().get(0);
    }
    @Transient
    public void setSibouKariuketsuke(JT_SibouKariuketsuke pJT_SibouKariuketsuke) {
        if(this.getSibouKariuketsukes().size() >0){
            this.getSibouKariuketsukes().set(0, pJT_SibouKariuketsuke) ;
        }else{
            this.getSibouKariuketsukes().add(pJT_SibouKariuketsuke) ;
        }
    }
    public void setSibouKariuketsukes(List<JT_SibouKariuketsuke> pJT_SibouKariuketsukes) {
        this.jT_SibouKariuketsukes = pJT_SibouKariuketsukes;
    }
    @OneToMany (
        mappedBy = "skKihon",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_SibouKariuketsuke.SKNO+" ASC ,"+JT_SibouKariuketsuke.SYONO+" ASC ")
    public  List<JT_SibouKariuketsuke> getSibouKariuketsukes() {
        return jT_SibouKariuketsukes;
    }

    @Transient
    public  JT_Sk getSkBySeikyuurirekino(Integer pSeikyuurirekino) {
        return Iterables.getFirst(Iterables.filter(getSks(),
            new FilterSkBySeikyuurirekino(pSeikyuurirekino)), null);
    }
    @Transient
    public  JT_SiRireki getSiRirekiByShrsikibetukey(String pShrsikibetukey) {
        return Iterables.getFirst(Iterables.filter(getSiRirekis(),
            new FilterSiRirekiByShrsikibetukey(pShrsikibetukey)), null);
    }
    @Transient
    public  List<JT_SiRireki> getSiRirekisBySeikyuurirekino(Integer pSeikyuurirekino) {
        return new ArrayList<JT_SiRireki>(Collections2.filter(getSiRirekis(),
            new FilterSiRirekiBySeikyuurirekino(pSeikyuurirekino)));
    }
    @Transient
    public  List<JT_SiRireki> getSiRirekisByShrsyoriymd(BizDate pkijyunymd) {
        return new ArrayList<JT_SiRireki>(Collections2.filter(getSiRirekis(),
            new FilterSiRirekiByShrsyoriymd(pkijyunymd)));
    }
    @Transient
    public  JT_TtdkRireki getTtdkRirekByTtdkrrkskbtkey(String pTtdkrrkskbtkey) {
        return Iterables.getFirst(Iterables.filter(getTtdkRirekis(),
            new FilterTtdkRirekiByTtdkrrkskbtkey(pTtdkrrkskbtkey)), null);
    }
    @Transient
    public  JT_TtdkRireki getTtdkRirekiByTtdkrrkskbtkey(String pTtdkrrkskbtkey) {
        return Iterables.getFirst(Iterables.filter(getTtdkRirekis(),
            new FilterTtdkRirekiByTtdkrrkskbtkey(pTtdkrrkskbtkey)), null);
    }
    @Transient
    public  List<JT_TtdkRireki> getTtdkRirekisByShrsikibetukey(String pShrsikibetukey) {
        return new ArrayList<JT_TtdkRireki>(Collections2.filter(getTtdkRirekis(),
            new FilterTtdkRirekiByShrsikibetukey(pShrsikibetukey)));
    }
    @Transient
    public  List<JT_SateiSyouninRireki> getSateiSyouninRirekisBySeikyuurirekino(Integer pSeikyuurirekino) {
        return new ArrayList<JT_SateiSyouninRireki>(Collections2.filter(getSateiSyouninRirekis(),
            new FilterSateiSyouninRirekiBySeikyuurirekino(pSeikyuurirekino)));
    }
    @Transient
    public  JT_SateiSyouninRireki getSateiSyouninRirekiBySateisyouninskbtkey(String pSateisyouninskbtkey) {
        return Iterables.getFirst(Iterables.filter(getSateiSyouninRirekis(),
            new FilterSateiSyouninRirekiBySateisyouninskbtkey(pSateisyouninskbtkey)), null);
    }
    @Transient
    public  List<JT_SateiSyouninRireki> getSateiSyouninRirekisBySyorikekkakbnKossyorisscd(C_SyorikekkaKbn pSyorikekkakbn,String pKossyorisscd) {
        return new ArrayList<JT_SateiSyouninRireki>(Collections2.filter(getSateiSyouninRirekis(),
            new FilterSateiSyouninRirekiBySyorikekkakbnKossyorisscd(pSyorikekkakbn, pKossyorisscd)));
    }
    @Transient
    public  List<JT_SateiSyouninRireki> getSateiSyouninRirekisByKossyorisscdSyorikekkakbns(String pKossyorisscd, C_SyorikekkaKbn... pSyorikekkakbn) {
        return new ArrayList<JT_SateiSyouninRireki>(Collections2.filter(getSateiSyouninRirekis(),
            new FilterSateiSyouninRirekiByKossyorisscdSyorikekkakbns(pKossyorisscd, pSyorikekkakbn)));
    }
    @Transient
    public  List<JT_SateiSyouninRireki> getSateiSyouninRirekisBySyorikekkakbnKossyorisscds(C_SyorikekkaKbn pSyorikekkakbn,String[] pKossyorisscd) {
        return new ArrayList<JT_SateiSyouninRireki>(Collections2.filter(getSateiSyouninRirekis(),
            new FilterSateiSyouninRirekiBySyorikekkakbnKossyorisscds(pSyorikekkakbn, pKossyorisscd)));
    }
    @Transient
    public  List<JT_SibouKariuketsuke> getSibouKariuketsukesByTorikesiflg(C_UmuKbn pTorikesiflg) {
        return new ArrayList<JT_SibouKariuketsuke>(Collections2.filter(getSibouKariuketsukes(),
            new FilterSibouKariuketsukeByTorikesiflg(pTorikesiflg)));
    }
}

