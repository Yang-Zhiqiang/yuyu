package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHM_SkHubiRenrakuNaiyou;
import yuyu.def.db.mapping.GenHM_SkHubiRenrakuNaiyou;
import yuyu.def.db.meta.GenQHM_SkHubiRenrakuNaiyou;
import yuyu.def.db.meta.QHM_SkHubiRenrakuNaiyou;

/**
 * 新契約不備連絡内容マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHM_SkHubiRenrakuNaiyou} の JavaDoc を参照してください。
 * @see     GenHM_SkHubiRenrakuNaiyou
 * @see     PKHM_SkHubiRenrakuNaiyou
 * @see     QHM_SkHubiRenrakuNaiyou
 * @see     GenQHM_SkHubiRenrakuNaiyou
 */
@Entity
public class HM_SkHubiRenrakuNaiyou extends GenHM_SkHubiRenrakuNaiyou {

    private static final long serialVersionUID = 1L;

    public HM_SkHubiRenrakuNaiyou() {
    }

    public HM_SkHubiRenrakuNaiyou(String pSkhubirenrakunaiyoucd) {
        super(pSkhubirenrakunaiyoucd);
    }

}
