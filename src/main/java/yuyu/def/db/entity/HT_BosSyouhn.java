package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenHT_BosSyouhn;


/**
 * 募集商品テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_BosSyouhn} の JavaDoc を参照してください。<br />
 * @see     GenHT_BosSyouhn<br />
 * @see     PKHT_BosSyouhn<br />
 * @see     QHT_BosSyouhn<br />
 * @see     GenQHT_BosSyouhn<br />
 */
@Entity
public class HT_BosSyouhn extends GenHT_BosSyouhn {

    private static final long serialVersionUID = 1L;

    public HT_BosSyouhn() {
    }

    public HT_BosSyouhn(String pMosno,String pSyouhncd) {
        super(pMosno,pSyouhncd);
    }



    private HT_BosKihon hT_BosKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_BosSyouhn.MOSNO  , referencedColumnName=HT_BosKihon.MOSNO, insertable=false, updatable=false)
    })
    public HT_BosKihon getBosKihon() {
        return hT_BosKihon;
    }

    public void setBosKihon(HT_BosKihon pHT_BosKihon) {
        this.hT_BosKihon = pHT_BosKihon;
    }

    private BM_SyouhnZokusei bM_SyouhnZokusei ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_BosSyouhn.SYOUHNCD  , referencedColumnName=BM_SyouhnZokusei.SYOUHNCD, insertable=false, updatable=false),
        @JoinColumn(name=HT_BosSyouhn.SYOUHNSDNO  , referencedColumnName=BM_SyouhnZokusei.SYOUHNSDNO, insertable=false, updatable=false)
    })
    public  BM_SyouhnZokusei getSyouhnZokusei() {
        return bM_SyouhnZokusei;
    }

    public void setSyouhnZokusei(BM_SyouhnZokusei pBM_SyouhnZokusei) {
        this.bM_SyouhnZokusei = pBM_SyouhnZokusei;
    }

}

