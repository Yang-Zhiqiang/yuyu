package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.mapping.GenBT_SinkeiyakuHurikaeDen;


/**
 * 新契約振替伝票作成用テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_SinkeiyakuHurikaeDen} の JavaDoc を参照してください。<br />
 * @see     GenBT_SinkeiyakuHurikaeDen<br />
 * @see     PKBT_SinkeiyakuHurikaeDen<br />
 * @see     QBT_SinkeiyakuHurikaeDen<br />
 * @see     GenQBT_SinkeiyakuHurikaeDen<br />
 */
@Entity
public class BT_SinkeiyakuHurikaeDen extends GenBT_SinkeiyakuHurikaeDen {

    private static final long serialVersionUID = 1L;

    public BT_SinkeiyakuHurikaeDen() {
    }

    public BT_SinkeiyakuHurikaeDen(C_DensysKbn pDensyskbn,String pDenrenno,Integer pEdano) {
        super(pDensyskbn,pDenrenno,pEdano);
    }



    private BM_KanjyouKamoku bM_KanjyouKamoku ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BT_SinkeiyakuHurikaeDen.KANJYOUKMKCD  , referencedColumnName=BM_KanjyouKamoku.KANJYOUKMKCD, insertable=false, updatable=false)
    })
    public  BM_KanjyouKamoku getKanjyouKamoku() {
        return bM_KanjyouKamoku;
    }

    public void setKanjyouKamoku(BM_KanjyouKamoku pBM_KanjyouKamoku) {
        this.bM_KanjyouKamoku = pBM_KanjyouKamoku;
    }

}

