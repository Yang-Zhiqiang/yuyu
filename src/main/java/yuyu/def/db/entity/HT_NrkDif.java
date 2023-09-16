package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenHT_NrkDif;


/**
 * 入力差異テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_NrkDif} の JavaDoc を参照してください。<br />
 * @see     GenHT_NrkDif<br />
 * @see     PKHT_NrkDif<br />
 * @see     QHT_NrkDif<br />
 * @see     GenQHT_NrkDif<br />
 */
@Entity
public class HT_NrkDif extends GenHT_NrkDif {

    private static final long serialVersionUID = 1L;

    public HT_NrkDif() {
    }

    public HT_NrkDif(String pMosno,String pVrfkinouid,Integer pRenno3keta) {
        super(pMosno,pVrfkinouid,pRenno3keta);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_NrkDif.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

