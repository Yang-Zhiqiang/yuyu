package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KoujyoSym;


/**
 * 控除証明書テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KoujyoSym} の JavaDoc を参照してください。<br />
 * @see     GenIT_KoujyoSym<br />
 * @see     PKIT_KoujyoSym<br />
 * @see     QIT_KoujyoSym<br />
 * @see     GenQIT_KoujyoSym<br />
 */
@Entity
public class IT_KoujyoSym extends GenIT_KoujyoSym {

    private static final long serialVersionUID = 1L;

    public IT_KoujyoSym() {
    }

    public IT_KoujyoSym(String pKbnkey,String pSyono,String pNendo,BizDate pTyouhyouymd,Integer pRenno) {
        super(pKbnkey,pSyono,pNendo,pTyouhyouymd,pRenno);
    }

    public IT_KoujyoSym(String pSyono,String pNendo,BizDate pTyouhyouymd,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pNendo,pTyouhyouymd,pRenno);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_KoujyoSym.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_KoujyoSym.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

