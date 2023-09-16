package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.db.mapping.GenHT_UketoriKouzaJyouhou;


/**
 * 受取口座情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_UketoriKouzaJyouhou} の JavaDoc を参照してください。<br />
 * @see     GenHT_UketoriKouzaJyouhou<br />
 * @see     PKHT_UketoriKouzaJyouhou<br />
 * @see     QHT_UketoriKouzaJyouhou<br />
 * @see     GenQHT_UketoriKouzaJyouhou<br />
 */
@Entity
public class HT_UketoriKouzaJyouhou extends GenHT_UketoriKouzaJyouhou {

    private static final long serialVersionUID = 1L;

    public HT_UketoriKouzaJyouhou() {
    }

    public HT_UketoriKouzaJyouhou(String pMosno,C_UketorikouzasyubetuKbn pUktkzsyubetukbn) {
        super(pMosno,pUktkzsyubetukbn);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_UketoriKouzaJyouhou.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
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
        @JoinColumn(name=HT_UketoriKouzaJyouhou.BANKCD  , referencedColumnName=BM_Ginkou.BANKCD, insertable=false, updatable=false),
        @JoinColumn(name=HT_UketoriKouzaJyouhou.SITENCD  , referencedColumnName=BM_Ginkou.SITENCD, insertable=false, updatable=false)
    })
    public  BM_Ginkou getGinkou() {
        return bM_Ginkou;
    }

    public void setGinkou(BM_Ginkou pBM_Ginkou) {
        this.bM_Ginkou = pBM_Ginkou;
    }

}

