package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.biz.bzcommon.ChkSaiteiSParam;
import yuyu.def.db.id.PKBM_ChkSaiteiS;
import yuyu.def.db.mapping.GenBM_ChkSaiteiS;
import yuyu.def.db.meta.GenQBM_ChkSaiteiS;
import yuyu.def.db.meta.QBM_ChkSaiteiS;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 最低Ｓチェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkSaiteiS} の JavaDoc を参照してください。
 * @see     GenBM_ChkSaiteiS
 * @see     PKBM_ChkSaiteiS
 * @see     QBM_ChkSaiteiS
 * @see     GenQBM_ChkSaiteiS
 */
@Entity
public class BM_ChkSaiteiS extends GenBM_ChkSaiteiS implements ChkSaiteiSParam {

    private static final long serialVersionUID = 1L;

    public BM_ChkSaiteiS() {
    }

    public BM_ChkSaiteiS(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        Integer pDntsdnumufrom,
        Integer pDntsdnumuto,
        Integer pHrkkknsmnkbnfrom,
        Integer pHrkkknsmnkbnto,
        BizNumber pHknkknfrom,
        BizNumber pHknkknto,
        Integer pSaiteisknwtkumufrom,
        Integer pSaiteisknwtkumuto,
        C_Tuukasyu pTuukasyu
        ) {
        super(
            pSyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pDntsdnumufrom,
            pDntsdnumuto,
            pHrkkknsmnkbnfrom,
            pHrkkknsmnkbnto,
            pHknkknfrom,
            pHknkknto,
            pSaiteisknwtkumufrom,
            pSaiteisknwtkumuto,
            pTuukasyu
            );
    }

}
