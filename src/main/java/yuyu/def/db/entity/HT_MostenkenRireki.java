package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenHT_MostenkenRireki;


/**
 * 申込点検履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_MostenkenRireki} の JavaDoc を参照してください。<br />
 * @see     GenHT_MostenkenRireki<br />
 * @see     PKHT_MostenkenRireki<br />
 * @see     QHT_MostenkenRireki<br />
 * @see     GenQHT_MostenkenRireki<br />
 */
@Entity
public class HT_MostenkenRireki extends GenHT_MostenkenRireki {

    private static final long serialVersionUID = 1L;

    public HT_MostenkenRireki() {
    }

    public HT_MostenkenRireki(String pMosno,Integer pRenno) {
        super(pMosno,pRenno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_MostenkenRireki.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
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
        @JoinColumn(name=HT_MostenkenRireki.KETSYACD  , referencedColumnName=HM_KetteiSya.KETSYACD, insertable=false, updatable=false)
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
        @JoinColumn(name=HT_MostenkenRireki.TNSKETSYACD  , referencedColumnName=HM_KetteiSya.KETSYACD, insertable=false, updatable=false)
    })
    public  HM_KetteiSya getTensousakiKetteiSya() {
        return hM_TensousakiKetteiSya;
    }

    public void setTensousakiKetteiSya(HM_KetteiSya pHM_KetteiSya) {
        this.hM_TensousakiKetteiSya = pHM_KetteiSya;
    }

}

