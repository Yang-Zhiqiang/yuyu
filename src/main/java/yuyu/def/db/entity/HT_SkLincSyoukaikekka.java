package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenHT_SkLincSyoukaikekka;

/**
 * 新契約ＬＩＮＣ他社照会結果テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SkLincSyoukaikekka} の JavaDoc を参照してください。<br />
 * @see     GenHT_SkLincSyoukaikekka<br />
 * @see     PKHT_SkLincSyoukaikekka<br />
 * @see     QHT_SkLincSyoukaikekka<br />
 * @see     GenQHT_SkLincSyoukaikekka<br />
 */
@Entity
public class HT_SkLincSyoukaikekka extends GenHT_SkLincSyoukaikekka {

    private static final long serialVersionUID = 1L;

    public HT_SkLincSyoukaikekka() {
    }

    public HT_SkLincSyoukaikekka(String pMosno,String pLincjyusintrrenno,Integer pRenno) {
        super(pMosno,pLincjyusintrrenno,pRenno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_SkLincSyoukaikekka.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

