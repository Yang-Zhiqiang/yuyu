package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenHT_KouzaJyouhouVrf;


/**
 * 口座情報ベリファイテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_KouzaJyouhouVrf} の JavaDoc を参照してください。<br />
 * @see     GenHT_KouzaJyouhouVrf<br />
 * @see     PKHT_KouzaJyouhouVrf<br />
 * @see     QHT_KouzaJyouhouVrf<br />
 * @see     GenQHT_KouzaJyouhouVrf<br />
 */
@Entity
public class HT_KouzaJyouhouVrf extends GenHT_KouzaJyouhouVrf {

    private static final long serialVersionUID = 1L;

    public HT_KouzaJyouhouVrf() {
    }

    public HT_KouzaJyouhouVrf(String pMosno) {
        super(pMosno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_KouzaJyouhouVrf.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

    private BM_Ginkou bM_Ginkou ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_KouzaJyouhouVrf.BANKCD  , referencedColumnName=BM_Ginkou.BANKCD, insertable=false, updatable=false),
        @JoinColumn(name=HT_KouzaJyouhouVrf.SITENCD  , referencedColumnName=BM_Ginkou.SITENCD, insertable=false, updatable=false)
    })
    public  BM_Ginkou getGinkou() {
        return bM_Ginkou;
    }

    public void setGinkou(BM_Ginkou pBM_Ginkou) {
        this.bM_Ginkou = pBM_Ginkou;
    }

}

