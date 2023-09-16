package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHM_HurikomiKouza;
import yuyu.def.db.mapping.GenHM_HurikomiKouza;
import yuyu.def.db.meta.GenQHM_HurikomiKouza;
import yuyu.def.db.meta.QHM_HurikomiKouza;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 振込口座マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHM_HurikomiKouza} の JavaDoc を参照してください。
 * @see     GenHM_HurikomiKouza
 * @see     PKHM_HurikomiKouza
 * @see     QHM_HurikomiKouza
 * @see     GenQHM_HurikomiKouza
 */
@Entity
public class HM_HurikomiKouza extends GenHM_HurikomiKouza {

    private static final long serialVersionUID = 1L;

    public HM_HurikomiKouza() {
    }

    public HM_HurikomiKouza(
        String pBankcd,
        String pSitencd,
        String pKouzano,
        C_Tuukasyu pTuukasyu,
        String pHrkmirnincd
    ) {
        super(
            pBankcd,
            pSitencd,
            pKouzano,
            pTuukasyu,
            pHrkmirnincd
        );
    }

}
