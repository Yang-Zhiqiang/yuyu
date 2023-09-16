package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenHT_SkTtdkTyuuiKanri;


/**
 * 新契約手続注意管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SkTtdkTyuuiKanri} の JavaDoc を参照してください。<br />
 * @see     GenHT_SkTtdkTyuuiKanri<br />
 * @see     PKHT_SkTtdkTyuuiKanri<br />
 * @see     QHT_SkTtdkTyuuiKanri<br />
 * @see     GenQHT_SkTtdkTyuuiKanri<br />
 */
@Entity
public class HT_SkTtdkTyuuiKanri extends GenHT_SkTtdkTyuuiKanri {

    private static final long serialVersionUID = 1L;

    public HT_SkTtdkTyuuiKanri() {
    }

    public HT_SkTtdkTyuuiKanri(String pMosno) {
        super(pMosno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_SkTtdkTyuuiKanri.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

