package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.date.BizDate;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenBT_SikinIdouRireki;

/**
 * 資金移動用履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_SikinIdouRireki} の JavaDoc を参照してください。<br />
 * @see     GenBT_SikinIdouRireki<br />
 * @see     PKBT_SikinIdouRireki<br />
 * @see     QBT_SikinIdouRireki<br />
 * @see     GenQBT_SikinIdouRireki<br />
 */
@Entity
public class BT_SikinIdouRireki extends GenBT_SikinIdouRireki {

    private static final long serialVersionUID = 1L;

    public BT_SikinIdouRireki() {
    }

    public BT_SikinIdouRireki(BizDate pSyoriYmd,String pKeirisyorirenno) {
        super(pSyoriYmd,pKeirisyorirenno);
    }

    private BM_Segment bM_Segment ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BT_SikinIdouRireki.SEG1CD  , referencedColumnName=BM_Segment.SEGCD, insertable=false, updatable=false)
    })
    public  BM_Segment getSegment() {
        return bM_Segment;
    }

    public void setSegment(BM_Segment pBM_Segment) {
        this.bM_Segment = pBM_Segment;
    }

}

