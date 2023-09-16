package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenHT_MosDairiten;


/**
 * 申込代理店テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_MosDairiten} の JavaDoc を参照してください。<br />
 * @see     GenHT_MosDairiten<br />
 * @see     PKHT_MosDairiten<br />
 * @see     QHT_MosDairiten<br />
 * @see     GenQHT_MosDairiten<br />
 */
@Entity
public class HT_MosDairiten extends GenHT_MosDairiten {

    private static final long serialVersionUID = 1L;

    public HT_MosDairiten() {
    }

    public HT_MosDairiten(String pMosno,Integer pRenno) {
        super(pMosno,pRenno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_MosDairiten.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

    private BM_Dairiten bM_DairitenTrat ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_MosDairiten.TRATKIAGCD  , referencedColumnName=BM_Dairiten.DRTENCD, insertable=false, updatable=false)
    })
    public  BM_Dairiten getDairitenTrat() {
        return bM_DairitenTrat;
    }

    public void setDairitenTrat(BM_Dairiten pBM_Dairiten) {
        this.bM_DairitenTrat = pBM_Dairiten;
    }

    private BM_Dairiten bM_DairitenOya ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_MosDairiten.OYADRTENCD  , referencedColumnName=BM_Dairiten.DRTENCD, insertable=false, updatable=false)
    })
    public  BM_Dairiten getDairitenOya() {
        return bM_DairitenOya;
    }

    public void setDairitenOya(BM_Dairiten pBM_Dairiten) {
        this.bM_DairitenOya = pBM_Dairiten;
    }

    private BM_Bosyuunin bM_Bosyuunin ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_MosDairiten.BOSYUUCD  , referencedColumnName=BM_Bosyuunin.BOSYUUCD, insertable=false, updatable=false)
    })
    public  BM_Bosyuunin getBosyuunin() {
        return bM_Bosyuunin;
    }

    public void setBosyuunin(BM_Bosyuunin pBM_Bosyuunin) {
        this.bM_Bosyuunin = pBM_Bosyuunin;
    }

}

