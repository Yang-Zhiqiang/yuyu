package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.mapping.GenMT_DsMailHaisinRireki;

/**
 * ＤＳメール配信履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsMailHaisinRireki} の JavaDoc を参照してください。<br />
 * @see     GenMT_DsMailHaisinRireki<br />
 * @see     PKMT_DsMailHaisinRireki<br />
 * @see     QMT_DsMailHaisinRireki<br />
 * @see     GenQMT_DsMailHaisinRireki<br />
 */
@Entity
public class MT_DsMailHaisinRireki extends GenMT_DsMailHaisinRireki {

    private static final long serialVersionUID = 1L;

    public MT_DsMailHaisinRireki() {
    }

    public MT_DsMailHaisinRireki(BizDate pDsdatasakuseiymd,String pDskokno,Integer pDsmailhaisinrenban) {
        super(pDsdatasakuseiymd,pDskokno,pDsmailhaisinrenban);
    }



    private MT_DsKokyakuKanri mT_DsKokyakuKanri ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_DsMailHaisinRireki.DSKOKNO  , referencedColumnName=MT_DsKokyakuKanri.DSKOKNO, insertable=false, updatable=false)
    })
    public MT_DsKokyakuKanri getDsKokyakuKanri() {
        return mT_DsKokyakuKanri;
    }

    public void setDsKokyakuKanri(MT_DsKokyakuKanri pMT_DsKokyakuKanri) {
        this.mT_DsKokyakuKanri = pMT_DsKokyakuKanri;
    }

}

