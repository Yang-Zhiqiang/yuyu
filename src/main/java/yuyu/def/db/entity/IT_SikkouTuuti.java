package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_SikkouTuuti;


/**
 * 失効通知テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_SikkouTuuti} の JavaDoc を参照してください。<br />
 * @see     GenIT_SikkouTuuti<br />
 * @see     PKIT_SikkouTuuti<br />
 * @see     QIT_SikkouTuuti<br />
 * @see     GenQIT_SikkouTuuti<br />
 */
@Entity
public class IT_SikkouTuuti extends GenIT_SikkouTuuti {

    private static final long serialVersionUID = 1L;

    public IT_SikkouTuuti() {
    }

    public IT_SikkouTuuti(String pKbnkey,String pSyono,BizDate pTyouhyouymd) {
        super(pKbnkey,pSyono,pTyouhyouymd);
    }

    public IT_SikkouTuuti(String pSyono,BizDate pTyouhyouymd) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTyouhyouymd);
    }


}

