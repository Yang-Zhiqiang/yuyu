package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenHT_HenteiRireki;


/**
 * 変更訂正履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_HenteiRireki} の JavaDoc を参照してください。<br />
 * @see     GenHT_HenteiRireki<br />
 * @see     PKHT_HenteiRireki<br />
 * @see     QHT_HenteiRireki<br />
 * @see     GenQHT_HenteiRireki<br />
 */
@Entity
public class HT_HenteiRireki extends GenHT_HenteiRireki {

    private static final long serialVersionUID = 1L;

    public HT_HenteiRireki() {
    }

    public HT_HenteiRireki(String pMosno,Integer pRenno) {
        super(pMosno,pRenno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_HenteiRireki.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

