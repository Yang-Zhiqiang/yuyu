package yuyu.def.db.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenHT_BosKouzaJyouhou;

/**
 * 募集口座情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_BosKouzaJyouhou} の JavaDoc を参照してください。<br />
 * @see     GenHT_BosKouzaJyouhou<br />
 * @see     PKHT_BosKouzaJyouhou<br />
 * @see     QHT_BosKouzaJyouhou<br />
 * @see     GenQHT_BosKouzaJyouhou<br />
 */
@Entity
public class HT_BosKouzaJyouhou extends GenHT_BosKouzaJyouhou {

    private static final long serialVersionUID = 1L;

    public HT_BosKouzaJyouhou() {
    }

    public HT_BosKouzaJyouhou(String pMosno) {
        super(pMosno);
    }



    private HT_BosKihon hT_BosKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_BosKouzaJyouhou.MOSNO  , referencedColumnName=HT_BosKihon.MOSNO, insertable=false, updatable=false)
    })
    public HT_BosKihon getBosKihon() {
        return hT_BosKihon;
    }

    public void setBosKihon(HT_BosKihon pHT_BosKihon) {
        this.hT_BosKihon = pHT_BosKihon;
    }

    private BM_Ginkou bM_Ginkou ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_BosKouzaJyouhou.BANKCD  , referencedColumnName=BM_Ginkou.BANKCD, insertable=false, updatable=false),
        @JoinColumn(name=HT_BosKouzaJyouhou.SITENCD  , referencedColumnName=BM_Ginkou.SITENCD, insertable=false, updatable=false)
    })
    public  BM_Ginkou getGinkou() {
        return bM_Ginkou;
    }

    public void setGinkou(BM_Ginkou pBM_Ginkou) {
        this.bM_Ginkou = pBM_Ginkou;
    }

}

