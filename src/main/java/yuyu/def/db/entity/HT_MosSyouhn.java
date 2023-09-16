package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenHT_MosSyouhn;


/**
 * 申込商品テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_MosSyouhn} の JavaDoc を参照してください。<br />
 * @see     GenHT_MosSyouhn<br />
 * @see     PKHT_MosSyouhn<br />
 * @see     QHT_MosSyouhn<br />
 * @see     GenQHT_MosSyouhn<br />
 */
@Entity
public class HT_MosSyouhn extends GenHT_MosSyouhn {

    private static final long serialVersionUID = 1L;

    public HT_MosSyouhn() {
    }

    public HT_MosSyouhn(String pMosno,String pSyouhncd) {
        super(pMosno,pSyouhncd);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_MosSyouhn.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

    private BM_SyouhnZokusei bM_SyouhnZokusei ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_MosSyouhn.SYOUHNCD  , referencedColumnName=BM_SyouhnZokusei.SYOUHNCD, insertable=false, updatable=false),
        @JoinColumn(name=HT_MosSyouhn.SYOUHNSDNO  , referencedColumnName=BM_SyouhnZokusei.SYOUHNSDNO, insertable=false, updatable=false)
    })
    public  BM_SyouhnZokusei getSyouhnZokusei() {
        return bM_SyouhnZokusei;
    }

    public void setSyouhnZokusei(BM_SyouhnZokusei pBM_SyouhnZokusei) {
        this.bM_SyouhnZokusei = pBM_SyouhnZokusei;
    }

}

