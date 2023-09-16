package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.mapping.GenHT_Uketorinin;


/**
 * 受取人テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_Uketorinin} の JavaDoc を参照してください。<br />
 * @see     GenHT_Uketorinin<br />
 * @see     PKHT_Uketorinin<br />
 * @see     QHT_Uketorinin<br />
 * @see     GenQHT_Uketorinin<br />
 */
@Entity
public class HT_Uketorinin extends GenHT_Uketorinin {

    private static final long serialVersionUID = 1L;

    public HT_Uketorinin() {
    }

    public HT_Uketorinin(String pMosno,C_UktsyuKbn pUktsyukbn,Integer pUktsyurenno) {
        super(pMosno,pUktsyukbn,pUktsyurenno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_Uketorinin.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

