package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.mapping.GenIT_KykSyouhnHnkmae;

/**
 * 契約商品変更前内容テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KykSyouhnHnkmae} の JavaDoc を参照してください。<br />
 * @see     GenIT_KykSyouhnHnkmae<br />
 * @see     PKIT_KykSyouhnHnkmae<br />
 * @see     QIT_KykSyouhnHnkmae<br />
 * @see     GenQIT_KykSyouhnHnkmae<br />
 */
@Entity
public class IT_KykSyouhnHnkmae extends GenIT_KykSyouhnHnkmae {

    private static final long serialVersionUID = 1L;

    public IT_KykSyouhnHnkmae() {
    }

    public IT_KykSyouhnHnkmae(String pKbnkey,String pSyono,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno,Integer pRenno) {
        super(pKbnkey,pSyono,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno,pRenno);
    }

    public IT_KykSyouhnHnkmae(String pSyono,C_SyutkKbn pSyutkkbn,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pSyutkkbn,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno,pRenno);
    }


    private BM_SyouhnZokusei bM_SyouhnZokusei ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=IT_KykSyouhnHnkmae.SYOUHNCD  , referencedColumnName=BM_SyouhnZokusei.SYOUHNCD, insertable=false, updatable=false),
        @JoinColumn(name=IT_KykSyouhnHnkmae.SYOUHNSDNO  , referencedColumnName=BM_SyouhnZokusei.SYOUHNSDNO, insertable=false, updatable=false)
    })
    public  BM_SyouhnZokusei getSyouhnZokusei() {
        return bM_SyouhnZokusei;
    }

    public void setSyouhnZokusei(BM_SyouhnZokusei pBM_SyouhnZokusei) {
        this.bM_SyouhnZokusei = pBM_SyouhnZokusei;
    }

}

