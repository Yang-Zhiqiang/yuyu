package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.mapping.GenHT_BosUketorinin;


/**
 * 募集受取人テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_BosUketorinin} の JavaDoc を参照してください。<br />
 * @see     GenHT_BosUketorinin<br />
 * @see     PKHT_BosUketorinin<br />
 * @see     QHT_BosUketorinin<br />
 * @see     GenQHT_BosUketorinin<br />
 */
@Entity
public class HT_BosUketorinin extends GenHT_BosUketorinin {

    private static final long serialVersionUID = 1L;

    public HT_BosUketorinin() {
    }

    public HT_BosUketorinin(String pMosno,C_UktsyuKbn pUktsyukbn,Integer pUktsyurenno) {
        super(pMosno,pUktsyukbn,pUktsyurenno);
    }



    private HT_BosKihon hT_BosKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_BosUketorinin.MOSNO  , referencedColumnName=HT_BosKihon.MOSNO, insertable=false, updatable=false)
    })
    public HT_BosKihon getBosKihon() {
        return hT_BosKihon;
    }

    public void setBosKihon(HT_BosKihon pHT_BosKihon) {
        this.hT_BosKihon = pHT_BosKihon;
    }

}

