package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.id.PKIT_BAK_KhTumitateDKanri;
import yuyu.def.db.mapping.GenIT_BAK_KhTumitateDKanri;
import yuyu.def.db.meta.GenQIT_BAK_KhTumitateDKanri;
import yuyu.def.db.meta.QIT_BAK_KhTumitateDKanri;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

/**
 * 積立Ｄ管理バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KhTumitateDKanri} の JavaDoc を参照してください。
 * @see     GenIT_BAK_KhTumitateDKanri
 * @see     PKIT_BAK_KhTumitateDKanri
 * @see     QIT_BAK_KhTumitateDKanri
 * @see     GenQIT_BAK_KhTumitateDKanri
 */
@Entity
public class IT_BAK_KhTumitateDKanri extends GenIT_BAK_KhTumitateDKanri {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KhTumitateDKanri() {
    }

    public IT_BAK_KhTumitateDKanri(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        BizDate pTumitatedtumitateymd,
        Integer pRenno
        ) {
        super(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pTumitatedtumitateymd,
            pRenno
            );
    }

    public IT_BAK_KhTumitateDKanri(String pSyono,String pTrkssikibetukey,BizDate pTumitatedtumitateymd,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pTumitatedtumitateymd,pRenno);
    }

}
