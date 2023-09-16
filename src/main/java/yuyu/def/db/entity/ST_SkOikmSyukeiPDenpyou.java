package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.mapping.GenST_SkOikmSyukeiPDenpyou;


/**
 * 新契約追込保険料伝票データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenST_SkOikmSyukeiPDenpyou} の JavaDoc を参照してください。<br />
 * @see     GenST_SkOikmSyukeiPDenpyou<br />
 * @see     PKST_SkOikmSyukeiPDenpyou<br />
 * @see     QST_SkOikmSyukeiPDenpyou<br />
 * @see     GenQST_SkOikmSyukeiPDenpyou<br />
 */
@Entity
public class ST_SkOikmSyukeiPDenpyou extends GenST_SkOikmSyukeiPDenpyou {

    private static final long serialVersionUID = 1L;

    public ST_SkOikmSyukeiPDenpyou() {
    }

    public ST_SkOikmSyukeiPDenpyou(C_DensysKbn pDensyskbn,String pDenrenno,Integer pEdano) {
        super(pDensyskbn,pDenrenno,pEdano);
    }



    private BM_KanjyouKamoku bM_KanjyouKamoku ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=ST_SkOikmSyukeiPDenpyou.KANJYOUKMKCD  , referencedColumnName=BM_KanjyouKamoku.KANJYOUKMKCD, insertable=false, updatable=false)
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
        @JoinColumn(name=ST_SkOikmSyukeiPDenpyou.SEG1CD  , referencedColumnName=BM_Segment.SEGCD, insertable=false, updatable=false)
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
        @JoinColumn(name=ST_SkOikmSyukeiPDenpyou.TANTOCD  , referencedColumnName=BM_TantouCd.TANTOCD, insertable=false, updatable=false)
    })
    public  BM_TantouCd getTantouCd() {
        return bM_TantouCd;
    }

    public void setTantouCd(BM_TantouCd pBM_TantouCd) {
        this.bM_TantouCd = pBM_TantouCd;
    }

}

