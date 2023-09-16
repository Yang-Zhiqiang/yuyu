package yuyu.def.db.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.mapping.GenHT_SkHubi;
import yuyu.def.sinkeiyaku.predicate.FilterSkHubiDetailByHasinymd;
import yuyu.def.sinkeiyaku.predicate.FilterSkHubiDetailByHasinymdNull;
import yuyu.def.sinkeiyaku.predicate.FilterSkHubiDetailByKaisyouymd;
import yuyu.def.sinkeiyaku.predicate.FilterSkHubiDetailByTrkymdNotNull;
import yuyu.def.sinkeiyaku.predicate.FilterSkHubiDetailsByHasinymdKaisyouymd;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;


/**
 * 新契約不備テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SkHubi} の JavaDoc を参照してください。<br />
 * @see     GenHT_SkHubi<br />
 * @see     PKHT_SkHubi<br />
 * @see     QHT_SkHubi<br />
 * @see     GenQHT_SkHubi<br />
 */
@Entity
public class HT_SkHubi extends GenHT_SkHubi {

    private static final long serialVersionUID = 1L;

    public HT_SkHubi() {
    }

    public HT_SkHubi(String pMosno,String pHubisikibetukey) {
        super(pMosno,pHubisikibetukey);
    }



    private List<HT_SkHubiDetail> hT_SkHubiDetails = Lists.newLinkedList();
    public HT_SkHubiDetail createSkHubiDetail() {
        HT_SkHubiDetail skHubiDetail =  new HT_SkHubiDetail();
        skHubiDetail.setSkHubi(this);
        skHubiDetail.setMosno(this.getMosno());
        skHubiDetail.setHubisikibetukey(this.getHubisikibetukey());
        getSkHubiDetails().add(skHubiDetail);
        return skHubiDetail;
    }
    public void setSkHubiDetails(List<HT_SkHubiDetail> pHT_SkHubiDetails) {
        this.hT_SkHubiDetails = pHT_SkHubiDetails;
    }
    @OneToMany (
        mappedBy = "skHubi",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(HT_SkHubiDetail.MOSNO+" ASC ,"+HT_SkHubiDetail.HUBISIKIBETUKEY+" ASC ,"+HT_SkHubiDetail.RENNO3KETA+" ASC ")
    public  List<HT_SkHubiDetail> getSkHubiDetails() {
        return hT_SkHubiDetails;
    }

    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_SkHubi.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

    @Transient
    public  List<HT_SkHubiDetail> getSkHubiDetailsByHasinymdKaisyouymd() {
        return new ArrayList<HT_SkHubiDetail>(Collections2.filter(getSkHubiDetails(),
            new FilterSkHubiDetailsByHasinymdKaisyouymd()));
    }
    @Transient
    public  List<HT_SkHubiDetail> getSkHubiDetailsByKaisyouymd(BizDate pKaisyouymd) {
        return new ArrayList<HT_SkHubiDetail>(Collections2.filter(getSkHubiDetails(),
            new FilterSkHubiDetailByKaisyouymd(pKaisyouymd)));
    }
    @Transient
    public  List<HT_SkHubiDetail> getSkHubiDetailsByHasinymd() {
        return new ArrayList<HT_SkHubiDetail>(Collections2.filter(getSkHubiDetails(),
            new FilterSkHubiDetailByHasinymd()));
    }
    @Transient
    public  List<HT_SkHubiDetail> getSkHubiDetailsByHasinymdNull() {
        return new ArrayList<HT_SkHubiDetail>(Collections2.filter(getSkHubiDetails(),
            new FilterSkHubiDetailByHasinymdNull()));
    }
    @Transient
    public  List<HT_SkHubiDetail> getSkHubiDetailsByTrkymdNotNull() {
        return new ArrayList<HT_SkHubiDetail>(Collections2.filter(getSkHubiDetails(),
            new FilterSkHubiDetailByTrkymdNotNull()));
    }
}

