package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_YobidasimotoTaskKbn;
import yuyu.def.db.mapping.GenJM_SkNaiyouChk;


/**
 * 請求内容チェック判定マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJM_SkNaiyouChk} の JavaDoc を参照してください。<br />
 * @see     GenJM_SkNaiyouChk<br />
 * @see     PKJM_SkNaiyouChk<br />
 * @see     QJM_SkNaiyouChk<br />
 * @see     GenQJM_SkNaiyouChk<br />
 */
@Entity
public class JM_SkNaiyouChk extends GenJM_SkNaiyouChk {

    private static final long serialVersionUID = 1L;

    public JM_SkNaiyouChk() {
    }

    public JM_SkNaiyouChk(C_SKNaiyouChkKbn pSknaiyouchkkbn,C_YobidasimotoTaskKbn pYobidasimototaskkbn) {
        super(pSknaiyouchkkbn,pYobidasimototaskkbn);
    }



}

