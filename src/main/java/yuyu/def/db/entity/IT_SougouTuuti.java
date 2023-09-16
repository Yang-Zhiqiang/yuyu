package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_SougouTuuti;


/**
 * 総合通知テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_SougouTuuti} の JavaDoc を参照してください。<br />
 * @see     GenIT_SougouTuuti<br />
 * @see     PKIT_SougouTuuti<br />
 * @see     QIT_SougouTuuti<br />
 * @see     GenQIT_SougouTuuti<br />
 */
@Entity
public class IT_SougouTuuti extends GenIT_SougouTuuti {

    private static final long serialVersionUID = 1L;

    public IT_SougouTuuti() {
    }

    public IT_SougouTuuti(String pKbnkey,String pSyono,BizDate pTyouhyouymd) {
        super(pKbnkey,pSyono,pTyouhyouymd);
    }

    public IT_SougouTuuti(String pSyono,BizDate pTyouhyouymd) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTyouhyouymd);
    }


}

