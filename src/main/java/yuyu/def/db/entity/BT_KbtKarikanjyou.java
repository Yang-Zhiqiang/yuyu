package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.number.BizNumber;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenBT_KbtKarikanjyou;


/**
 * 個別仮勘定テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_KbtKarikanjyou} の JavaDoc を参照してください。<br />
 * @see     GenBT_KbtKarikanjyou<br />
 * @see     PKBT_KbtKarikanjyou<br />
 * @see     QBT_KbtKarikanjyou<br />
 * @see     GenQBT_KbtKarikanjyou<br />
 */
@Entity
public class BT_KbtKarikanjyou extends GenBT_KbtKarikanjyou {

    private static final long serialVersionUID = 1L;

    public BT_KbtKarikanjyou() {
    }

    public BT_KbtKarikanjyou(BizNumber pKbtkarikanjyouskbtkey) {
        super(pKbtkarikanjyouskbtkey);
    }



    private BM_KanjyouKamoku bM_KanjyouKamoku ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BT_KbtKarikanjyou.KANJYOUKMKCD  , referencedColumnName=BM_KanjyouKamoku.KANJYOUKMKCD, insertable=false, updatable=false)
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
        @JoinColumn(name=BT_KbtKarikanjyou.SEG1CD  , referencedColumnName=BM_Segment.SEGCD, insertable=false, updatable=false)
    })
    public  BM_Segment getSegment() {
        return bM_Segment;
    }

    public void setSegment(BM_Segment pBM_Segment) {
        this.bM_Segment = pBM_Segment;
    }

}

