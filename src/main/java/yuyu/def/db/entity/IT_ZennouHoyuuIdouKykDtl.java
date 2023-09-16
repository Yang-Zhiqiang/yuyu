package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.id.PKIT_ZennouHoyuuIdouKykDtl;
import yuyu.def.db.mapping.GenIT_ZennouHoyuuIdouKykDtl;
import yuyu.def.db.meta.GenQIT_ZennouHoyuuIdouKykDtl;
import yuyu.def.db.meta.QIT_ZennouHoyuuIdouKykDtl;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

/**
 * 前納保有異動契約明細テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_ZennouHoyuuIdouKykDtl} の JavaDoc を参照してください。
 * @see     GenIT_ZennouHoyuuIdouKykDtl
 * @see     PKIT_ZennouHoyuuIdouKykDtl
 * @see     QIT_ZennouHoyuuIdouKykDtl
 * @see     GenQIT_ZennouHoyuuIdouKykDtl
 */
@Entity
public class IT_ZennouHoyuuIdouKykDtl extends GenIT_ZennouHoyuuIdouKykDtl {

    private static final long serialVersionUID = 1L;

    public IT_ZennouHoyuuIdouKykDtl() {
    }

    public IT_ZennouHoyuuIdouKykDtl(String pKbnkey, String pSyono, BizDate pSakuseiymd, String pSyoricd, Integer pKykmfksnctr) {
        super(pKbnkey, pSyono, pSakuseiymd, pSyoricd, pKykmfksnctr);
    }

    public IT_ZennouHoyuuIdouKykDtl(String pSyono, BizDate pSakuseiymd, String pSyoricd, Integer pKykmfksnctr) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono), pSyono, pSakuseiymd, pSyoricd, pKykmfksnctr);
    }

}
