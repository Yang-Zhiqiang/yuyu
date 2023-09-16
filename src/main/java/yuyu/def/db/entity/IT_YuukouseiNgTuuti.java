package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_YuukouseiNgTuuti;

/**
 * 有効性確認ＮＧ通知テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_YuukouseiNgTuuti} の JavaDoc を参照してください。<br />
 * @see     GenIT_YuukouseiNgTuuti<br />
 * @see     PKIT_YuukouseiNgTuuti<br />
 * @see     QIT_YuukouseiNgTuuti<br />
 * @see     GenQIT_YuukouseiNgTuuti<br />
 */
@Entity
public class IT_YuukouseiNgTuuti extends GenIT_YuukouseiNgTuuti {

    private static final long serialVersionUID = 1L;

    public IT_YuukouseiNgTuuti() {
    }

    public IT_YuukouseiNgTuuti(String pKbnkey,String pSyono,BizDate pTyouhyouymd) {
        super(pKbnkey,pSyono,pTyouhyouymd);
    }

    public IT_YuukouseiNgTuuti(String pSyono,BizDate pTyouhyouymd) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTyouhyouymd);
    }


}

