package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenHT_SouseirituDairiten;


/**
 * 総成立代理店テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SouseirituDairiten} の JavaDoc を参照してください。<br />
 * @see     GenHT_SouseirituDairiten<br />
 * @see     PKHT_SouseirituDairiten<br />
 * @see     QHT_SouseirituDairiten<br />
 * @see     GenQHT_SouseirituDairiten<br />
 */
@Entity
public class HT_SouseirituDairiten extends GenHT_SouseirituDairiten {

    private static final long serialVersionUID = 1L;

    public HT_SouseirituDairiten() {
    }

    public HT_SouseirituDairiten(String pSyono,Integer pRenno) {
        super(pSyono,pRenno);
    }



    private HT_SouseirituKihon hT_SouseirituKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_SouseirituDairiten.SYONO  , referencedColumnName=HT_SouseirituKihon.SYONO, insertable=false, updatable=false)
    })
    public HT_SouseirituKihon getSouseirituKihon() {
        return hT_SouseirituKihon;
    }

    public void setSouseirituKihon(HT_SouseirituKihon pHT_SouseirituKihon) {
        this.hT_SouseirituKihon = pHT_SouseirituKihon;
    }

    private BM_Dairiten bM_DairitenTrat ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_SouseirituDairiten.TRATKIAGCD  , referencedColumnName=BM_Dairiten.DRTENCD, insertable=false, updatable=false)
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
        @JoinColumn(name=HT_SouseirituDairiten.OYADRTENCD  , referencedColumnName=BM_Dairiten.DRTENCD, insertable=false, updatable=false)
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
        @JoinColumn(name=HT_SouseirituDairiten.BOSYUUCD  , referencedColumnName=BM_Bosyuunin.BOSYUUCD, insertable=false, updatable=false)
    })
    public  BM_Bosyuunin getBosyuunin() {
        return bM_Bosyuunin;
    }

    public void setBosyuunin(BM_Bosyuunin pBM_Bosyuunin) {
        this.bM_Bosyuunin = pBM_Bosyuunin;
    }

}

