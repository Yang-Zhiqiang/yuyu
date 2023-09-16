package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenMT_SousaRirekiSyousai;


/**
 * 操作履歴詳細テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_SousaRirekiSyousai} の JavaDoc を参照してください。<br />
 * @see     GenMT_SousaRirekiSyousai<br />
 * @see     PKMT_SousaRirekiSyousai<br />
 * @see     QMT_SousaRirekiSyousai<br />
 * @see     GenQMT_SousaRirekiSyousai<br />
 */
@Entity
public class MT_SousaRirekiSyousai extends GenMT_SousaRirekiSyousai {

    private static final long serialVersionUID = 1L;

    public MT_SousaRirekiSyousai() {
    }

    public MT_SousaRirekiSyousai(String pTtdksikibetuid,Integer pSousarirekirenno) {
        super(pTtdksikibetuid,pSousarirekirenno);
    }



    private MT_SousaRireki mT_SousaRireki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_SousaRirekiSyousai.TTDKSIKIBETUID  , referencedColumnName=MT_SousaRireki.TTDKSIKIBETUID, insertable=false, updatable=false)
    })
    public MT_SousaRireki getSousaRireki() {
        return mT_SousaRireki;
    }

    public void setSousaRireki(MT_SousaRireki pMT_SousaRireki) {
        this.mT_SousaRireki = pMT_SousaRireki;
    }

}

