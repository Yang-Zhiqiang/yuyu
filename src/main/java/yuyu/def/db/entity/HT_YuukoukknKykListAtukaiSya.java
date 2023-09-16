package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KeikaKbn;
import yuyu.def.db.mapping.GenHT_YuukoukknKykListAtukaiSya;


/**
 * 有効期間経過契約リスト扱者テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_YuukoukknKykListAtukaiSya} の JavaDoc を参照してください。<br />
 * @see     GenHT_YuukoukknKykListAtukaiSya<br />
 * @see     PKHT_YuukoukknKykListAtukaiSya<br />
 * @see     QHT_YuukoukknKykListAtukaiSya<br />
 * @see     GenQHT_YuukoukknKykListAtukaiSya<br />
 */
@Entity
public class HT_YuukoukknKykListAtukaiSya extends GenHT_YuukoukknKykListAtukaiSya {

    private static final long serialVersionUID = 1L;

    public HT_YuukoukknKykListAtukaiSya() {
    }

    public HT_YuukoukknKykListAtukaiSya(String pMosno,BizDate pTyouhyouymd,C_KeikaKbn pKeikakbn,Integer pRenno) {
        super(pMosno,pTyouhyouymd,pKeikakbn,pRenno);
    }



    private HT_YuukoukknKykList hT_YuukoukknKykList ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_YuukoukknKykListAtukaiSya.MOSNO  , referencedColumnName=HT_YuukoukknKykList.MOSNO, insertable=false, updatable=false),
        @JoinColumn(name=HT_YuukoukknKykListAtukaiSya.TYOUHYOUYMD  , referencedColumnName=HT_YuukoukknKykList.TYOUHYOUYMD, insertable=false, updatable=false)
    })
    public HT_YuukoukknKykList getYuukoukknKykList() {
        return hT_YuukoukknKykList;
    }

    public void setYuukoukknKykList(HT_YuukoukknKykList pHT_YuukoukknKykList) {
        this.hT_YuukoukknKykList = pHT_YuukoukknKykList;
    }

}

