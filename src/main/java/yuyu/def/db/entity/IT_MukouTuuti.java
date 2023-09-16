package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_MukouTuuti;


/**
 * 無効通知テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_MukouTuuti} の JavaDoc を参照してください。<br />
 * @see     GenIT_MukouTuuti<br />
 * @see     PKIT_MukouTuuti<br />
 * @see     QIT_MukouTuuti<br />
 * @see     GenQIT_MukouTuuti<br />
 */
@Entity
public class IT_MukouTuuti extends GenIT_MukouTuuti {

    private static final long serialVersionUID = 1L;

    public IT_MukouTuuti() {
    }

    public IT_MukouTuuti(String pKbnkey,String pSyono,BizDate pTyouhyouymd) {
        super(pKbnkey,pSyono,pTyouhyouymd);
    }

    public IT_MukouTuuti(String pSyono,BizDate pTyouhyouymd) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTyouhyouymd);
    }


}

