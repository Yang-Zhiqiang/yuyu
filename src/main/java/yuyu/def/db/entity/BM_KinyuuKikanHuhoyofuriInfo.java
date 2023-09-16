package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_KinyuuKikanHuhoyofuriInfo;
import yuyu.def.db.mapping.GenBM_KinyuuKikanHuhoyofuriInfo;
import yuyu.def.db.meta.GenQBM_KinyuuKikanHuhoyofuriInfo;
import yuyu.def.db.meta.QBM_KinyuuKikanHuhoyofuriInfo;

/**
 * 金融機関普保預振情報マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_KinyuuKikanHuhoyofuriInfo} の JavaDoc を参照してください。
 * @see     GenBM_KinyuuKikanHuhoyofuriInfo
 * @see     PKBM_KinyuuKikanHuhoyofuriInfo
 * @see     QBM_KinyuuKikanHuhoyofuriInfo
 * @see     GenQBM_KinyuuKikanHuhoyofuriInfo
 */
@Entity
public class BM_KinyuuKikanHuhoyofuriInfo extends GenBM_KinyuuKikanHuhoyofuriInfo {

    private static final long serialVersionUID = 1L;

    public BM_KinyuuKikanHuhoyofuriInfo() {
    }

    public BM_KinyuuKikanHuhoyofuriInfo(String pBankcd) {
        super(pBankcd);
    }

}
