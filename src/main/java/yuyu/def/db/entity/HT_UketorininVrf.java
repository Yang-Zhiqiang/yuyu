package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.mapping.GenHT_UketorininVrf;


/**
 * 受取人ベリファイテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_UketorininVrf} の JavaDoc を参照してください。<br />
 * @see     GenHT_UketorininVrf<br />
 * @see     PKHT_UketorininVrf<br />
 * @see     QHT_UketorininVrf<br />
 * @see     GenQHT_UketorininVrf<br />
 */
@Entity
public class HT_UketorininVrf extends GenHT_UketorininVrf {

    private static final long serialVersionUID = 1L;

    public HT_UketorininVrf() {
    }

    public HT_UketorininVrf(String pMosno,C_UktsyuKbn pUktsyukbn,Integer pUktsyurenno) {
        super(pMosno,pUktsyukbn,pUktsyurenno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_UketorininVrf.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

