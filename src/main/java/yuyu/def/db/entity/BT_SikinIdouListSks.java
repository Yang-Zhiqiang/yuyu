package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.id.PKBT_SikinIdouListSks;
import yuyu.def.db.mapping.GenBT_SikinIdouListSks;
import yuyu.def.db.meta.GenQBT_SikinIdouListSks;
import yuyu.def.db.meta.QBT_SikinIdouListSks;

/**
 * 資金移動リスト作成用テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_SikinIdouListSks} の JavaDoc を参照してください。
 * @see     GenBT_SikinIdouListSks
 * @see     PKBT_SikinIdouListSks
 * @see     QBT_SikinIdouListSks
 * @see     GenQBT_SikinIdouListSks
 */
@Entity
public class BT_SikinIdouListSks extends GenBT_SikinIdouListSks {

    private static final long serialVersionUID = 1L;

    public BT_SikinIdouListSks() {
    }

    public BT_SikinIdouListSks(
        C_DensysKbn pDensyskbn,
        String pDenrenno,
        Integer pEdano
        ) {
        super(
            pDensyskbn,
            pDenrenno,
            pEdano
            );
    }

    private BM_Segment bM_Segment ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BT_SikinIdouListSks.SEG1CD  , referencedColumnName=BM_Segment.SEGCD, insertable=false, updatable=false)
    })
    public  BM_Segment getSegment() {
        return bM_Segment;
    }

    public void setSegment(BM_Segment pBM_Segment) {
        this.bM_Segment = pBM_Segment;
    }

}
