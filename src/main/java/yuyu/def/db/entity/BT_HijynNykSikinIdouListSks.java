package yuyu.def.db.entity;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.date.BizDateYM;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenBT_HijynNykSikinIdouListSks;


/**
 * 平準払入金用資金移動リスト作成用テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_HijynNykSikinIdouListSks} の JavaDoc を参照してください。<br />
 * @see     GenBT_HijynNykSikinIdouListSks<br />
 * @see     PKBT_HijynNykSikinIdouListSks<br />
 * @see     QBT_HijynNykSikinIdouListSks<br />
 * @see     GenQBT_HijynNykSikinIdouListSks<br />
 */
@Entity
public class BT_HijynNykSikinIdouListSks extends GenBT_HijynNykSikinIdouListSks {

    private static final long serialVersionUID = 1L;

    public BT_HijynNykSikinIdouListSks() {
    }

    public BT_HijynNykSikinIdouListSks(String pSyono,BizDateYM pSikinidoupjytym) {
        super(pSyono,pSikinidoupjytym);
    }

    private BM_Segment bM_Segment ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BT_HijynNykSikinIdouListSks.SEG1CD  , referencedColumnName=BM_Segment.SEGCD, insertable=false, updatable=false)
    })
    public  BM_Segment getSegment() {
        return bM_Segment;
    }

    public void setSegment(BM_Segment pBM_Segment) {
        this.bM_Segment = pBM_Segment;
    }

}

