package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.mapping.GenMT_DsHaisinErrorList;

/**
 * ＤＳ配信エラーリストテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsHaisinErrorList} の JavaDoc を参照してください。<br />
 * @see     GenMT_DsHaisinErrorList<br />
 * @see     PKMT_DsHaisinErrorList<br />
 * @see     QMT_DsHaisinErrorList<br />
 * @see     GenQMT_DsHaisinErrorList<br />
 */
@Entity
public class MT_DsHaisinErrorList extends GenMT_DsHaisinErrorList {

    private static final long serialVersionUID = 1L;

    public MT_DsHaisinErrorList() {
    }

    public MT_DsHaisinErrorList(BizDate pDsdatasakuseiymd,String pDskokno,Integer pDsmailaddressrenban) {
        super(pDsdatasakuseiymd,pDskokno,pDsmailaddressrenban);
    }



    private MT_DsKokyakuKanri mT_DsKokyakuKanri ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_DsHaisinErrorList.DSKOKNO  , referencedColumnName=MT_DsKokyakuKanri.DSKOKNO, insertable=false, updatable=false)
    })
    public MT_DsKokyakuKanri getDsKokyakuKanri() {
        return mT_DsKokyakuKanri;
    }

    public void setDsKokyakuKanri(MT_DsKokyakuKanri pMT_DsKokyakuKanri) {
        this.mT_DsKokyakuKanri = pMT_DsKokyakuKanri;
    }

}

