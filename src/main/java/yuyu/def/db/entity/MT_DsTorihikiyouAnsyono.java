package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenMT_DsTorihikiyouAnsyono;

/**
 * ＤＳ特定取引用暗証番号テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsTorihikiyouAnsyono} の JavaDoc を参照してください。<br />
 * @see     GenMT_DsTorihikiyouAnsyono<br />
 * @see     PKMT_DsTorihikiyouAnsyono<br />
 * @see     QMT_DsTorihikiyouAnsyono<br />
 * @see     GenQMT_DsTorihikiyouAnsyono<br />
 */
@Entity
public class MT_DsTorihikiyouAnsyono extends GenMT_DsTorihikiyouAnsyono {

    private static final long serialVersionUID = 1L;

    public MT_DsTorihikiyouAnsyono() {
    }

    public MT_DsTorihikiyouAnsyono(String pDskokno,String pSyono) {
        super(pDskokno,pSyono);
    }



    private MT_DsTorihikiServiceKanri mT_DsTorihikiServiceKanri ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_DsTorihikiyouAnsyono.DSKOKNO  , referencedColumnName=MT_DsTorihikiServiceKanri.DSKOKNO, insertable=false, updatable=false),
        @JoinColumn(name=MT_DsTorihikiyouAnsyono.SYONO  , referencedColumnName=MT_DsTorihikiServiceKanri.SYONO, insertable=false, updatable=false)
    })
    public MT_DsTorihikiServiceKanri getDsTorihikiServiceKanri() {
        return mT_DsTorihikiServiceKanri;
    }

    public void setDsTorihikiServiceKanri(MT_DsTorihikiServiceKanri pMT_DsTorihikiServiceKanri) {
        this.mT_DsTorihikiServiceKanri = pMT_DsTorihikiServiceKanri;
    }

}

