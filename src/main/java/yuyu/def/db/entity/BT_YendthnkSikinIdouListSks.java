package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.date.BizDate;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_KeiriyendthnkKbn;
import yuyu.def.db.mapping.GenBT_YendthnkSikinIdouListSks;

/**
 * 円建変更資金移動リスト作成用テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_YendthnkSikinIdouListSks} の JavaDoc を参照してください。<br />
 * @see     GenBT_YendthnkSikinIdouListSks<br />
 * @see     PKBT_YendthnkSikinIdouListSks<br />
 * @see     QBT_YendthnkSikinIdouListSks<br />
 * @see     GenQBT_YendthnkSikinIdouListSks<br />
 */
@Entity
public class BT_YendthnkSikinIdouListSks extends GenBT_YendthnkSikinIdouListSks {

    private static final long serialVersionUID = 1L;

    public BT_YendthnkSikinIdouListSks() {
    }

    public BT_YendthnkSikinIdouListSks(String pSyono,C_KeiriyendthnkKbn pKeiriyendthnkkbn,BizDate pSyoriYmd) {
        super(pSyono,pKeiriyendthnkkbn,pSyoriYmd);
    }



    private BM_Segment bM_Segment ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BT_YendthnkSikinIdouListSks.KBNKEIRISEGCD  , referencedColumnName=BM_Segment.SEGCD, insertable=false, updatable=false)
    })
    public  BM_Segment getSegment() {
        return bM_Segment;
    }

    public void setSegment(BM_Segment pBM_Segment) {
        this.bM_Segment = pBM_Segment;
    }

}

