package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.db.mapping.GenMT_BAK_DsSoukinyouKouza;

/**
 * ＤＳ送金用口座バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_BAK_DsSoukinyouKouza} の JavaDoc を参照してください。<br />
 * @see     GenMT_BAK_DsSoukinyouKouza<br />
 * @see     PKMT_BAK_DsSoukinyouKouza<br />
 * @see     QMT_BAK_DsSoukinyouKouza<br />
 * @see     GenQMT_BAK_DsSoukinyouKouza<br />
 */
@Entity
public class MT_BAK_DsSoukinyouKouza extends GenMT_BAK_DsSoukinyouKouza {

    private static final long serialVersionUID = 1L;

    public MT_BAK_DsSoukinyouKouza() {
    }

    public MT_BAK_DsSoukinyouKouza(String pDskokno,String pSyono,C_KouzasyuruiKbn pKzsyuruikbn,String pTrkssikibetukey) {
        super(pDskokno,pSyono,pKzsyuruikbn,pTrkssikibetukey);
    }



    private MT_BAK_DsTorihikiServiceKanri mT_BAKDsTorihikiServiceKanri ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_BAK_DsSoukinyouKouza.DSKOKNO  , referencedColumnName=MT_BAK_DsTorihikiServiceKanri.DSKOKNO, insertable=false, updatable=false),
        @JoinColumn(name=MT_BAK_DsSoukinyouKouza.SYONO  , referencedColumnName=MT_BAK_DsTorihikiServiceKanri.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=MT_BAK_DsSoukinyouKouza.TRKSSIKIBETUKEY  , referencedColumnName=MT_BAK_DsTorihikiServiceKanri.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public MT_BAK_DsTorihikiServiceKanri getBAKDsTorihikiServiceKanri() {
        return mT_BAKDsTorihikiServiceKanri;
    }

    public void setBAKDsTorihikiServiceKanri(MT_BAK_DsTorihikiServiceKanri pMT_BAK_DsTorihikiServiceKanri) {
        this.mT_BAKDsTorihikiServiceKanri = pMT_BAK_DsTorihikiServiceKanri;
    }

}

