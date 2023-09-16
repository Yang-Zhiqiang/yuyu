package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.id.PKIT_KhHaitouKanri;
import yuyu.def.db.mapping.GenIT_KhHaitouKanri;
import yuyu.def.db.meta.GenQIT_KhHaitouKanri;
import yuyu.def.db.meta.QIT_KhHaitouKanri;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateY;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;

/**
 * 配当管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhHaitouKanri} の JavaDoc を参照してください。
 * @see     GenIT_KhHaitouKanri
 * @see     PKIT_KhHaitouKanri
 * @see     QIT_KhHaitouKanri
 * @see     GenQIT_KhHaitouKanri
 */
@Entity
public class IT_KhHaitouKanri extends GenIT_KhHaitouKanri {

    private static final long serialVersionUID = 1L;

    public IT_KhHaitouKanri() {
    }

    public IT_KhHaitouKanri(
        String pKbnkey,
        String pSyono,
        BizDateY pHaitounendo,
        Integer pRenno,
        C_HaitoukinsksKbn pHaitoukinskskbn,
        C_HaitoumeisaiKbn pHaitoumeisaikbn
        ) {
        super(
            pKbnkey,
            pSyono,
            pHaitounendo,
            pRenno,
            pHaitoukinskskbn,
            pHaitoumeisaikbn
            );
    }

    public IT_KhHaitouKanri(String pSyono, BizDateY pHaitounendo, Integer pRenno, C_HaitoukinsksKbn pHaitoukinskskbn,
        C_HaitoumeisaiKbn pHaitoumeisaikbn) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,
            pHaitounendo,
            pRenno,
            pHaitoukinskskbn,
            pHaitoumeisaikbn);
    }

}
