package yuyu.def.db.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.db.mapping.GenHT_NayoseKekka;


/**
 * 名寄せ結果テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_NayoseKekka} の JavaDoc を参照してください。<br />
 * @see     GenHT_NayoseKekka<br />
 * @see     PKHT_NayoseKekka<br />
 * @see     QHT_NayoseKekka<br />
 * @see     GenQHT_NayoseKekka<br />
 */
@Entity
public class HT_NayoseKekka extends GenHT_NayoseKekka {

    private static final long serialVersionUID = 1L;

    public HT_NayoseKekka() {
    }

    public HT_NayoseKekka(String pMosno,C_SntkInfoTaisyousyaKbn pSntkinfotaisyousyakbn,Integer pEdano) {
        super(pMosno,pSntkinfotaisyousyakbn,pEdano);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_NayoseKekka.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

