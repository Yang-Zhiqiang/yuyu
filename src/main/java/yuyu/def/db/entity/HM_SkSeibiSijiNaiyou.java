package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenHM_SkSeibiSijiNaiyou;


/**
 * 新契約整備指示内容マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHM_SkSeibiSijiNaiyou} の JavaDoc を参照してください。<br />
 * @see     GenHM_SkSeibiSijiNaiyou<br />
 * @see     PKHM_SkSeibiSijiNaiyou<br />
 * @see     QHM_SkSeibiSijiNaiyou<br />
 * @see     GenQHM_SkSeibiSijiNaiyou<br />
 */
@Entity
public class HM_SkSeibiSijiNaiyou extends GenHM_SkSeibiSijiNaiyou {

    private static final long serialVersionUID = 1L;

    public HM_SkSeibiSijiNaiyou() {
    }

    public HM_SkSeibiSijiNaiyou(String pSkseibisijinaiyoucd) {
        super(pSkseibisijinaiyoucd);
    }



}

