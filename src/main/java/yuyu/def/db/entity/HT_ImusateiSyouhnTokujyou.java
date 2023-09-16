package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenHT_ImusateiSyouhnTokujyou;


/**
 * 医務査定商品別特条条件付テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_ImusateiSyouhnTokujyou} の JavaDoc を参照してください。<br />
 * @see     GenHT_ImusateiSyouhnTokujyou<br />
 * @see     PKHT_ImusateiSyouhnTokujyou<br />
 * @see     QHT_ImusateiSyouhnTokujyou<br />
 * @see     GenQHT_ImusateiSyouhnTokujyou<br />
 */
@Entity
public class HT_ImusateiSyouhnTokujyou extends GenHT_ImusateiSyouhnTokujyou {

    private static final long serialVersionUID = 1L;

    public HT_ImusateiSyouhnTokujyou() {
    }

    public HT_ImusateiSyouhnTokujyou(String pMosno,Integer pRenno,String pSyouhncd) {
        super(pMosno,pRenno,pSyouhncd);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_ImusateiSyouhnTokujyou.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
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
        @JoinColumn(name=HT_ImusateiSyouhnTokujyou.SYOUHNCD  , referencedColumnName=BM_SyouhnZokusei.SYOUHNCD, insertable=false, updatable=false),
        @JoinColumn(name=HT_ImusateiSyouhnTokujyou.SYOUHNSDNO  , referencedColumnName=BM_SyouhnZokusei.SYOUHNSDNO, insertable=false, updatable=false)
    })
    public  BM_SyouhnZokusei getSyouhnZokusei() {
        return bM_SyouhnZokusei;
    }

    public void setSyouhnZokusei(BM_SyouhnZokusei pBM_SyouhnZokusei) {
        this.bM_SyouhnZokusei = pBM_SyouhnZokusei;
    }

}

