package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_SyoumetuTuuti;


/**
 * 消滅通知テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_SyoumetuTuuti} の JavaDoc を参照してください。<br />
 * @see     GenIT_SyoumetuTuuti<br />
 * @see     PKIT_SyoumetuTuuti<br />
 * @see     QIT_SyoumetuTuuti<br />
 * @see     GenQIT_SyoumetuTuuti<br />
 */
@Entity
public class IT_SyoumetuTuuti extends GenIT_SyoumetuTuuti {

    private static final long serialVersionUID = 1L;

    public IT_SyoumetuTuuti() {
    }

    public IT_SyoumetuTuuti(String pKbnkey,String pSyono,BizDate pTyouhyouymd) {
        super(pKbnkey,pSyono,pTyouhyouymd);
    }

    public IT_SyoumetuTuuti(String pSyono,BizDate pTyouhyouymd) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTyouhyouymd);
    }


}

