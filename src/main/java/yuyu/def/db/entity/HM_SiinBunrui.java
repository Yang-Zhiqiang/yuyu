package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenHM_SiinBunrui;


/**
 * 死因分類マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHM_SiinBunrui} の JavaDoc を参照してください。<br />
 * @see     GenHM_SiinBunrui<br />
 * @see     PKHM_SiinBunrui<br />
 * @see     QHM_SiinBunrui<br />
 * @see     GenQHM_SiinBunrui<br />
 */
@Entity
public class HM_SiinBunrui extends GenHM_SiinBunrui {

    private static final long serialVersionUID = 1L;

    public HM_SiinBunrui() {
    }

    public HM_SiinBunrui(String pSiincd) {
        super(pSiincd);
    }



}

