package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.db.mapping.GenHT_UketoriKouzaJyouhouVrf;


/**
 * 受取口座情報ベリファイテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_UketoriKouzaJyouhouVrf} の JavaDoc を参照してください。<br />
 * @see     GenHT_UketoriKouzaJyouhouVrf<br />
 * @see     PKHT_UketoriKouzaJyouhouVrf<br />
 * @see     QHT_UketoriKouzaJyouhouVrf<br />
 * @see     GenQHT_UketoriKouzaJyouhouVrf<br />
 */
@Entity
public class HT_UketoriKouzaJyouhouVrf extends GenHT_UketoriKouzaJyouhouVrf {

    private static final long serialVersionUID = 1L;

    public HT_UketoriKouzaJyouhouVrf() {
    }

    public HT_UketoriKouzaJyouhouVrf(String pMosno,C_UketorikouzasyubetuKbn pUktkzsyubetukbn) {
        super(pMosno,pUktkzsyubetukbn);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_UketoriKouzaJyouhouVrf.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

