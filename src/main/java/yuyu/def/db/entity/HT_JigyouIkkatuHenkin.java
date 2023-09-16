package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenHT_JigyouIkkatuHenkin;


/**
 * 事業一括返金テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_JigyouIkkatuHenkin} の JavaDoc を参照してください。<br />
 * @see     GenHT_JigyouIkkatuHenkin<br />
 * @see     PKHT_JigyouIkkatuHenkin<br />
 * @see     QHT_JigyouIkkatuHenkin<br />
 * @see     GenQHT_JigyouIkkatuHenkin<br />
 */
@Entity
public class HT_JigyouIkkatuHenkin extends GenHT_JigyouIkkatuHenkin {

    private static final long serialVersionUID = 1L;

    public HT_JigyouIkkatuHenkin() {
    }

    public HT_JigyouIkkatuHenkin(String pDaimosno,Integer pRenno) {
        super(pDaimosno,pRenno);
    }



    private HT_JigyouIkkatu hT_JigyouIkkatu ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_JigyouIkkatuHenkin.DAIMOSNO  , referencedColumnName=HT_JigyouIkkatu.DAIMOSNO, insertable=false, updatable=false)
    })
    public HT_JigyouIkkatu getJigyouIkkatu() {
        return hT_JigyouIkkatu;
    }

    public void setJigyouIkkatu(HT_JigyouIkkatu pHT_JigyouIkkatu) {
        this.hT_JigyouIkkatu = pHT_JigyouIkkatu;
    }

}

