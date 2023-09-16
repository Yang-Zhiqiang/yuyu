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

import yuyu.def.db.mapping.GenJT_SkJiyuu;
import yuyu.def.siharai.predicate.FilterSiDetailByKyhkg;
import yuyu.def.siharai.predicate.FilterSiDetailByKyhkgNe;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;


/**
 * 請求事由テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SkJiyuu} の JavaDoc を参照してください。<br />
 * @see     GenJT_SkJiyuu<br />
 * @see     PKJT_SkJiyuu<br />
 * @see     QJT_SkJiyuu<br />
 * @see     GenQJT_SkJiyuu<br />
 */
@Entity
public class JT_SkJiyuu extends GenJT_SkJiyuu {

    private static final long serialVersionUID = 1L;

    public JT_SkJiyuu() {
    }

    public JT_SkJiyuu(String pSkno,String pSyono,Integer pSeikyuurirekino,Integer pUketukeno) {
        super(pSkno,pSyono,pSeikyuurirekino,pUketukeno);
    }



    private JT_Sk jT_Sk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_SkJiyuu.SKNO  , referencedColumnName=JT_Sk.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SkJiyuu.SYONO  , referencedColumnName=JT_Sk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SkJiyuu.SEIKYUURIREKINO  , referencedColumnName=JT_Sk.SEIKYUURIREKINO, insertable=false, updatable=false)
    })
    public JT_Sk getSk() {
        return jT_Sk;
    }

    public void setSk(JT_Sk pJT_Sk) {
        this.jT_Sk = pJT_Sk;
    }

    private List<JT_SkByoumei> jT_SkByoumeis = Lists.newLinkedList();
    public JT_SkByoumei createSkByoumei() {
        JT_SkByoumei skByoumei =  new JT_SkByoumei();
        skByoumei.setSkJiyuu(this);
        skByoumei.setSkno(this.getSkno());
        skByoumei.setSyono(this.getSyono());
        skByoumei.setSeikyuurirekino(this.getSeikyuurirekino());
        skByoumei.setUketukeno(this.getUketukeno());
        getSkByoumeis().add(skByoumei);
        return skByoumei;
    }
    public void setSkByoumeis(List<JT_SkByoumei> pJT_SkByoumeis) {
        this.jT_SkByoumeis = pJT_SkByoumeis;
    }
    @OneToMany (
        mappedBy = "skJiyuu",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_SkByoumei.SKNO+" ASC ,"+JT_SkByoumei.SYONO+" ASC ,"+JT_SkByoumei.SEIKYUURIREKINO+" ASC ,"+JT_SkByoumei.UKETUKENO+" ASC ,"+JT_SkByoumei.RENNO+" ASC ")
    public  List<JT_SkByoumei> getSkByoumeis() {
        return jT_SkByoumeis;
    }

    private List<JT_SkKkn> jT_SkKkns = Lists.newLinkedList();
    public JT_SkKkn createSkKkn() {
        JT_SkKkn skKkn =  new JT_SkKkn();
        skKkn.setSkJiyuu(this);
        skKkn.setSkno(this.getSkno());
        skKkn.setSyono(this.getSyono());
        skKkn.setSeikyuurirekino(this.getSeikyuurirekino());
        skKkn.setUketukeno(this.getUketukeno());
        getSkKkns().add(skKkn);
        return skKkn;
    }
    public void setSkKkns(List<JT_SkKkn> pJT_SkKkns) {
        this.jT_SkKkns = pJT_SkKkns;
    }
    @OneToMany (
        mappedBy = "skJiyuu",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_SkKkn.SKNO+" ASC ,"+JT_SkKkn.SYONO+" ASC ,"+JT_SkKkn.SEIKYUURIREKINO+" ASC ,"+JT_SkKkn.UKETUKENO+" ASC ,"+JT_SkKkn.KYUUHUKBN+" ASC ,"+JT_SkKkn.RENNO+" ASC ")
    public  List<JT_SkKkn> getSkKkns() {
        return jT_SkKkns;
    }

    private List<JT_SiDetail> jT_SiDetails = Lists.newLinkedList();
    public JT_SiDetail createSiDetail() {
        JT_SiDetail siDetail =  new JT_SiDetail();
        siDetail.setSkJiyuu(this);
        siDetail.setSkno(this.getSkno());
        siDetail.setSyono(this.getSyono());
        siDetail.setSeikyuurirekino(this.getSeikyuurirekino());
        siDetail.setUketukeno(this.getUketukeno());
        getSiDetails().add(siDetail);
        return siDetail;
    }
    public void setSiDetails(List<JT_SiDetail> pJT_SiDetails) {
        this.jT_SiDetails = pJT_SiDetails;
    }
    @OneToMany (
        mappedBy = "skJiyuu",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_SiDetail.SKNO+" ASC ,"+JT_SiDetail.SYONO+" ASC ,"+JT_SiDetail.SEIKYUURIREKINO+" ASC ,"+JT_SiDetail.UKETUKENO+" ASC ,"+JT_SiDetail.SYUTKKBN+" ASC ,"+JT_SiDetail.SYOUHNCD+" ASC ,"+JT_SiDetail.KYHGNDKATAKBN+" ASC ,"+JT_SiDetail.SYOUHNSDNO+" ASC ,"+JT_SiDetail.KYKSYOUHNRENNO+" ASC ,"+JT_SiDetail.KYUUHUCD+" ASC ,"+JT_SiDetail.RENNO+" ASC ")
    public  List<JT_SiDetail> getSiDetails() {
        return jT_SiDetails;
    }

    private List<JT_SiDetailKkn> jT_SiDetailKkns = Lists.newLinkedList();
    public JT_SiDetailKkn createSiDetailKkn() {
        JT_SiDetailKkn siDetailKkn =  new JT_SiDetailKkn();
        siDetailKkn.setSkJiyuu(this);
        siDetailKkn.setSkno(this.getSkno());
        siDetailKkn.setSyono(this.getSyono());
        siDetailKkn.setSeikyuurirekino(this.getSeikyuurirekino());
        siDetailKkn.setUketukeno(this.getUketukeno());
        getSiDetailKkns().add(siDetailKkn);
        return siDetailKkn;
    }
    public void setSiDetailKkns(List<JT_SiDetailKkn> pJT_SiDetailKkns) {
        this.jT_SiDetailKkns = pJT_SiDetailKkns;
    }
    @OneToMany (
        mappedBy = "skJiyuu",
        cascade = { CascadeType.ALL },
        orphanRemoval = true
        )
    @OrderBy(JT_SiDetailKkn.SKNO+" ASC ,"+JT_SiDetailKkn.SYONO+" ASC ,"+JT_SiDetailKkn.SEIKYUURIREKINO+" ASC ,"+JT_SiDetailKkn.UKETUKENO+" ASC ,"+JT_SiDetailKkn.KYUUHUCD+" ASC ,"+JT_SiDetailKkn.RENNO+" ASC ,"+JT_SiDetailKkn.RENNO2KETA2+" ASC ")
    public  List<JT_SiDetailKkn> getSiDetailKkns() {
        return jT_SiDetailKkns;
    }

    @Transient
    public  List<JT_SiDetail> getSiDetailsByKyhkgNe() {
        return new ArrayList<JT_SiDetail>(Collections2.filter(getSiDetails(),
            new FilterSiDetailByKyhkgNe()));
    }
    @Transient
    public  List<JT_SiDetail> getSiDetailsByKyhkg() {
        return new ArrayList<JT_SiDetail>(Collections2.filter(getSiDetails(),
            new FilterSiDetailByKyhkg()));
    }
}

