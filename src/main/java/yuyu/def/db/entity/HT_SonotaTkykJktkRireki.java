package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.db.mapping.GenHT_SonotaTkykJktkRireki;


/**
 * その他特約条件付履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SonotaTkykJktkRireki} の JavaDoc を参照してください。<br />
 * @see     GenHT_SonotaTkykJktkRireki<br />
 * @see     PKHT_SonotaTkykJktkRireki<br />
 * @see     QHT_SonotaTkykJktkRireki<br />
 * @see     GenQHT_SonotaTkykJktkRireki<br />
 */
@Entity
public class HT_SonotaTkykJktkRireki extends GenHT_SonotaTkykJktkRireki {

    private static final long serialVersionUID = 1L;

    public HT_SonotaTkykJktkRireki() {
    }

    public HT_SonotaTkykJktkRireki(String pMosno,Integer pDakuhiktrenno,C_PmnjtkKbn pPmnjtkkbn) {
        super(pMosno,pDakuhiktrenno,pPmnjtkkbn);
    }



    private HT_DakuhiKettei hT_DakuhiKettei ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_SonotaTkykJktkRireki.MOSNO  , referencedColumnName=HT_DakuhiKettei.MOSNO, insertable=false, updatable=false),
        @JoinColumn(name=HT_SonotaTkykJktkRireki.DAKUHIKTRENNO  , referencedColumnName=HT_DakuhiKettei.DAKUHIKTRENNO, insertable=false, updatable=false)
    })
    public HT_DakuhiKettei getDakuhiKettei() {
        return hT_DakuhiKettei;
    }

    public void setDakuhiKettei(HT_DakuhiKettei pHT_DakuhiKettei) {
        this.hT_DakuhiKettei = pHT_DakuhiKettei;
    }

}

