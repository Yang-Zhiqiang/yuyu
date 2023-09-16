package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.mapping.GenBM_TorikomiSyoruiHukaInfo;


/**
 * 取込書類付加情報マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_TorikomiSyoruiHukaInfo} の JavaDoc を参照してください。<br />
 * @see     GenBM_TorikomiSyoruiHukaInfo<br />
 * @see     PKBM_TorikomiSyoruiHukaInfo<br />
 * @see     QBM_TorikomiSyoruiHukaInfo<br />
 * @see     GenQBM_TorikomiSyoruiHukaInfo<br />
 */
@Entity
public class BM_TorikomiSyoruiHukaInfo extends GenBM_TorikomiSyoruiHukaInfo {

    private static final long serialVersionUID = 1L;

    public BM_TorikomiSyoruiHukaInfo() {
    }

    public BM_TorikomiSyoruiHukaInfo(C_SyoruiCdKbn pSyoruiCd) {
        super(pSyoruiCd);
    }



}

