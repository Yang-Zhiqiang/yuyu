package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenBM_Dairiten;


/**
 * 代理店マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_Dairiten} の JavaDoc を参照してください。<br />
 * @see     GenBM_Dairiten<br />
 * @see     PKBM_Dairiten<br />
 * @see     QBM_Dairiten<br />
 * @see     GenQBM_Dairiten<br />
 */
@Entity
public class BM_Dairiten extends GenBM_Dairiten {

    private static final long serialVersionUID = 1L;

    public BM_Dairiten() {
    }

    public BM_Dairiten(String pDrtencd) {
        super(pDrtencd);
    }



    private BM_DairitenSyougou bM_DairitenSyougou ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BM_Dairiten.DRTENCD  , referencedColumnName=BM_DairitenSyougou.DRTENCD, insertable=false, updatable=false)
    })
    public  BM_DairitenSyougou getDairitenSyougou() {
        return bM_DairitenSyougou;
    }

    public void setDairitenSyougou(BM_DairitenSyougou pBM_DairitenSyougou) {
        this.bM_DairitenSyougou = pBM_DairitenSyougou;
    }

    private BM_Bosyuunin bM_Bosyuunin ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BM_Dairiten.DAIBOSYUUCD  , referencedColumnName=BM_Bosyuunin.BOSYUUCD, insertable=false, updatable=false)
    })
    public  BM_Bosyuunin getBosyuunin() {
        return bM_Bosyuunin;
    }

    public void setBosyuunin(BM_Bosyuunin pBM_Bosyuunin) {
        this.bM_Bosyuunin = pBM_Bosyuunin;
    }

}

