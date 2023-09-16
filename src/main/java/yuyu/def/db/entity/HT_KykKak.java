package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenHT_KykKak;


/**
 * 契約確認テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_KykKak} の JavaDoc を参照してください。<br />
 * @see     GenHT_KykKak<br />
 * @see     PKHT_KykKak<br />
 * @see     QHT_KykKak<br />
 * @see     GenQHT_KykKak<br />
 */
@Entity
public class HT_KykKak extends GenHT_KykKak {

    private static final long serialVersionUID = 1L;

    public HT_KykKak() {
    }

    public HT_KykKak(String pMosno,Integer pRenno) {
        super(pMosno,pRenno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_KykKak.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

