package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_Segcd;
import yuyu.def.db.mapping.GenIT_KessanZennou;

/**
 * 決算用前納テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KessanZennou} の JavaDoc を参照してください。<br />
 * @see     GenIT_KessanZennou<br />
 * @see     PKIT_KessanZennou<br />
 * @see     QIT_KessanZennou<br />
 * @see     GenQIT_KessanZennou<br />
 */
@Entity
public class IT_KessanZennou extends GenIT_KessanZennou {

    private static final long serialVersionUID = 1L;

    public IT_KessanZennou() {
    }

    public IT_KessanZennou(String pKbnkey,String pSyono,C_Segcd pKbnkeirisegcd,String pZennoukbn,String pZennoutoukeilistkbn,BizDateYM pZennoustartym) {
        super(pKbnkey,pSyono,pKbnkeirisegcd,pZennoukbn,pZennoutoukeilistkbn,pZennoustartym);
    }

    public IT_KessanZennou(String pSyono,C_Segcd pKbnkeirisegcd,String pZennoukbn,String pZennoutoukeilistkbn,BizDateYM pZennoustartym) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pKbnkeirisegcd,pZennoukbn,pZennoutoukeilistkbn,pZennoustartym);
    }


}

