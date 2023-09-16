package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenHT_KmTsRireki;


/**
 * 項目訂正履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_KmTsRireki} の JavaDoc を参照してください。<br />
 * @see     GenHT_KmTsRireki<br />
 * @see     PKHT_KmTsRireki<br />
 * @see     QHT_KmTsRireki<br />
 * @see     GenQHT_KmTsRireki<br />
 */
@Entity
public class HT_KmTsRireki extends GenHT_KmTsRireki {

    private static final long serialVersionUID = 1L;

    public HT_KmTsRireki() {
    }

    public HT_KmTsRireki(String pMosno,String pSyoriTime,Integer pRenno3keta) {
        super(pMosno,pSyoriTime,pRenno3keta);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_KmTsRireki.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

