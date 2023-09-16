package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_GinkouMdhnFollowCall;

/**
 * 銀行窓販フォローコール対象テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_GinkouMdhnFollowCall} の JavaDoc を参照してください。<br />
 * @see     GenIT_GinkouMdhnFollowCall<br />
 * @see     PKIT_GinkouMdhnFollowCall<br />
 * @see     QIT_GinkouMdhnFollowCall<br />
 * @see     GenQIT_GinkouMdhnFollowCall<br />
 */
@Entity
public class IT_GinkouMdhnFollowCall extends GenIT_GinkouMdhnFollowCall {

    private static final long serialVersionUID = 1L;

    public IT_GinkouMdhnFollowCall() {
    }

    public IT_GinkouMdhnFollowCall(String pKbnkey,BizDate pSyoriYmd,String pSyono) {
        super(pKbnkey,pSyoriYmd,pSyono);
    }

    public IT_GinkouMdhnFollowCall(BizDate pSyoriYmd,String pSyono) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyoriYmd,pSyono);
    }


}

