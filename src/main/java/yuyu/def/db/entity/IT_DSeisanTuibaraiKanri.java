package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateY;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_DSeisanTuibaraiKanri;

/**
 * Ｄ精算追払管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_DSeisanTuibaraiKanri} の JavaDoc を参照してください。<br />
 * @see     GenIT_DSeisanTuibaraiKanri<br />
 * @see     PKIT_DSeisanTuibaraiKanri<br />
 * @see     QIT_DSeisanTuibaraiKanri<br />
 * @see     GenQIT_DSeisanTuibaraiKanri<br />
 */
@Entity
public class IT_DSeisanTuibaraiKanri extends GenIT_DSeisanTuibaraiKanri {

    private static final long serialVersionUID = 1L;

    public IT_DSeisanTuibaraiKanri() {
    }

    public IT_DSeisanTuibaraiKanri(String pKbnkey,String pSyono,BizDateY pHaitounendo) {
        super(pKbnkey,pSyono,pHaitounendo);
    }

    public IT_DSeisanTuibaraiKanri(String pSyono,BizDateY pHaitounendo) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHaitounendo);
    }


}

