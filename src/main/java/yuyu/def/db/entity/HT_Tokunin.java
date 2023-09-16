package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenHT_Tokunin;


/**
 * 特認テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_Tokunin} の JavaDoc を参照してください。<br />
 * @see     GenHT_Tokunin<br />
 * @see     PKHT_Tokunin<br />
 * @see     QHT_Tokunin<br />
 * @see     GenQHT_Tokunin<br />
 */
@Entity
public class HT_Tokunin extends GenHT_Tokunin {

    private static final long serialVersionUID = 1L;

    public HT_Tokunin() {
    }

    public HT_Tokunin(String pMosno) {
        super(pMosno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_Tokunin.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

    private HM_KetteiSya hM_KetteiSya ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_Tokunin.KETSYACD  , referencedColumnName=HM_KetteiSya.KETSYACD, insertable=false, updatable=false)
    })
    public  HM_KetteiSya getKetteiSya() {
        return hM_KetteiSya;
    }

    public void setKetteiSya(HM_KetteiSya pHM_KetteiSya) {
        this.hM_KetteiSya = pHM_KetteiSya;
    }

}

