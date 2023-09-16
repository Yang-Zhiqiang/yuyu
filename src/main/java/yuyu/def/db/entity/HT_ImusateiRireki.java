package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenHT_ImusateiRireki;


/**
 * 医務査定履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_ImusateiRireki} の JavaDoc を参照してください。<br />
 * @see     GenHT_ImusateiRireki<br />
 * @see     PKHT_ImusateiRireki<br />
 * @see     QHT_ImusateiRireki<br />
 * @see     GenQHT_ImusateiRireki<br />
 */
@Entity
public class HT_ImusateiRireki extends GenHT_ImusateiRireki {

    private static final long serialVersionUID = 1L;

    public HT_ImusateiRireki() {
    }

    public HT_ImusateiRireki(String pMosno,Integer pRenno) {
        super(pMosno,pRenno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_ImusateiRireki.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
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
        @JoinColumn(name=HT_ImusateiRireki.KETSYACD  , referencedColumnName=HM_KetteiSya.KETSYACD, insertable=false, updatable=false)
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
        @JoinColumn(name=HT_ImusateiRireki.TNSKETSYACD  , referencedColumnName=HM_KetteiSya.KETSYACD, insertable=false, updatable=false)
    })
    public  HM_KetteiSya getTensousakiKetteiSya() {
        return hM_TensousakiKetteiSya;
    }

    public void setTensousakiKetteiSya(HM_KetteiSya pHM_KetteiSya) {
        this.hM_TensousakiKetteiSya = pHM_KetteiSya;
    }

    private BM_Syoubyou bM_Syoubyou1 ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_ImusateiRireki.SYOUBYOUCD1  , referencedColumnName=BM_Syoubyou.SYOUBYOUCD, insertable=false, updatable=false)
    })
    public  BM_Syoubyou getSyoubyou1() {
        return bM_Syoubyou1;
    }

    public void setSyoubyou1(BM_Syoubyou pBM_Syoubyou) {
        this.bM_Syoubyou1 = pBM_Syoubyou;
    }

    private BM_Syoubyou bM_Syoubyou2 ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_ImusateiRireki.SYOUBYOUCD2  , referencedColumnName=BM_Syoubyou.SYOUBYOUCD, insertable=false, updatable=false)
    })
    public  BM_Syoubyou getSyoubyou2() {
        return bM_Syoubyou2;
    }

    public void setSyoubyou2(BM_Syoubyou pBM_Syoubyou) {
        this.bM_Syoubyou2 = pBM_Syoubyou;
    }

}

