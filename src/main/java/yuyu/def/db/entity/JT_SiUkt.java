package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.db.mapping.GenJT_SiUkt;


/**
 * 支払受取人テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SiUkt} の JavaDoc を参照してください。<br />
 * @see     GenJT_SiUkt<br />
 * @see     PKJT_SiUkt<br />
 * @see     QJT_SiUkt<br />
 * @see     GenQJT_SiUkt<br />
 */
@Entity
public class JT_SiUkt extends GenJT_SiUkt {

    private static final long serialVersionUID = 1L;

    public JT_SiUkt() {
    }

    public JT_SiUkt(String pSyono,C_Hkuktsyu pHkuktsyu,Integer pUktsyurenno) {
        super(pSyono,pHkuktsyu,pUktsyurenno);
    }



    private JT_SiKykKihon jT_SiKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_SiUkt.SYONO  , referencedColumnName=JT_SiKykKihon.SYONO, insertable=false, updatable=false)
    })
    public JT_SiKykKihon getSiKykKihon() {
        return jT_SiKykKihon;
    }

    public void setSiKykKihon(JT_SiKykKihon pJT_SiKykKihon) {
        this.jT_SiKykKihon = pJT_SiKykKihon;
    }

}

