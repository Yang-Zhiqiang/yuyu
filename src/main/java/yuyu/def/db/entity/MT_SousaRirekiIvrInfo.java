package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenMT_SousaRirekiIvrInfo;


/**
 * 操作履歴ＩＶＲ情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_SousaRirekiIvrInfo} の JavaDoc を参照してください。<br />
 * @see     GenMT_SousaRirekiIvrInfo<br />
 * @see     PKMT_SousaRirekiIvrInfo<br />
 * @see     QMT_SousaRirekiIvrInfo<br />
 * @see     GenQMT_SousaRirekiIvrInfo<br />
 */
@Entity
public class MT_SousaRirekiIvrInfo extends GenMT_SousaRirekiIvrInfo {

    private static final long serialVersionUID = 1L;

    public MT_SousaRirekiIvrInfo() {
    }

    public MT_SousaRirekiIvrInfo(String pTtdksikibetuid) {
        super(pTtdksikibetuid);
    }



    private MT_SousaRireki mT_SousaRireki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_SousaRirekiIvrInfo.TTDKSIKIBETUID  , referencedColumnName=MT_SousaRireki.TTDKSIKIBETUID, insertable=false, updatable=false)
    })
    public MT_SousaRireki getSousaRireki() {
        return mT_SousaRireki;
    }

    public void setSousaRireki(MT_SousaRireki pMT_SousaRireki) {
        this.mT_SousaRireki = pMT_SousaRireki;
    }

}

