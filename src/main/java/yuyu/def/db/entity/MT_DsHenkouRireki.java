package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenMT_DsHenkouRireki;

/**
 * ＤＳ変更履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsHenkouRireki} の JavaDoc を参照してください。<br />
 * @see     GenMT_DsHenkouRireki<br />
 * @see     PKMT_DsHenkouRireki<br />
 * @see     QMT_DsHenkouRireki<br />
 * @see     GenQMT_DsHenkouRireki<br />
 */
@Entity
public class MT_DsHenkouRireki extends GenMT_DsHenkouRireki {

    private static final long serialVersionUID = 1L;

    public MT_DsHenkouRireki() {
    }

    public MT_DsHenkouRireki(String pDskokno,String pHenkousikibetukey,Integer pRenno) {
        super(pDskokno,pHenkousikibetukey,pRenno);
    }



    private MT_DsTtdkRireki mT_DsTtdkRireki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=MT_DsHenkouRireki.DSKOKNO  , referencedColumnName=MT_DsTtdkRireki.DSKOKNO, insertable=false, updatable=false),
        @JoinColumn(name=MT_DsHenkouRireki.HENKOUSIKIBETUKEY  , referencedColumnName=MT_DsTtdkRireki.HENKOUSIKIBETUKEY, insertable=false, updatable=false)
    })
    public MT_DsTtdkRireki getDsTtdkRireki() {
        return mT_DsTtdkRireki;
    }

    public void setDsTtdkRireki(MT_DsTtdkRireki pMT_DsTtdkRireki) {
        this.mT_DsTtdkRireki = pMT_DsTtdkRireki;
    }

}

