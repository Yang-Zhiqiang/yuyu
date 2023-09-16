package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenHT_MosKihonVrf;


/**
 * 申込基本ベリファイテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_MosKihonVrf} の JavaDoc を参照してください。<br />
 * @see     GenHT_MosKihonVrf<br />
 * @see     PKHT_MosKihonVrf<br />
 * @see     QHT_MosKihonVrf<br />
 * @see     GenQHT_MosKihonVrf<br />
 */
@Entity
public class HT_MosKihonVrf extends GenHT_MosKihonVrf {

    private static final long serialVersionUID = 1L;

    public HT_MosKihonVrf() {
    }

    public HT_MosKihonVrf(String pMosno) {
        super(pMosno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_MosKihonVrf.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

