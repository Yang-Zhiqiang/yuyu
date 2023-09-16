package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.date.BizDate;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_SikinidouPKbn;
import yuyu.def.db.mapping.GenBT_HijynNykSiknIdouLstSksGk;

/**
 * 平準払入金用資金移動リスト作成用テーブル（外貨） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_HijynNykSiknIdouLstSksGk} の JavaDoc を参照してください。<br />
 * @see     GenBT_HijynNykSiknIdouLstSksGk<br />
 * @see     PKBT_HijynNykSiknIdouLstSksGk<br />
 * @see     QBT_HijynNykSiknIdouLstSksGk<br />
 * @see     GenQBT_HijynNykSiknIdouLstSksGk<br />
 */
@Entity
public class BT_HijynNykSiknIdouLstSksGk extends GenBT_HijynNykSiknIdouLstSksGk {

    private static final long serialVersionUID = 1L;

    public BT_HijynNykSiknIdouLstSksGk() {
    }

    public BT_HijynNykSiknIdouLstSksGk(BizDate pSyoriYmd,C_SikinidouPKbn pSikinidoupkbn,String pSyono,Integer pRenno) {
        super(pSyoriYmd,pSikinidoupkbn,pSyono,pRenno);
    }



    private BM_Segment bM_Segment ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BT_HijynNykSiknIdouLstSksGk.SEG1CD  , referencedColumnName=BM_Segment.SEGCD, insertable=false, updatable=false)
    })
    public  BM_Segment getSegment() {
        return bM_Segment;
    }

    public void setSegment(BM_Segment pBM_Segment) {
        this.bM_Segment = pBM_Segment;
    }

}

