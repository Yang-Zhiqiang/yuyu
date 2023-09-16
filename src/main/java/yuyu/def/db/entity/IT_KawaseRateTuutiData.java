package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;



import yuyu.def.db.mapping.GenIT_KawaseRateTuutiData;


/**
 * 為替レート通知データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KawaseRateTuutiData} の JavaDoc を参照してください。<br />
 * @see     GenIT_KawaseRateTuutiData<br />
 * @see     PKIT_KawaseRateTuutiData<br />
 * @see     QIT_KawaseRateTuutiData<br />
 * @see     GenQIT_KawaseRateTuutiData<br />
 */
@Entity
public class IT_KawaseRateTuutiData extends GenIT_KawaseRateTuutiData {

    private static final long serialVersionUID = 1L;

    public IT_KawaseRateTuutiData() {
    }

    public IT_KawaseRateTuutiData(String pKbnkey,String pSyono,BizDate pTyouhyouymd,Integer pRenno) {
        super(pKbnkey,pSyono,pTyouhyouymd,pRenno);
    }

    public IT_KawaseRateTuutiData(String pSyono,BizDate pTyouhyouymd,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTyouhyouymd,pRenno);
    }


}

