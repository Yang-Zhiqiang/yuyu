package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.mapping.GenBT_HuriDenpyou;


/**
 * 振替伝票作成用テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_HuriDenpyou} の JavaDoc を参照してください。<br />
 * @see     GenBT_HuriDenpyou<br />
 * @see     PKBT_HuriDenpyou<br />
 * @see     QBT_HuriDenpyou<br />
 * @see     GenQBT_HuriDenpyou<br />
 */
@Entity
public class BT_HuriDenpyou extends GenBT_HuriDenpyou {

    private static final long serialVersionUID = 1L;

    public BT_HuriDenpyou() {
    }

    public BT_HuriDenpyou(C_DensysKbn pDensyskbn,String pDenrenno,Integer pEdano) {
        super(pDensyskbn,pDenrenno,pEdano);
    }



    private BM_KanjyouKamoku bM_KanjyouKamoku ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BT_HuriDenpyou.KANJYOUKMKCD  , referencedColumnName=BM_KanjyouKamoku.KANJYOUKMKCD, insertable=false, updatable=false)
    })
    public  BM_KanjyouKamoku getKanjyouKamoku() {
        return bM_KanjyouKamoku;
    }

    public void setKanjyouKamoku(BM_KanjyouKamoku pBM_KanjyouKamoku) {
        this.bM_KanjyouKamoku = pBM_KanjyouKamoku;
    }

}

