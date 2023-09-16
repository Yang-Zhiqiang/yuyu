package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenHT_JigyouIkkatuNyuukin;


/**
 * 事業一括入金テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_JigyouIkkatuNyuukin} の JavaDoc を参照してください。<br />
 * @see     GenHT_JigyouIkkatuNyuukin<br />
 * @see     PKHT_JigyouIkkatuNyuukin<br />
 * @see     QHT_JigyouIkkatuNyuukin<br />
 * @see     GenQHT_JigyouIkkatuNyuukin<br />
 */
@Entity
public class HT_JigyouIkkatuNyuukin extends GenHT_JigyouIkkatuNyuukin {

    private static final long serialVersionUID = 1L;

    public HT_JigyouIkkatuNyuukin() {
    }

    public HT_JigyouIkkatuNyuukin(String pDaimosno,Integer pRenno) {
        super(pDaimosno,pRenno);
    }



    private HT_JigyouIkkatu hT_JigyouIkkatu ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_JigyouIkkatuNyuukin.DAIMOSNO  , referencedColumnName=HT_JigyouIkkatu.DAIMOSNO, insertable=false, updatable=false)
    })
    public HT_JigyouIkkatu getJigyouIkkatu() {
        return hT_JigyouIkkatu;
    }

    public void setJigyouIkkatu(HT_JigyouIkkatu pHT_JigyouIkkatu) {
        this.hT_JigyouIkkatu = pHT_JigyouIkkatu;
    }

}

