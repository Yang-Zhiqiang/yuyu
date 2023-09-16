package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenMT_BAK_DsTorihikiyouAnsyono;

/**
 * ＤＳ特定取引用暗証番号バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_BAK_DsTorihikiyouAnsyono} の JavaDoc を参照してください。<br />
 * @see     GenMT_BAK_DsTorihikiyouAnsyono<br />
 * @see     PKMT_BAK_DsTorihikiyouAnsyono<br />
 * @see     QMT_BAK_DsTorihikiyouAnsyono<br />
 * @see     GenQMT_BAK_DsTorihikiyouAnsyono<br />
 */
@Entity
public class MT_BAK_DsTorihikiyouAnsyono extends GenMT_BAK_DsTorihikiyouAnsyono {

    private static final long serialVersionUID = 1L;

    public MT_BAK_DsTorihikiyouAnsyono() {
    }

    public MT_BAK_DsTorihikiyouAnsyono(String pDskokno,String pSyono,String pTrkssikibetukey) {
        super(pDskokno,pSyono,pTrkssikibetukey);
    }



    private MT_BAK_DsTorihikiServiceKanri mT_BAKDsTorihikiServiceKanri ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_BAK_DsTorihikiyouAnsyono.DSKOKNO  , referencedColumnName=MT_BAK_DsTorihikiServiceKanri.DSKOKNO, insertable=false, updatable=false),
        @JoinColumn(name=MT_BAK_DsTorihikiyouAnsyono.SYONO  , referencedColumnName=MT_BAK_DsTorihikiServiceKanri.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=MT_BAK_DsTorihikiyouAnsyono.TRKSSIKIBETUKEY  , referencedColumnName=MT_BAK_DsTorihikiServiceKanri.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public MT_BAK_DsTorihikiServiceKanri getBAKDsTorihikiServiceKanri() {
        return mT_BAKDsTorihikiServiceKanri;
    }

    public void setBAKDsTorihikiServiceKanri(MT_BAK_DsTorihikiServiceKanri pMT_BAK_DsTorihikiServiceKanri) {
        this.mT_BAKDsTorihikiServiceKanri = pMT_BAK_DsTorihikiServiceKanri;
    }

}

