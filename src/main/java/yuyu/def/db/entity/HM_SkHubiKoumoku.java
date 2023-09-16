package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.mapping.GenHM_SkHubiKoumoku;


/**
 * 新契約不備項目マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHM_SkHubiKoumoku} の JavaDoc を参照してください。<br />
 * @see     GenHM_SkHubiKoumoku<br />
 * @see     PKHM_SkHubiKoumoku<br />
 * @see     QHM_SkHubiKoumoku<br />
 * @see     GenQHM_SkHubiKoumoku<br />
 */
@Entity
public class HM_SkHubiKoumoku extends GenHM_SkHubiKoumoku {

    private static final long serialVersionUID = 1L;

    public HM_SkHubiKoumoku() {
    }

    public HM_SkHubiKoumoku(C_SyoruiCdKbn pSyoruiCd,String pSkhubikoumokucd) {
        super(pSyoruiCd,pSkhubikoumokucd);
    }



}

