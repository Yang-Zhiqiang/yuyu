package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenHT_KokutisyoVrf;


/**
 * 告知書ベリファイテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_KokutisyoVrf} の JavaDoc を参照してください。<br />
 * @see     GenHT_KokutisyoVrf<br />
 * @see     PKHT_KokutisyoVrf<br />
 * @see     QHT_KokutisyoVrf<br />
 * @see     GenQHT_KokutisyoVrf<br />
 */
@Entity
public class HT_KokutisyoVrf extends GenHT_KokutisyoVrf {

    private static final long serialVersionUID = 1L;

    public HT_KokutisyoVrf() {
    }

    public HT_KokutisyoVrf(String pMosno) {
        super(pMosno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_KokutisyoVrf.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

