package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenHT_SyouhnTokujyouRireki;


/**
 * 商品別特条条件付履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SyouhnTokujyouRireki} の JavaDoc を参照してください。<br />
 * @see     GenHT_SyouhnTokujyouRireki<br />
 * @see     PKHT_SyouhnTokujyouRireki<br />
 * @see     QHT_SyouhnTokujyouRireki<br />
 * @see     GenQHT_SyouhnTokujyouRireki<br />
 */
@Entity
public class HT_SyouhnTokujyouRireki extends GenHT_SyouhnTokujyouRireki {

    private static final long serialVersionUID = 1L;

    public HT_SyouhnTokujyouRireki() {
    }

    public HT_SyouhnTokujyouRireki(String pMosno,Integer pDakuhiktrenno,String pSyouhncd) {
        super(pMosno,pDakuhiktrenno,pSyouhncd);
    }



    private HT_DakuhiKettei hT_DakuhiKettei ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_SyouhnTokujyouRireki.MOSNO  , referencedColumnName=HT_DakuhiKettei.MOSNO, insertable=false, updatable=false),
        @JoinColumn(name=HT_SyouhnTokujyouRireki.DAKUHIKTRENNO  , referencedColumnName=HT_DakuhiKettei.DAKUHIKTRENNO, insertable=false, updatable=false)
    })
    public HT_DakuhiKettei getDakuhiKettei() {
        return hT_DakuhiKettei;
    }

    public void setDakuhiKettei(HT_DakuhiKettei pHT_DakuhiKettei) {
        this.hT_DakuhiKettei = pHT_DakuhiKettei;
    }

    private BM_SyouhnZokusei bM_SyouhnZokusei ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_SyouhnTokujyouRireki.SYOUHNCD  , referencedColumnName=BM_SyouhnZokusei.SYOUHNCD, insertable=false, updatable=false),
        @JoinColumn(name=HT_SyouhnTokujyouRireki.SYOUHNSDNO  , referencedColumnName=BM_SyouhnZokusei.SYOUHNSDNO, insertable=false, updatable=false)
    })
    public  BM_SyouhnZokusei getSyouhnZokusei() {
        return bM_SyouhnZokusei;
    }

    public void setSyouhnZokusei(BM_SyouhnZokusei pBM_SyouhnZokusei) {
        this.bM_SyouhnZokusei = pBM_SyouhnZokusei;
    }

}

