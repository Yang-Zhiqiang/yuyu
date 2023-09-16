package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenHT_HubiMsg;


/**
 * 不備メッセージテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_HubiMsg} の JavaDoc を参照してください。<br />
 * @see     GenHT_HubiMsg<br />
 * @see     PKHT_HubiMsg<br />
 * @see     QHT_HubiMsg<br />
 * @see     GenQHT_HubiMsg<br />
 */
@Entity
public class HT_HubiMsg extends GenHT_HubiMsg {

    private static final long serialVersionUID = 1L;

    public HT_HubiMsg() {
    }

    public HT_HubiMsg(String pMosno,Integer pRenno) {
        super(pMosno,pRenno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_HubiMsg.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

