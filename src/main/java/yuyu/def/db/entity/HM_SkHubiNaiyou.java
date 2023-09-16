package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenHM_SkHubiNaiyou;


/**
 * 新契約不備内容マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHM_SkHubiNaiyou} の JavaDoc を参照してください。<br />
 * @see     GenHM_SkHubiNaiyou<br />
 * @see     PKHM_SkHubiNaiyou<br />
 * @see     QHM_SkHubiNaiyou<br />
 * @see     GenQHM_SkHubiNaiyou<br />
 */
@Entity
public class HM_SkHubiNaiyou extends GenHM_SkHubiNaiyou {

    private static final long serialVersionUID = 1L;

    public HM_SkHubiNaiyou() {
    }

    public HM_SkHubiNaiyou(String pSkhubikoumokucd,String pSkhubinaiyoucd) {
        super(pSkhubikoumokucd,pSkhubinaiyoucd);
    }



}

