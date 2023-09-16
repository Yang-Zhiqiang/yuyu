package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.id.PKHT_BosKokutisyo;
import yuyu.def.db.mapping.GenHT_BosKokutisyo;
import yuyu.def.db.meta.GenQHT_BosKokutisyo;
import yuyu.def.db.meta.QHT_BosKokutisyo;

/**
 * 募集告知書テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_BosKokutisyo} の JavaDoc を参照してください。
 * @see     GenHT_BosKokutisyo
 * @see     PKHT_BosKokutisyo
 * @see     QHT_BosKokutisyo
 * @see     GenQHT_BosKokutisyo
 */
@Entity
public class HT_BosKokutisyo extends GenHT_BosKokutisyo {

    private static final long serialVersionUID = 1L;

    public HT_BosKokutisyo() {
    }

    public HT_BosKokutisyo(String pMosno) {
        super(pMosno);
    }



    private HT_BosKihon hT_BosKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_BosKokutisyo.MOSNO  , referencedColumnName=HT_BosKihon.MOSNO, insertable=false, updatable=false)
    })
    public HT_BosKihon getBosKihon() {
        return hT_BosKihon;
    }

    public void setBosKihon(HT_BosKihon pHT_BosKihon) {
        this.hT_BosKihon = pHT_BosKihon;
    }

}
