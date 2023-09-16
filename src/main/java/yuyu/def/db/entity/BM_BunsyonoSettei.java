package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_BunsyonoSettei;
import yuyu.def.db.mapping.GenBM_BunsyonoSettei;
import yuyu.def.db.meta.GenQBM_BunsyonoSettei;
import yuyu.def.db.meta.QBM_BunsyonoSettei;
import yuyu.def.classification.C_BunsyoSyubetuKbn;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_Channelcd;

/**
 * 文書番号設定マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_BunsyonoSettei} の JavaDoc を参照してください。
 * @see     GenBM_BunsyonoSettei
 * @see     PKBM_BunsyonoSettei
 * @see     QBM_BunsyonoSettei
 * @see     GenQBM_BunsyonoSettei
 */
@Entity
public class BM_BunsyonoSettei extends GenBM_BunsyonoSettei {

    private static final long serialVersionUID = 1L;

    public BM_BunsyonoSettei() {
    }

    public BM_BunsyonoSettei(
        C_BunsyoSyubetuKbn pBunsyosyubetukbn,
        C_AisyoumeiKbn pAisyoumeikbn,
        C_Channelcd pChannelcd,
        String pOyadrtencd,
        Integer pRenno
    ) {
        super(
            pBunsyosyubetukbn,
            pAisyoumeikbn,
            pChannelcd,
            pOyadrtencd,
            pRenno
        );
    }

}
