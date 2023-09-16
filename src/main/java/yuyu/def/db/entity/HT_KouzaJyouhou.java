package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenHT_KouzaJyouhou;


/**
 * 口座情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_KouzaJyouhou} の JavaDoc を参照してください。<br />
 * @see     GenHT_KouzaJyouhou<br />
 * @see     PKHT_KouzaJyouhou<br />
 * @see     QHT_KouzaJyouhou<br />
 * @see     GenQHT_KouzaJyouhou<br />
 */
@Entity
public class HT_KouzaJyouhou extends GenHT_KouzaJyouhou {

    private static final long serialVersionUID = 1L;

    public HT_KouzaJyouhou() {
    }

    public HT_KouzaJyouhou(String pMosno) {
        super(pMosno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_KouzaJyouhou.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
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
        @JoinColumn(name=HT_KouzaJyouhou.BANKCD  , referencedColumnName=BM_Ginkou.BANKCD, insertable=false, updatable=false),
        @JoinColumn(name=HT_KouzaJyouhou.SITENCD  , referencedColumnName=BM_Ginkou.SITENCD, insertable=false, updatable=false)
    })
    public  BM_Ginkou getGinkou() {
        return bM_Ginkou;
    }

    public void setGinkou(BM_Ginkou pBM_Ginkou) {
        this.bM_Ginkou = pBM_Ginkou;
    }

}

