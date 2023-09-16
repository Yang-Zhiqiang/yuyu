package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_SeihowebMizuhoMinyuuDtl;

/**
 * 生保Ｗｅｂ・みずほ用未入明細テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_SeihowebMizuhoMinyuuDtl} の JavaDoc を参照してください。<br />
 * @see     GenIT_SeihowebMizuhoMinyuuDtl<br />
 * @see     PKIT_SeihowebMizuhoMinyuuDtl<br />
 * @see     QIT_SeihowebMizuhoMinyuuDtl<br />
 * @see     GenQIT_SeihowebMizuhoMinyuuDtl<br />
 */
@Entity
public class IT_SeihowebMizuhoMinyuuDtl extends GenIT_SeihowebMizuhoMinyuuDtl {

    private static final long serialVersionUID = 1L;

    public IT_SeihowebMizuhoMinyuuDtl() {
    }

    public IT_SeihowebMizuhoMinyuuDtl(String pKbnkey,String pSyono,String pDrtencd,String pBosyuucd,BizDateYM pSyoriym) {
        super(pKbnkey,pSyono,pDrtencd,pBosyuucd,pSyoriym);
    }

    public IT_SeihowebMizuhoMinyuuDtl(String pSyono,String pDrtencd,String pBosyuucd,BizDateYM pSyoriym) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pDrtencd,pBosyuucd,pSyoriym);
    }


}

