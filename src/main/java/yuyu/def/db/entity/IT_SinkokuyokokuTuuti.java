package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_SinkokuyokokuTuuti;


/**
 * 申告予告通知テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_SinkokuyokokuTuuti} の JavaDoc を参照してください。<br />
 * @see     GenIT_SinkokuyokokuTuuti<br />
 * @see     PKIT_SinkokuyokokuTuuti<br />
 * @see     QIT_SinkokuyokokuTuuti<br />
 * @see     GenQIT_SinkokuyokokuTuuti<br />
 */
@Entity
public class IT_SinkokuyokokuTuuti extends GenIT_SinkokuyokokuTuuti {

    private static final long serialVersionUID = 1L;

    public IT_SinkokuyokokuTuuti() {
    }

    public IT_SinkokuyokokuTuuti(String pKbnkey,String pSyono,String pNendo,BizDate pTyouhyouymd,Integer pRenno) {
        super(pKbnkey,pSyono,pNendo,pTyouhyouymd,pRenno);
    }

    public IT_SinkokuyokokuTuuti(String pSyono,String pNendo,BizDate pTyouhyouymd,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pNendo,pTyouhyouymd,pRenno);
    }


}

