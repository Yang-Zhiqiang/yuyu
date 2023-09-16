package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.mapping.GenST_SkOikmKaikei;


/**
 * 新契約追込会計取引データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenST_SkOikmKaikei} の JavaDoc を参照してください。<br />
 * @see     GenST_SkOikmKaikei<br />
 * @see     PKST_SkOikmKaikei<br />
 * @see     QST_SkOikmKaikei<br />
 * @see     GenQST_SkOikmKaikei<br />
 */
@Entity
public class ST_SkOikmKaikei extends GenST_SkOikmKaikei {

    private static final long serialVersionUID = 1L;

    public ST_SkOikmKaikei() {
    }

    public ST_SkOikmKaikei(C_DensysKbn pDensyskbn,String pDenrenno,Integer pEdano) {
        super(pDensyskbn,pDenrenno,pEdano);
    }



    private BM_KanjyouKamoku bM_KanjyouKamoku ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=ST_SkOikmKaikei.KANJYOUKMKCD  , referencedColumnName=BM_KanjyouKamoku.KANJYOUKMKCD, insertable=false, updatable=false)
    })
    public  BM_KanjyouKamoku getKanjyouKamoku() {
        return bM_KanjyouKamoku;
    }

    public void setKanjyouKamoku(BM_KanjyouKamoku pBM_KanjyouKamoku) {
        this.bM_KanjyouKamoku = pBM_KanjyouKamoku;
    }

    private BM_Segment bM_Segment ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=ST_SkOikmKaikei.SEG1CD  , referencedColumnName=BM_Segment.SEGCD, insertable=false, updatable=false)
    })
    public  BM_Segment getSegment() {
        return bM_Segment;
    }

    public void setSegment(BM_Segment pBM_Segment) {
        this.bM_Segment = pBM_Segment;
    }

    private BM_TantouCd bM_TantouCd ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=ST_SkOikmKaikei.TANTOCD  , referencedColumnName=BM_TantouCd.TANTOCD, insertable=false, updatable=false)
    })
    public  BM_TantouCd getTantouCd() {
        return bM_TantouCd;
    }

    public void setTantouCd(BM_TantouCd pBM_TantouCd) {
        this.bM_TantouCd = pBM_TantouCd;
    }

}

