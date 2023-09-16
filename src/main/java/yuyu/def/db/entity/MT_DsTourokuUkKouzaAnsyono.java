package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.classification.C_DsTtdksyubetuKbn;
import yuyu.def.db.mapping.GenMT_DsTourokuUkKouzaAnsyono;

/**
 * ＤＳ登録受付（口座暗証番号）テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsTourokuUkKouzaAnsyono} の JavaDoc を参照してください。<br />
 * @see     GenMT_DsTourokuUkKouzaAnsyono<br />
 * @see     PKMT_DsTourokuUkKouzaAnsyono<br />
 * @see     QMT_DsTourokuUkKouzaAnsyono<br />
 * @see     GenQMT_DsTourokuUkKouzaAnsyono<br />
 */
@Entity
public class MT_DsTourokuUkKouzaAnsyono extends GenMT_DsTourokuUkKouzaAnsyono {

    private static final long serialVersionUID = 1L;

    public MT_DsTourokuUkKouzaAnsyono() {
    }

    public MT_DsTourokuUkKouzaAnsyono(String pSyono,C_DsTtdksyubetuKbn pDsttdksyubetukbn,Integer pDatarenno) {
        super(pSyono,pDsttdksyubetukbn,pDatarenno);
    }



    private MT_DsTourokuUkKanri mT_DsTourokuUkKanri ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_DsTourokuUkKouzaAnsyono.SYONO  , referencedColumnName=MT_DsTourokuUkKanri.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=MT_DsTourokuUkKouzaAnsyono.DSTTDKSYUBETUKBN  , referencedColumnName=MT_DsTourokuUkKanri.DSTTDKSYUBETUKBN, insertable=false, updatable=false),
        @JoinColumn(name=MT_DsTourokuUkKouzaAnsyono.DATARENNO  , referencedColumnName=MT_DsTourokuUkKanri.DATARENNO, insertable=false, updatable=false)
    })
    public MT_DsTourokuUkKanri getDsTourokuUkKanri() {
        return mT_DsTourokuUkKanri;
    }

    public void setDsTourokuUkKanri(MT_DsTourokuUkKanri pMT_DsTourokuUkKanri) {
        this.mT_DsTourokuUkKanri = pMT_DsTourokuUkKanri;
    }

}

