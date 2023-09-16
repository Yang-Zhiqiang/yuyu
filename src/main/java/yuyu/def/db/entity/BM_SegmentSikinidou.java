package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_Segcd;
import yuyu.def.db.mapping.GenBM_SegmentSikinidou;

/**
 * セグメントコード別資金移動処理マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_SegmentSikinidou} の JavaDoc を参照してください。<br />
 * @see     GenBM_SegmentSikinidou<br />
 * @see     PKBM_SegmentSikinidou<br />
 * @see     QBM_SegmentSikinidou<br />
 * @see     GenQBM_SegmentSikinidou<br />
 */
@Entity
public class BM_SegmentSikinidou extends GenBM_SegmentSikinidou {

    private static final long serialVersionUID = 1L;

    public BM_SegmentSikinidou() {
    }

    public BM_SegmentSikinidou(C_Segcd pSegcd) {
        super(pSegcd);
    }



    private BM_Segment bM_Segment ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BM_SegmentSikinidou.SEGCD  , referencedColumnName=BM_Segment.SEGCD, insertable=false, updatable=false)
    })
    public  BM_Segment getSegment() {
        return bM_Segment;
    }

    public void setSegment(BM_Segment pBM_Segment) {
        this.bM_Segment = pBM_Segment;
    }

}

