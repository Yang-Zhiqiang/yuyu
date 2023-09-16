package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouToukeiListKbn;
import yuyu.def.db.id.PKIT_ZennouKessan;
import yuyu.def.db.mapping.GenIT_ZennouKessan;
import yuyu.def.db.meta.GenQIT_ZennouKessan;
import yuyu.def.db.meta.QIT_ZennouKessan;

/**
 * 前納決算テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_ZennouKessan} の JavaDoc を参照してください。
 * @see     GenIT_ZennouKessan
 * @see     PKIT_ZennouKessan
 * @see     QIT_ZennouKessan
 * @see     GenQIT_ZennouKessan
 */
@Entity
public class IT_ZennouKessan extends GenIT_ZennouKessan {

    private static final long serialVersionUID = 1L;

    public IT_ZennouKessan() {
    }

    public IT_ZennouKessan(String pKbnkey, String pSyono, BizDate pSakuseiymd, C_Segcd pKbnkeirisegcd, C_ZennouKbn pZennoukbn, C_ZennouToukeiListKbn pZennoutoukeilistkbn, BizDateYM pZennoustartym) {
        super(pKbnkey, pSyono, pSakuseiymd, pKbnkeirisegcd, pZennoukbn, pZennoutoukeilistkbn, pZennoustartym);
    }

    public IT_ZennouKessan(String pSyono, BizDate pSakuseiymd, C_Segcd pKbnkeirisegcd, C_ZennouKbn pZennoukbn, C_ZennouToukeiListKbn pZennoutoukeilistkbn, BizDateYM pZennoustartym) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono), pSyono, pSakuseiymd, pKbnkeirisegcd, pZennoukbn, pZennoutoukeilistkbn, pZennoustartym);
    }

}
