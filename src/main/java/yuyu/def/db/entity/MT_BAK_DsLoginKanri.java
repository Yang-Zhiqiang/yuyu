package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenMT_BAK_DsLoginKanri;

/**
 * ＤＳログイン管理バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_BAK_DsLoginKanri} の JavaDoc を参照してください。<br />
 * @see     GenMT_BAK_DsLoginKanri<br />
 * @see     PKMT_BAK_DsLoginKanri<br />
 * @see     QMT_BAK_DsLoginKanri<br />
 * @see     GenQMT_BAK_DsLoginKanri<br />
 */
@Entity
public class MT_BAK_DsLoginKanri extends GenMT_BAK_DsLoginKanri {

    private static final long serialVersionUID = 1L;

    public MT_BAK_DsLoginKanri() {
    }

    public MT_BAK_DsLoginKanri(String pDskokno,String pTrkssikibetukey) {
        super(pDskokno,pTrkssikibetukey);
    }



    private MT_BAK_DsKokyakuKanri mT_BAKDsKokyakuKanri ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_BAK_DsLoginKanri.DSKOKNO  , referencedColumnName=MT_BAK_DsKokyakuKanri.DSKOKNO, insertable=false, updatable=false),
        @JoinColumn(name=MT_BAK_DsLoginKanri.TRKSSIKIBETUKEY  , referencedColumnName=MT_BAK_DsKokyakuKanri.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public MT_BAK_DsKokyakuKanri getBAKDsKokyakuKanri() {
        return mT_BAKDsKokyakuKanri;
    }

    public void setBAKDsKokyakuKanri(MT_BAK_DsKokyakuKanri pMT_BAK_DsKokyakuKanri) {
        this.mT_BAKDsKokyakuKanri = pMT_BAK_DsKokyakuKanri;
    }

}

