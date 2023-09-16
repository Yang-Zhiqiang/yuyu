package yuyu.def.db.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.db.mapping.GenMT_DsKokyakuKanri;
import yuyu.def.direct.predicate.FilterDsHaisinErrorListByDsdatasakuseiymd;
import yuyu.def.direct.predicate.FilterDsHaisinErrorListByDsmailaddressrenban;
import yuyu.def.direct.predicate.FilterDsKokyakuKeiyakuByDskykmukouhyj;
import yuyu.def.direct.predicate.FilterDsKokyakuKeiyakuBySyono;
import yuyu.def.direct.predicate.FilterDsKokyakuKeiyakuBySyonoDskykmukouhyj;
import yuyu.def.direct.predicate.FilterDsMailAddressByDsmailaddressrenban;
import yuyu.def.direct.predicate.FilterDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban;
import yuyu.def.direct.predicate.FilterDsMailHaisinRirekiByDsdatasakuseiymd;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * ＤＳ顧客管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsKokyakuKanri} の JavaDoc を参照してください。<br />
 * @see     GenMT_DsKokyakuKanri<br />
 * @see     PKMT_DsKokyakuKanri<br />
 * @see     QMT_DsKokyakuKanri<br />
 * @see     GenQMT_DsKokyakuKanri<br />
 */
@Entity
public class MT_DsKokyakuKanri extends GenMT_DsKokyakuKanri {

    private static final long serialVersionUID = 1L;

    public MT_DsKokyakuKanri() {
    }

    public MT_DsKokyakuKanri(String pDskokno) {
        super(pDskokno);
    }



