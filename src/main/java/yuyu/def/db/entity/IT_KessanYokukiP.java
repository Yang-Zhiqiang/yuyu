package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KessanYokukiP;

/**
 * 決算用翌期Ｐテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KessanYokukiP} の JavaDoc を参照してください。<br />
 * @see     GenIT_KessanYokukiP<br />
 * @see     PKIT_KessanYokukiP<br />
 * @see     QIT_KessanYokukiP<br />
 * @see     GenQIT_KessanYokukiP<br />
 */
@Entity
public class IT_KessanYokukiP extends GenIT_KessanYokukiP {

    private static final long serialVersionUID = 1L;

    public IT_KessanYokukiP() {
    }

    public IT_KessanYokukiP(String pKbnkey,BizDateYM pKeijyouym,String pSyono) {
        super(pKbnkey,pKeijyouym,pSyono);
    }

    public IT_KessanYokukiP(BizDateYM pKeijyouym,String pSyono) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pKeijyouym,pSyono);
    }


}

