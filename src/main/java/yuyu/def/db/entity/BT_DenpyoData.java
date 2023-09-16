package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.mapping.GenBT_DenpyoData;


/**
 * 経理伝票データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_DenpyoData} の JavaDoc を参照してください。<br />
 * @see     GenBT_DenpyoData<br />
 * @see     PKBT_DenpyoData<br />
 * @see     QBT_DenpyoData<br />
 * @see     GenQBT_DenpyoData<br />
 */
@Entity
public class BT_DenpyoData extends GenBT_DenpyoData {

    private static final long serialVersionUID = 1L;

    public BT_DenpyoData() {
    }

    public BT_DenpyoData(C_DensysKbn pDensyskbn,String pDenrenno,Integer pEdano) {
        super(pDensyskbn,pDenrenno,pEdano);
    }



    private BM_KanjyouKamoku bM_KanjyouKamoku ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BT_DenpyoData.KANJYOUKMKCD  , referencedColumnName=BM_KanjyouKamoku.KANJYOUKMKCD, insertable=false, updatable=false)
    })
    public  BM_KanjyouKamoku getKanjyouKamoku() {
        return bM_KanjyouKamoku;
    }

    public void setKanjyouKamoku(BM_KanjyouKamoku pBM_KanjyouKamoku) {
        this.bM_KanjyouKamoku = pBM_KanjyouKamoku;
    }

    private BM_Segment bM_Segment1 ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BT_DenpyoData.SEG1CD  , referencedColumnName=BM_Segment.SEGCD, insertable=false, updatable=false)
    })
    public  BM_Segment getSegment1() {
        return bM_Segment1;
    }

    public void setSegment1(BM_Segment pBM_Segment) {
        this.bM_Segment1 = pBM_Segment;
    }

    private BM_Segment bM_Segment2 ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BT_DenpyoData.SEG2CD  , referencedColumnName=BM_Segment.SEGCD, insertable=false, updatable=false)
    })
    public  BM_Segment getSegment2() {
        return bM_Segment2;
    }

    public void setSegment2(BM_Segment pBM_Segment) {
        this.bM_Segment2 = pBM_Segment;
    }

    private BM_Syoritanto bM_Syoritanto ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BT_DenpyoData.SYORICD  , referencedColumnName=BM_Syoritanto.SYORICD, insertable=false, updatable=false)
    })
    public  BM_Syoritanto getSyoritanto() {
        return bM_Syoritanto;
    }

    public void setSyoritanto(BM_Syoritanto pBM_Syoritanto) {
        this.bM_Syoritanto = pBM_Syoritanto;
    }

    private IT_NyuukinKakusyouData iT_NyuukinKakusyouData ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BT_DenpyoData.DENRENNO  , referencedColumnName=IT_NyuukinKakusyouData.DENRENNO, insertable=false, updatable=false),
    })
    public  IT_NyuukinKakusyouData getNyuukinKakusyouData() {
        return iT_NyuukinKakusyouData;
    }

    public void setNyuukinKakusyouData(IT_NyuukinKakusyouData pIT_NyuukinKakusyouData) {
        this.iT_NyuukinKakusyouData = pIT_NyuukinKakusyouData;
    }

}

