package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateY;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_SeisanDHaneiTuuti;

/**
 * 精算Ｄ反映通知テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_SeisanDHaneiTuuti} の JavaDoc を参照してください。<br />
 * @see     GenIT_SeisanDHaneiTuuti<br />
 * @see     PKIT_SeisanDHaneiTuuti<br />
 * @see     QIT_SeisanDHaneiTuuti<br />
 * @see     GenQIT_SeisanDHaneiTuuti<br />
 */
@Entity
public class IT_SeisanDHaneiTuuti extends GenIT_SeisanDHaneiTuuti {

    private static final long serialVersionUID = 1L;

    public IT_SeisanDHaneiTuuti() {
    }

    public IT_SeisanDHaneiTuuti(String pKbnkey,String pSyono,BizDateY pHaitounendo) {
        super(pKbnkey,pSyono,pHaitounendo);
    }

    public IT_SeisanDHaneiTuuti(String pSyono,BizDateY pHaitounendo) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHaitounendo);
    }


}

