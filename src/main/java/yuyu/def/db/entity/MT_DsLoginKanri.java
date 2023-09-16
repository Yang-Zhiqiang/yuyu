package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenMT_DsLoginKanri;

/**
 * ＤＳログイン管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsLoginKanri} の JavaDoc を参照してください。<br />
 * @see     GenMT_DsLoginKanri<br />
 * @see     PKMT_DsLoginKanri<br />
 * @see     QMT_DsLoginKanri<br />
 * @see     GenQMT_DsLoginKanri<br />
 */
@Entity
public class MT_DsLoginKanri extends GenMT_DsLoginKanri {

    private static final long serialVersionUID = 1L;

    public MT_DsLoginKanri() {
    }

    public MT_DsLoginKanri(String pDskokno) {
        super(pDskokno);
    }



    private MT_DsKokyakuKanri mT_DsKokyakuKanri ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_DsLoginKanri.DSKOKNO  , referencedColumnName=MT_DsKokyakuKanri.DSKOKNO, insertable=false, updatable=false)
    })
    public MT_DsKokyakuKanri getDsKokyakuKanri() {
        return mT_DsKokyakuKanri;
    }

    public void setDsKokyakuKanri(MT_DsKokyakuKanri pMT_DsKokyakuKanri) {
        this.mT_DsKokyakuKanri = pMT_DsKokyakuKanri;
    }

}