    private List<MT_DsHonninKakuninCd> mT_DsHonninKakuninCds = Lists.newLinkedList();
    public MT_DsHonninKakuninCd createDsHonninKakuninCd() {
        MT_DsHonninKakuninCd dsHonninKakuninCd =  new MT_DsHonninKakuninCd();
        dsHonninKakuninCd.setDsKokyakuKanri(this);
        dsHonninKakuninCd.setDskokno(this.getDskokno());
        setDsHonninKakuninCd(dsHonninKakuninCd);
        return dsHonninKakuninCd;
    }
    @Transient
    public  MT_DsHonninKakuninCd getDsHonninKakuninCd() {
        requiredEntities(getDsHonninKakuninCds(),MT_DsHonninKakuninCd.class);
        if(getDsHonninKakuninCds().size() == 0) {
            return null;
        }
        return getDsHonninKakuninCds().get(0);
    }
    @Transient
    public void setDsHonninKakuninCd(MT_DsHonninKakuninCd pMT_DsHonninKakuninCd) {
        if(this.getDsHonninKakuninCds().size() >0){
            this.getDsHonninKakuninCds().set(0, pMT_DsHonninKakuninCd) ;
        }else{
            this.getDsHonninKakuninCds().add(pMT_DsHonninKakuninCd) ;
        }
    }
    public void setDsHonninKakuninCds(List<MT_DsHonninKakuninCd> pMT_DsHonninKakuninCds) {
        this.mT_DsHonninKakuninCds = pMT_DsHonninKakuninCds;
    }
    @OneToMany (
        mappedBy = "dsKokyakuKanri",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(MT_DsHonninKakuninCd.DSKOKNO+" ASC ")
    public  List<MT_DsHonninKakuninCd> getDsHonninKakuninCds() {
        return mT_DsHonninKakuninCds;
    }

    private List<MT_DsKokyakuKeiyaku> mT_DsKokyakuKeiyakus = Lists.newLinkedList();
    public MT_DsKokyakuKeiyaku createDsKokyakuKeiyaku() {
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku =  new MT_DsKokyakuKeiyaku();
        dsKokyakuKeiyaku.setDsKokyakuKanri(this);
        dsKokyakuKeiyaku.setDskokno(this.getDskokno());
        getDsKokyakuKeiyakus().add(dsKokyakuKeiyaku);
        return dsKokyakuKeiyaku;
    }
    public void setDsKokyakuKeiyakus(List<MT_DsKokyakuKeiyaku> pMT_DsKokyakuKeiyakus) {
        this.mT_DsKokyakuKeiyakus = pMT_DsKokyakuKeiyakus;
    }
    @OneToMany (
        mappedBy = "dsKokyakuKanri",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(MT_DsKokyakuKeiyaku.DSKOKNO+" ASC ,"+MT_DsKokyakuKeiyaku.SYONO+" ASC ")
    public  List<MT_DsKokyakuKeiyaku> getDsKokyakuKeiyakus() {
        return mT_DsKokyakuKeiyakus;
    }

    private List<MT_DsLoginKanri> mT_DsLoginKanris = Lists.newLinkedList();
    public MT_DsLoginKanri createDsLoginKanri() {
        MT_DsLoginKanri dsLoginKanri =  new MT_DsLoginKanri();
        dsLoginKanri.setDsKokyakuKanri(this);
        dsLoginKanri.setDskokno(this.getDskokno());
        setDsLoginKanri(dsLoginKanri);
        return dsLoginKanri;
    }
    @Transient
    public  MT_DsLoginKanri getDsLoginKanri() {
        requiredEntities(getDsLoginKanris(),MT_DsLoginKanri.class);
        if(getDsLoginKanris().size() == 0) {
            return null;
        }
        return getDsLoginKanris().get(0);
    }
    @Transient
    public void setDsLoginKanri(MT_DsLoginKanri pMT_DsLoginKanri) {
        if(this.getDsLoginKanris().size() >0){
            this.getDsLoginKanris().set(0, pMT_DsLoginKanri) ;
        }else{
            this.getDsLoginKanris().add(pMT_DsLoginKanri) ;
        }
    }
    public void setDsLoginKanris(List<MT_DsLoginKanri> pMT_DsLoginKanris) {
        this.mT_DsLoginKanris = pMT_DsLoginKanris;
    }
    @OneToMany (
        mappedBy = "dsKokyakuKanri",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(MT_DsLoginKanri.DSKOKNO+" ASC ")
    public  List<MT_DsLoginKanri> getDsLoginKanris() {
        return mT_DsLoginKanris;
    }

    private List<MT_DsTtdkRireki> mT_DsTtdkRirekis = Lists.newLinkedList();
    public MT_DsTtdkRireki createDsTtdkRireki() {
        MT_DsTtdkRireki dsTtdkRireki =  new MT_DsTtdkRireki();
        dsTtdkRireki.setDsKokyakuKanri(this);
        dsTtdkRireki.setDskokno(this.getDskokno());
        getDsTtdkRirekis().add(dsTtdkRireki);
        return dsTtdkRireki;
    }
    public void setDsTtdkRirekis(List<MT_DsTtdkRireki> pMT_DsTtdkRirekis) {
        this.mT_DsTtdkRirekis = pMT_DsTtdkRirekis;
    }
    @OneToMany (
        mappedBy = "dsKokyakuKanri",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(MT_DsTtdkRireki.DSKOKNO+" ASC ,"+MT_DsTtdkRireki.HENKOUSIKIBETUKEY+" ASC ")
    public  List<MT_DsTtdkRireki> getDsTtdkRirekis() {
        return mT_DsTtdkRirekis;
    }

    private List<MT_DsMailAddress> mT_DsMailAddresss = Lists.newLinkedList();
    public MT_DsMailAddress createDsMailAddress() {
        MT_DsMailAddress dsMailAddress =  new MT_DsMailAddress();
        dsMailAddress.setDsKokyakuKanri(this);
        dsMailAddress.setDskokno(this.getDskokno());
        getDsMailAddresss().add(dsMailAddress);
        return dsMailAddress;
    }
    public void setDsMailAddresss(List<MT_DsMailAddress> pMT_DsMailAddresss) {
        this.mT_DsMailAddresss = pMT_DsMailAddresss;
    }
    @OneToMany (
        mappedBy = "dsKokyakuKanri",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(MT_DsMailAddress.DSKOKNO+" ASC ,"+MT_DsMailAddress.DSMAILADDRESSRENBAN+" ASC ")
    public  List<MT_DsMailAddress> getDsMailAddresss() {
        return mT_DsMailAddresss;
    }

    private List<MT_DsMailAddressSpiralYyk> mT_DsMailAddressSpiralYyks = Lists.newLinkedList();
    public MT_DsMailAddressSpiralYyk createDsMailAddressSpiralYyk() {
        MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk =  new MT_DsMailAddressSpiralYyk();
        dsMailAddressSpiralYyk.setDsKokyakuKanri(this);
        dsMailAddressSpiralYyk.setDskokno(this.getDskokno());
        getDsMailAddressSpiralYyks().add(dsMailAddressSpiralYyk);
        return dsMailAddressSpiralYyk;
    }
    public void setDsMailAddressSpiralYyks(List<MT_DsMailAddressSpiralYyk> pMT_DsMailAddressSpiralYyks) {
        this.mT_DsMailAddressSpiralYyks = pMT_DsMailAddressSpiralYyks;
    }
    @OneToMany (
        mappedBy = "dsKokyakuKanri",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(MT_DsMailAddressSpiralYyk.DSDATASAKUSEIYMD+" ASC ,"+MT_DsMailAddressSpiralYyk.DSKOKNO+" ASC ,"+MT_DsMailAddressSpiralYyk.DSMAILADDRESSRENBAN+" ASC ")
    public  List<MT_DsMailAddressSpiralYyk> getDsMailAddressSpiralYyks() {
        return mT_DsMailAddressSpiralYyks;
    }

    private List<MT_DsHanyouKokyakuateTuuti> mT_DsHanyouKokyakuateTuutis = Lists.newLinkedList();
    public MT_DsHanyouKokyakuateTuuti createDsHanyouKokyakuateTuuti() {
        MT_DsHanyouKokyakuateTuuti dsHanyouKokyakuateTuuti =  new MT_DsHanyouKokyakuateTuuti();
        dsHanyouKokyakuateTuuti.setDsKokyakuKanri(this);
        dsHanyouKokyakuateTuuti.setDskokno(this.getDskokno());
        getDsHanyouKokyakuateTuutis().add(dsHanyouKokyakuateTuuti);
        return dsHanyouKokyakuateTuuti;
    }
    public void setDsHanyouKokyakuateTuutis(List<MT_DsHanyouKokyakuateTuuti> pMT_DsHanyouKokyakuateTuutis) {
        this.mT_DsHanyouKokyakuateTuutis = pMT_DsHanyouKokyakuateTuutis;
    }
    @OneToMany (
        mappedBy = "dsKokyakuKanri",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(MT_DsHanyouKokyakuateTuuti.DSDATASAKUSEIYMD+" ASC ,"+MT_DsHanyouKokyakuateTuuti.DSKOKNO+" ASC ,"+MT_DsHanyouKokyakuateTuuti.DSHANYOUKOKYAKUATETUUTIKBN+" ASC ")
    public  List<MT_DsHanyouKokyakuateTuuti> getDsHanyouKokyakuateTuutis() {
        return mT_DsHanyouKokyakuateTuutis;
    }

    private List<MT_DsHaisinErrorList> mT_DsHaisinErrorLists = Lists.newLinkedList();
    public MT_DsHaisinErrorList createDsHaisinErrorList() {
        MT_DsHaisinErrorList dsHaisinErrorList =  new MT_DsHaisinErrorList();
        dsHaisinErrorList.setDsKokyakuKanri(this);
        dsHaisinErrorList.setDskokno(this.getDskokno());
        getDsHaisinErrorLists().add(dsHaisinErrorList);
        return dsHaisinErrorList;
    }
    public void setDsHaisinErrorLists(List<MT_DsHaisinErrorList> pMT_DsHaisinErrorLists) {
        this.mT_DsHaisinErrorLists = pMT_DsHaisinErrorLists;
    }
    @OneToMany (
        mappedBy = "dsKokyakuKanri",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(MT_DsHaisinErrorList.DSDATASAKUSEIYMD+" ASC ,"+MT_DsHaisinErrorList.DSKOKNO+" ASC ,"+MT_DsHaisinErrorList.DSMAILADDRESSRENBAN+" ASC ")
    public  List<MT_DsHaisinErrorList> getDsHaisinErrorLists() {
        return mT_DsHaisinErrorLists;
    }

    private List<MT_DsMailHaisinRireki> mT_DsMailHaisinRirekis = Lists.newLinkedList();
    public MT_DsMailHaisinRireki createDsMailHaisinRireki() {
        MT_DsMailHaisinRireki dsMailHaisinRireki =  new MT_DsMailHaisinRireki();
        dsMailHaisinRireki.setDsKokyakuKanri(this);
        dsMailHaisinRireki.setDskokno(this.getDskokno());
        getDsMailHaisinRirekis().add(dsMailHaisinRireki);
        return dsMailHaisinRireki;
    }
    public void setDsMailHaisinRirekis(List<MT_DsMailHaisinRireki> pMT_DsMailHaisinRirekis) {
        this.mT_DsMailHaisinRirekis = pMT_DsMailHaisinRirekis;
    }
    @OneToMany (
        mappedBy = "dsKokyakuKanri",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(MT_DsMailHaisinRireki.DSDATASAKUSEIYMD+" ASC ,"+MT_DsMailHaisinRireki.DSKOKNO+" ASC ,"+MT_DsMailHaisinRireki.DSMAILHAISINRENBAN+" ASC ")
    public  List<MT_DsMailHaisinRireki> getDsMailHaisinRirekis() {
        return mT_DsMailHaisinRirekis;
    }

    private List<MT_DsHaisinErrorList2> mT_DsHaisinErrorList2s = Lists.newLinkedList();
    public MT_DsHaisinErrorList2 createDsHaisinErrorList2() {
        MT_DsHaisinErrorList2 dsHaisinErrorList2 =  new MT_DsHaisinErrorList2();
        dsHaisinErrorList2.setDsKokyakuKanri(this);
        dsHaisinErrorList2.setDskokno(this.getDskokno());
        getDsHaisinErrorList2s().add(dsHaisinErrorList2);
        return dsHaisinErrorList2;
    }
    public void setDsHaisinErrorList2s(List<MT_DsHaisinErrorList2> pMT_DsHaisinErrorList2s) {
        this.mT_DsHaisinErrorList2s = pMT_DsHaisinErrorList2s;
    }
    @OneToMany (
        mappedBy = "dsKokyakuKanri",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(MT_DsHaisinErrorList2.DSDATASAKUSEIYMD+" ASC ,"+MT_DsHaisinErrorList2.DSMAILHAISINRENBAN+" ASC ")
    public  List<MT_DsHaisinErrorList2> getDsHaisinErrorList2s() {
        return mT_DsHaisinErrorList2s;
    }

    private List<MT_DsHanyouKokyakuateTuuti2> mT_DsHanyouKokyakuateTuuti2s = Lists.newLinkedList();
    public MT_DsHanyouKokyakuateTuuti2 createDsHanyouKokyakuateTuuti2() {
        MT_DsHanyouKokyakuateTuuti2 dsHanyouKokyakuateTuuti2 =  new MT_DsHanyouKokyakuateTuuti2();
        dsHanyouKokyakuateTuuti2.setDsKokyakuKanri(this);
        dsHanyouKokyakuateTuuti2.setDskokno(this.getDskokno());
        getDsHanyouKokyakuateTuuti2s().add(dsHanyouKokyakuateTuuti2);
        return dsHanyouKokyakuateTuuti2;
    }
    public void setDsHanyouKokyakuateTuuti2s(List<MT_DsHanyouKokyakuateTuuti2> pMT_DsHanyouKokyakuateTuuti2s) {
        this.mT_DsHanyouKokyakuateTuuti2s = pMT_DsHanyouKokyakuateTuuti2s;
    }
    @OneToMany (
        mappedBy = "dsKokyakuKanri",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
        @OrderBy(MT_DsHanyouKokyakuateTuuti2.DSDATASAKUSEIYMD+" ASC ,"+MT_DsHanyouKokyakuateTuuti2.DSKOKTUUTIRENNO+" ASC ,"+MT_DsHanyouKokyakuateTuuti2.DSKOKNO+" ASC ,"+MT_DsHanyouKokyakuateTuuti2.DSHANYOUKOKYAKUATETUUTIKBN+" ASC ")
    public  List<MT_DsHanyouKokyakuateTuuti2> getDsHanyouKokyakuateTuuti2s() {
        return mT_DsHanyouKokyakuateTuuti2s;
    }

    @Transient
    public  List<MT_DsKokyakuKeiyaku> getDsKokyakuKeiyakusBySyonoDskykmukouhyj(String pSyono) {
        return new ArrayList<MT_DsKokyakuKeiyaku>(Collections2.filter(getDsKokyakuKeiyakus(),
            new FilterDsKokyakuKeiyakuBySyonoDskykmukouhyj(pSyono)));
    }
    @Transient
    public  MT_DsKokyakuKeiyaku getDsKokyakuKeiyakuBySyono(String pSyono) {
        return Iterables.getFirst(Iterables.filter(getDsKokyakuKeiyakus(),
            new FilterDsKokyakuKeiyakuBySyono(pSyono)), null);
    }
    @Transient
    public  List<MT_DsKokyakuKeiyaku> getDsKokyakuKeiyakusByDskykmukouhyj(C_MukouHyj pDskykmukouhyj) {
        return new ArrayList<MT_DsKokyakuKeiyaku>(Collections2.filter(getDsKokyakuKeiyakus(),
            new FilterDsKokyakuKeiyakuByDskykmukouhyj(pDskykmukouhyj)));
    }
    @Transient
    public  MT_DsMailAddress getDsMailAddressByDsmailaddressrenban(Integer pDsmailaddressrenban) {
        return Iterables.getFirst(Iterables.filter(getDsMailAddresss(),
            new FilterDsMailAddressByDsmailaddressrenban(pDsmailaddressrenban)), null);
    }
    @Transient
    public  MT_DsMailAddressSpiralYyk getDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban(BizDate pDsdatasakuseiymd,Integer pDsmailaddressrenban) {
        return Iterables.getFirst(Iterables.filter(getDsMailAddressSpiralYyks(),
            new FilterDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban(pDsdatasakuseiymd, pDsmailaddressrenban)), null);
    }
    @Transient
    public  List<MT_DsHaisinErrorList> getDsHaisinErrorListsByDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {
        return new ArrayList<MT_DsHaisinErrorList>(Collections2.filter(getDsHaisinErrorLists(),
            new FilterDsHaisinErrorListByDsdatasakuseiymd(pDsdatasakuseiymd)));
    }
    @Transient
    public  List<MT_DsHaisinErrorList> getDsHaisinErrorListsByDsmailaddressrenban(Integer pDsmailaddressrenban) {
        return new ArrayList<MT_DsHaisinErrorList>(Collections2.filter(getDsHaisinErrorLists(),
            new FilterDsHaisinErrorListByDsmailaddressrenban(pDsmailaddressrenban)));
    }
    @Transient
    public  List<MT_DsMailHaisinRireki> getDsMailHaisinRirekisByDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {
        return new ArrayList<MT_DsMailHaisinRireki>(Collections2.filter(getDsMailHaisinRirekis(),
            new FilterDsMailHaisinRirekiByDsdatasakuseiymd(pDsdatasakuseiymd)));
    }
}

