package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenHT_BosDairiten;


/**
 * 募集代理店テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_BosDairiten} の JavaDoc を参照してください。<br />
 * @see     GenHT_BosDairiten<br />
 * @see     PKHT_BosDairiten<br />
 * @see     QHT_BosDairiten<br />
 * @see     GenQHT_BosDairiten<br />
 */
@Entity
public class HT_BosDairiten extends GenHT_BosDairiten {

    private static final long serialVersionUID = 1L;

    public HT_BosDairiten() {
    }

    public HT_BosDairiten(String pMosno,Integer pRenno) {
        super(pMosno,pRenno);
    }



    private HT_BosKihon hT_BosKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_BosDairiten.MOSNO  , referencedColumnName=HT_BosKihon.MOSNO, insertable=false, updatable=false)
    })
    public HT_BosKihon getBosKihon() {
        return hT_BosKihon;
    }

    public void setBosKihon(HT_BosKihon pHT_BosKihon) {
        this.hT_BosKihon = pHT_BosKihon;
    }

    private BM_Dairiten bM_DairitenTrat ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_BosDairiten.TRATKIAGCD  , referencedColumnName=BM_Dairiten.DRTENCD, insertable=false, updatable=false)
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
        @JoinColumn(name=HT_BosDairiten.OYADRTENCD  , referencedColumnName=BM_Dairiten.DRTENCD, insertable=false, updatable=false)
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
        @JoinColumn(name=HT_BosDairiten.BOSYUUCD  , referencedColumnName=BM_Bosyuunin.BOSYUUCD, insertable=false, updatable=false)
    })
    public  BM_Bosyuunin getBosyuunin() {
        return bM_Bosyuunin;
    }

    public void setBosyuunin(BM_Bosyuunin pBM_Bosyuunin) {
        this.bM_Bosyuunin = pBM_Bosyuunin;
    }

}

