package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenHT_MosDairitenVrf;


/**
 * 申込代理店ベリファイテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_MosDairitenVrf} の JavaDoc を参照してください。<br />
 * @see     GenHT_MosDairitenVrf<br />
 * @see     PKHT_MosDairitenVrf<br />
 * @see     QHT_MosDairitenVrf<br />
 * @see     GenQHT_MosDairitenVrf<br />
 */
@Entity
public class HT_MosDairitenVrf extends GenHT_MosDairitenVrf {

    private static final long serialVersionUID = 1L;

    public HT_MosDairitenVrf() {
    }

    public HT_MosDairitenVrf(String pMosno,Integer pRenno) {
        super(pMosno,pRenno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_MosDairitenVrf.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

