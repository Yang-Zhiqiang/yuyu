package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.id.PKMT_DsHaisinErrorList2;
import yuyu.def.db.mapping.GenMT_DsHaisinErrorList2;
import yuyu.def.db.meta.GenQMT_DsHaisinErrorList2;
import yuyu.def.db.meta.QMT_DsHaisinErrorList2;
import jp.co.slcs.swak.date.BizDate;

/**
 * ＤＳ配信エラーリスト２テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsHaisinErrorList2} の JavaDoc を参照してください。
 * @see     GenMT_DsHaisinErrorList2
 * @see     PKMT_DsHaisinErrorList2
 * @see     QMT_DsHaisinErrorList2
 * @see     GenQMT_DsHaisinErrorList2
 */
@Entity
public class MT_DsHaisinErrorList2 extends GenMT_DsHaisinErrorList2 {

    private static final long serialVersionUID = 1L;

    public MT_DsHaisinErrorList2() {
    }

    public MT_DsHaisinErrorList2(BizDate pDsdatasakuseiymd, Integer pDsmailhaisinrenban) {
        super(pDsdatasakuseiymd, pDsmailhaisinrenban);
    }


    private MT_DsKokyakuKanri mT_DsKokyakuKanri ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_DsHaisinErrorList2.DSKOKNO  , referencedColumnName=MT_DsKokyakuKanri.DSKOKNO, insertable=false, updatable=false)
    })
    public MT_DsKokyakuKanri getDsKokyakuKanri() {
        return mT_DsKokyakuKanri;
    }

    public void setDsKokyakuKanri(MT_DsKokyakuKanri pMT_DsKokyakuKanri) {
        this.mT_DsKokyakuKanri = pMT_DsKokyakuKanri;
    }

}
