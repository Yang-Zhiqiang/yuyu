package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.db.mapping.GenHT_BosUketoriKouzaJyouhou;


/**
 * 募集受取口座情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_BosUketoriKouzaJyouhou} の JavaDoc を参照してください。<br />
 * @see     GenHT_BosUketoriKouzaJyouhou<br />
 * @see     PKHT_BosUketoriKouzaJyouhou<br />
 * @see     QHT_BosUketoriKouzaJyouhou<br />
 * @see     GenQHT_BosUketoriKouzaJyouhou<br />
 */
@Entity
public class HT_BosUketoriKouzaJyouhou extends GenHT_BosUketoriKouzaJyouhou {

    private static final long serialVersionUID = 1L;

    public HT_BosUketoriKouzaJyouhou() {
    }

    public HT_BosUketoriKouzaJyouhou(String pMosno,C_UketorikouzasyubetuKbn pUktkzsyubetukbn) {
        super(pMosno,pUktkzsyubetukbn);
    }



    private HT_BosKihon hT_BosKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_BosUketoriKouzaJyouhou.MOSNO  , referencedColumnName=HT_BosKihon.MOSNO, insertable=false, updatable=false)
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
        @JoinColumn(name=HT_BosUketoriKouzaJyouhou.BANKCD  , referencedColumnName=BM_Ginkou.BANKCD, insertable=false, updatable=false),
        @JoinColumn(name=HT_BosUketoriKouzaJyouhou.SITENCD  , referencedColumnName=BM_Ginkou.SITENCD, insertable=false, updatable=false)
    })
    public  BM_Ginkou getGinkou() {
        return bM_Ginkou;
    }

    public void setGinkou(BM_Ginkou pBM_Ginkou) {
        this.bM_Ginkou = pBM_Ginkou;
    }

}

