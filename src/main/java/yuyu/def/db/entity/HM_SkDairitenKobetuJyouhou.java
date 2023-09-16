package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenHM_SkDairitenKobetuJyouhou;


/**
 * 代理店個別情報マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHM_SkDairitenKobetuJyouhou} の JavaDoc を参照してください。<br />
 * @see     GenHM_SkDairitenKobetuJyouhou<br />
 * @see     PKHM_SkDairitenKobetuJyouhou<br />
 * @see     QHM_SkDairitenKobetuJyouhou<br />
 * @see     GenQHM_SkDairitenKobetuJyouhou<br />
 */
@Entity
public class HM_SkDairitenKobetuJyouhou extends GenHM_SkDairitenKobetuJyouhou {

    private static final long serialVersionUID = 1L;

    public HM_SkDairitenKobetuJyouhou() {
    }

    public HM_SkDairitenKobetuJyouhou(String pOyadrtencd) {
        super(pOyadrtencd);
    }



}

