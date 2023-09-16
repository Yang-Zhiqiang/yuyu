package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.db.mapping.GenMT_DsSoukinyouKouza;

/**
 * ＤＳ送金用口座テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsSoukinyouKouza} の JavaDoc を参照してください。<br />
 * @see     GenMT_DsSoukinyouKouza<br />
 * @see     PKMT_DsSoukinyouKouza<br />
 * @see     QMT_DsSoukinyouKouza<br />
 * @see     GenQMT_DsSoukinyouKouza<br />
 */
@Entity
public class MT_DsSoukinyouKouza extends GenMT_DsSoukinyouKouza {

    private static final long serialVersionUID = 1L;

    public MT_DsSoukinyouKouza() {
    }

    public MT_DsSoukinyouKouza(String pDskokno,String pSyono,C_KouzasyuruiKbn pKzsyuruikbn) {
        super(pDskokno,pSyono,pKzsyuruikbn);
    }



    private MT_DsTorihikiServiceKanri mT_DsTorihikiServiceKanri ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_DsSoukinyouKouza.DSKOKNO  , referencedColumnName=MT_DsTorihikiServiceKanri.DSKOKNO, insertable=false, updatable=false),
        @JoinColumn(name=MT_DsSoukinyouKouza.SYONO  , referencedColumnName=MT_DsTorihikiServiceKanri.SYONO, insertable=false, updatable=false)
    })
    public MT_DsTorihikiServiceKanri getDsTorihikiServiceKanri() {
        return mT_DsTorihikiServiceKanri;
    }

    public void setDsTorihikiServiceKanri(MT_DsTorihikiServiceKanri pMT_DsTorihikiServiceKanri) {
        this.mT_DsTorihikiServiceKanri = pMT_DsTorihikiServiceKanri;
    }

    private BM_Ginkou bM_Ginkou ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=MT_DsSoukinyouKouza.BANKCD  , referencedColumnName=BM_Ginkou.BANKCD, insertable=false, updatable=false),
        @JoinColumn(name=MT_DsSoukinyouKouza.SITENCD  , referencedColumnName=BM_Ginkou.SITENCD, insertable=false, updatable=false)
    })
    public  BM_Ginkou getGinkou() {
        return bM_Ginkou;
    }

    public void setGinkou(BM_Ginkou pBM_Ginkou) {
        this.bM_Ginkou = pBM_Ginkou;
    }

}

