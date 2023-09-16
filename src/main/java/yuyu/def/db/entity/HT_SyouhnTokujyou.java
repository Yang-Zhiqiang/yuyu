package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenHT_SyouhnTokujyou;


/**
 * 商品別特条条件付テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SyouhnTokujyou} の JavaDoc を参照してください。<br />
 * @see     GenHT_SyouhnTokujyou<br />
 * @see     PKHT_SyouhnTokujyou<br />
 * @see     QHT_SyouhnTokujyou<br />
 * @see     GenQHT_SyouhnTokujyou<br />
 */
@Entity
public class HT_SyouhnTokujyou extends GenHT_SyouhnTokujyou {

    private static final long serialVersionUID = 1L;

    public HT_SyouhnTokujyou() {
    }

    public HT_SyouhnTokujyou(String pMosno,String pSyouhncd) {
        super(pMosno,pSyouhncd);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_SyouhnTokujyou.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
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
        @JoinColumn(name=HT_SyouhnTokujyou.SYOUHNCD  , referencedColumnName=BM_SyouhnZokusei.SYOUHNCD, insertable=false, updatable=false),
        @JoinColumn(name=HT_SyouhnTokujyou.SYOUHNSDNO  , referencedColumnName=BM_SyouhnZokusei.SYOUHNSDNO, insertable=false, updatable=false)
    })
    public  BM_SyouhnZokusei getSyouhnZokusei() {
        return bM_SyouhnZokusei;
    }

    public void setSyouhnZokusei(BM_SyouhnZokusei pBM_SyouhnZokusei) {
        this.bM_SyouhnZokusei = pBM_SyouhnZokusei;
    }

}

