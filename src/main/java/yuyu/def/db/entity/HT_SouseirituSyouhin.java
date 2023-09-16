package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenHT_SouseirituSyouhin;


/**
 * 総成立商品テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SouseirituSyouhin} の JavaDoc を参照してください。<br />
 * @see     GenHT_SouseirituSyouhin<br />
 * @see     PKHT_SouseirituSyouhin<br />
 * @see     QHT_SouseirituSyouhin<br />
 * @see     GenQHT_SouseirituSyouhin<br />
 */
@Entity
public class HT_SouseirituSyouhin extends GenHT_SouseirituSyouhin {

    private static final long serialVersionUID = 1L;

    public HT_SouseirituSyouhin() {
    }

    public HT_SouseirituSyouhin(String pSyono,String pSyouhncd) {
        super(pSyono,pSyouhncd);
    }



    private HT_SouseirituKihon hT_SouseirituKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_SouseirituSyouhin.SYONO  , referencedColumnName=HT_SouseirituKihon.SYONO, insertable=false, updatable=false)
    })
    public HT_SouseirituKihon getSouseirituKihon() {
        return hT_SouseirituKihon;
    }

    public void setSouseirituKihon(HT_SouseirituKihon pHT_SouseirituKihon) {
        this.hT_SouseirituKihon = pHT_SouseirituKihon;
    }

    private BM_SyouhnZokusei bM_SyouhnZokusei ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_SouseirituSyouhin.SYOUHNCD  , referencedColumnName=BM_SyouhnZokusei.SYOUHNCD, insertable=false, updatable=false),
        @JoinColumn(name=HT_SouseirituSyouhin.SYOUHNSDNO  , referencedColumnName=BM_SyouhnZokusei.SYOUHNSDNO, insertable=false, updatable=false)
    })
    public  BM_SyouhnZokusei getSyouhnZokusei() {
        return bM_SyouhnZokusei;
    }

    public void setSyouhnZokusei(BM_SyouhnZokusei pBM_SyouhnZokusei) {
        this.bM_SyouhnZokusei = pBM_SyouhnZokusei;
    }

}

