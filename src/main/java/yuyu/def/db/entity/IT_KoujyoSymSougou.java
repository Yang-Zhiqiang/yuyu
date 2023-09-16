package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KoujyoSymSougou;


/**
 * 控除証明書（総合通知用）テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KoujyoSymSougou} の JavaDoc を参照してください。<br />
 * @see     GenIT_KoujyoSymSougou<br />
 * @see     PKIT_KoujyoSymSougou<br />
 * @see     QIT_KoujyoSymSougou<br />
 * @see     GenQIT_KoujyoSymSougou<br />
 */
@Entity
public class IT_KoujyoSymSougou extends GenIT_KoujyoSymSougou {

    private static final long serialVersionUID = 1L;

    public IT_KoujyoSymSougou() {
    }

    public IT_KoujyoSymSougou(String pKbnkey,String pSyono,String pNendo,BizDate pTyouhyouymd,Integer pRenno) {
        super(pKbnkey,pSyono,pNendo,pTyouhyouymd,pRenno);
    }

    public IT_KoujyoSymSougou(String pSyono,String pNendo,BizDate pTyouhyouymd,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pNendo,pTyouhyouymd,pRenno);
    }


}

