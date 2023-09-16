package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenHT_KnksateiRireki;


/**
 * 環境査定履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_KnksateiRireki} の JavaDoc を参照してください。<br />
 * @see     GenHT_KnksateiRireki<br />
 * @see     PKHT_KnksateiRireki<br />
 * @see     QHT_KnksateiRireki<br />
 * @see     GenQHT_KnksateiRireki<br />
 */
@Entity
public class HT_KnksateiRireki extends GenHT_KnksateiRireki {

    private static final long serialVersionUID = 1L;

    public HT_KnksateiRireki() {
    }

    public HT_KnksateiRireki(String pMosno,Integer pRenno) {
        super(pMosno,pRenno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_KnksateiRireki.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
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
        @JoinColumn(name=HT_KnksateiRireki.KETSYACD  , referencedColumnName=HM_KetteiSya.KETSYACD, insertable=false, updatable=false)
    })
    public  HM_KetteiSya getKetteiSya() {
        return hM_KetteiSya;
    }

    public void setKetteiSya(HM_KetteiSya pHM_KetteiSya) {
        this.hM_KetteiSya = pHM_KetteiSya;
    }

    private HM_KetteiSya hM_TensousakiKetteiSya ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_KnksateiRireki.TNSKETSYACD  , referencedColumnName=HM_KetteiSya.KETSYACD, insertable=false, updatable=false)
    })
    public  HM_KetteiSya getTensousakiKetteiSya() {
        return hM_TensousakiKetteiSya;
    }

    public void setTensousakiKetteiSya(HM_KetteiSya pHM_KetteiSya) {
        this.hM_TensousakiKetteiSya = pHM_KetteiSya;
    }

}

