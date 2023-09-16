package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.classification.C_SyosaiKbn;
import yuyu.def.db.mapping.GenHT_Houjyou;


/**
 * 報状テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_Houjyou} の JavaDoc を参照してください。<br />
 * @see     GenHT_Houjyou<br />
 * @see     PKHT_Houjyou<br />
 * @see     QHT_Houjyou<br />
 * @see     GenQHT_Houjyou<br />
 */
@Entity
public class HT_Houjyou extends GenHT_Houjyou {

    private static final long serialVersionUID = 1L;

    public HT_Houjyou() {
    }

    public HT_Houjyou(String pMosno,C_SyosaiKbn pSyosaikbn) {
        super(pMosno,pSyosaikbn);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_Houjyou.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

