package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_DSeisanShrTysySyusei;

/**
 * Ｄ精算支払調書修正テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_DSeisanShrTysySyusei} の JavaDoc を参照してください。<br />
 * @see     GenIT_DSeisanShrTysySyusei<br />
 * @see     PKIT_DSeisanShrTysySyusei<br />
 * @see     QIT_DSeisanShrTysySyusei<br />
 * @see     GenQIT_DSeisanShrTysySyusei<br />
 */
@Entity
public class IT_DSeisanShrTysySyusei extends GenIT_DSeisanShrTysySyusei {

    private static final long serialVersionUID = 1L;

    public IT_DSeisanShrTysySyusei() {
    }

    public IT_DSeisanShrTysySyusei(String pKbnkey,String pSyono,BizDate pSyoriYmd) {
        super(pKbnkey,pSyono,pSyoriYmd);
    }

    public IT_DSeisanShrTysySyusei(String pSyono,BizDate pSyoriYmd) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pSyoriYmd);
    }


}

