package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.id.PKIT_BAK_KhHaitouKanri;
import yuyu.def.db.mapping.GenIT_BAK_KhHaitouKanri;
import yuyu.def.db.meta.GenQIT_BAK_KhHaitouKanri;
import yuyu.def.db.meta.QIT_BAK_KhHaitouKanri;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateY;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;

/**
 * 配当管理バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KhHaitouKanri} の JavaDoc を参照してください。
 * @see     GenIT_BAK_KhHaitouKanri
 * @see     PKIT_BAK_KhHaitouKanri
 * @see     QIT_BAK_KhHaitouKanri
 * @see     GenQIT_BAK_KhHaitouKanri
 */
@Entity
public class IT_BAK_KhHaitouKanri extends GenIT_BAK_KhHaitouKanri {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KhHaitouKanri() {
    }

    public IT_BAK_KhHaitouKanri(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        BizDateY pHaitounendo,
        Integer pRenno,
        C_HaitoukinsksKbn pHaitoukinskskbn,
        C_HaitoumeisaiKbn pHaitoumeisaikbn
        ) {
        super(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pHaitounendo,
            pRenno,
            pHaitoukinskskbn,
            pHaitoumeisaikbn
            );
    }

    public IT_BAK_KhHaitouKanri(String pSyono,String pTrkssikibetukey,BizDateY pHaitounendo,Integer pRenno,C_HaitoukinsksKbn pHaitoukinskskbn,C_HaitoumeisaiKbn pHaitoumeisaikbn) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pHaitounendo,pRenno, pHaitoukinskskbn,pHaitoumeisaikbn);
    }

}
